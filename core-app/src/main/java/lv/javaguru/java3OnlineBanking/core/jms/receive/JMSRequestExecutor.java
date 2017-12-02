package lv.javaguru.java3OnlineBanking.core.jms.receive;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.ApplicationException;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.InternalServerException;
import lv.javaguru.java3OnlineBanking.core.jms.JMSRequestExceptionHandler;
import lv.javaguru.java3OnlineBanking.core.jms.JMSRequestHandler;
import lv.javaguru.java3OnlineBanking.core.jms.send.JMSResponseBuilder;
import org.slf4j.Logger;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public interface JMSRequestExecutor {
    JMSResponse execute(JMSRequest request);
}

@Component
class JMSRequestExecutorImpl implements JMSRequestExecutor {

    private static final Logger log = getLogger(JMSRequestExecutorImpl.class);

    @Autowired
    private List<JMSRequestHandler> requestHandlers;
    @Autowired
    private List<JMSRequestExceptionHandler> requestExceptionHandlers;
    @Autowired
    private JMSResponseBuilder responseBuilder;

    @Override
    public JMSResponse execute(JMSRequest request) {
        try {
            String payload = selectHandlerAndProcessRequest(request);
            return responseBuilder.buildSuccess(request, payload);
        } catch (ApplicationException e) {
            String payload = selectExceptionHandlerAndProcessException(e);
            log.error("Application exception", e);
            return responseBuilder.buildFail(request, payload, e);
        } catch (RuntimeException e) {
            log.error("Runtime exception", e);
            return responseBuilder.buildFail(request, e);
        }

    }

    private String selectHandlerAndProcessRequest(JMSRequest request) {
        return requestHandlers.stream()
                .filter(ch -> ch.canProcess(request))
                .findFirst()
                .orElseThrow(InternalServerException::new)
                .process(request);
    }

    private String selectExceptionHandlerAndProcessException(ApplicationException exception) {
        return requestExceptionHandlers.stream()
                .filter(ch -> ch.canProcess(exception))
                .findFirst()
                .orElseThrow(InternalServerException::new)
                .process(exception);
    }
}