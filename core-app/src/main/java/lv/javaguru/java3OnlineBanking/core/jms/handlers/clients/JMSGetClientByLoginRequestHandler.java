package lv.javaguru.java3OnlineBanking.core.jms.handlers.clients;

import lv.javaguru.java3OnlineBanking.core.api.jms.JMSRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.SupportedCommandId;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.JMSGetClientByLoginRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.JMSGetClientByLoginResponse;
import lv.javaguru.java3OnlineBanking.core.commands.clients.GetClientByLoginCommand;
import lv.javaguru.java3OnlineBanking.core.commands.clients.GetClientByLoginResult;
import lv.javaguru.java3OnlineBanking.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class JMSGetClientByLoginRequestHandler extends JMSRequestHandler {


    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_CLIENT_BY_LOGIN;
    }

    @Override
    public String process(JMSRequest jmsRequest) {
        JMSGetClientByLoginRequest jmsCommand = mapRequest(jmsRequest, JMSGetClientByLoginRequest.class);

        GetClientByLoginCommand coreCommand = new GetClientByLoginCommand(jmsCommand.getLogin());
        GetClientByLoginResult coreResult = executeCoreCommand(coreCommand);

        JMSGetClientByLoginResponse jmsResponse = new JMSGetClientByLoginResponse();
        jmsResponse.setClientDTO(coreResult.getClient());
        return buildPayload(jmsResponse);
    }


}
