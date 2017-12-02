package lv.javaguru.java3OnlineBanking.app.jms.send;

import lv.javaguru.java3OnlineBanking.app.jms.JMSResponseHandler;
import lv.javaguru.java3OnlineBanking.app.rest.DeferredResultHolder;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.InternalServerException;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

public interface JMSResponseProcessor {
    void process(JMSResponse response);
}


@Component
class JMSResponseProcessorImpl implements JMSResponseProcessor {

    @Autowired
    private List<JMSResponseHandler> responseHandlers;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void process(JMSResponse jmsResponse) {
        if (jmsResponse.isSuccess()) {
            processSuccessfulResponse(jmsResponse);
        } else {
            processFailedResponse(jmsResponse);
        }
    }

    private void processSuccessfulResponse(JMSResponse jmsResponse) {
        ResponseEntity responseEntity = responseHandlers.stream()
                .filter(ch -> ch.canProcess(jmsResponse))
                .findFirst()
                .orElseThrow(InternalServerException::new)
                .process(jmsResponse);
        process(jmsResponse, responseEntity);
    }

    private void processFailedResponse(JMSResponse jmsResponse) {
        ResponseEntity responseEntity = responseHandlers.stream()
                .filter(ch -> ch.getSupportedCommandId().equals(jmsResponse.getError()))
                .findFirst()
                .orElseThrow(InternalServerException::new)
                .process(jmsResponse);
        process(jmsResponse, responseEntity);
    }

    private void process(JMSResponse jmsResponse,
                         ResponseEntity responseEntity) {
        deferredResultHolder.get(jmsResponse.getCorrelationId())
                .orElseThrow(InternalServerException::new)
                .setResult(responseEntity);
    }
}