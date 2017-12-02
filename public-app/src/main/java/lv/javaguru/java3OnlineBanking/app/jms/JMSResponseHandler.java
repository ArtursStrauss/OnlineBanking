package lv.javaguru.java3OnlineBanking.app.jms;

import lv.javaguru.java3OnlineBanking.core.api.jms.JMSResponse;
import org.springframework.http.ResponseEntity;

public interface JMSResponseHandler {

    String getSupportedCommandId();

    default boolean canProcess(JMSResponse response) {
        return response.getCommandId().equals(getSupportedCommandId());
    }

    ResponseEntity process(JMSResponse jmsResponse);
}
