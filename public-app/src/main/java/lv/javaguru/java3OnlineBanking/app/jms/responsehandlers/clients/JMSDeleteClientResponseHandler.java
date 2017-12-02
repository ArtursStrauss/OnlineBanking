package lv.javaguru.java3OnlineBanking.app.jms.responsehandlers.clients;

import lv.javaguru.java3OnlineBanking.app.jms.JMSResponseHandler;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSResponse;
import lv.javaguru.java3OnlineBanking.core.api.jms.SupportedCommandId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JMSDeleteClientResponseHandler implements JMSResponseHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.DELETE_CLIENT;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        return ResponseEntity.ok(null);
    }

}
