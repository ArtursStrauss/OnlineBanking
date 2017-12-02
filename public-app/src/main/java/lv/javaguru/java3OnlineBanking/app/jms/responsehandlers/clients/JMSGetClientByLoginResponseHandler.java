package lv.javaguru.java3OnlineBanking.app.jms.responsehandlers.clients;

import lv.javaguru.java3OnlineBanking.app.common.JsonMapper;
import lv.javaguru.java3OnlineBanking.app.jms.JMSResponseHandler;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSResponse;
import lv.javaguru.java3OnlineBanking.core.api.jms.SupportedCommandId;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.JMSGetClientByLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JMSGetClientByLoginResponseHandler implements JMSResponseHandler {

    @Autowired
    private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_CLIENT_BY_LOGIN;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSGetClientByLoginResponse response = jsonMapper.mapToObject(
                payload,
                JMSGetClientByLoginResponse.class
        );
        return ResponseEntity.ok(response.getClientDTO());
    }

}
