package lv.javaguru.java3OnlineBanking.app.jms.responsehandlers.exceptions;

import lv.javaguru.java3OnlineBanking.app.common.JsonMapper;
import lv.javaguru.java3OnlineBanking.app.jms.JMSResponseHandler;
import lv.javaguru.java3OnlineBanking.core.api.jms.CoreExceptionTypes;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSResponse;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.exceptions.JMSResourceNotFoundErrorResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class JMSResourceNotFoundErrorResponseHandler implements JMSResponseHandler {

    private static final Logger log = getLogger(JMSResourceNotFoundErrorResponseHandler.class);

    @Autowired
    private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return CoreExceptionTypes.RESOURCE_NOT_FOUND_ERROR;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {

        log.info(jmsResponse.toString());

        String payload = jmsResponse.getPayload();

        log.info(payload);

        JMSResourceNotFoundErrorResponse response = jsonMapper.mapToObject(payload, JMSResourceNotFoundErrorResponse.class);

        return ResponseEntity.ok(response.getApplicationErrorDTO());
    }
}
