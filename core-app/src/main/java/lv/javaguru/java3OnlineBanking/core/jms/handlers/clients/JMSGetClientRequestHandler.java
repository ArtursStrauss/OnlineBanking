package lv.javaguru.java3OnlineBanking.core.jms.handlers.clients;

import lv.javaguru.java3OnlineBanking.core.api.jms.JMSRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.SupportedCommandId;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.JMSGetClientRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.JMSGetClientResponse;
import lv.javaguru.java3OnlineBanking.core.commands.clients.GetClientCommand;
import lv.javaguru.java3OnlineBanking.core.commands.clients.GetClientResult;
import lv.javaguru.java3OnlineBanking.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class JMSGetClientRequestHandler extends JMSRequestHandler {


    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_CLIENT;
    }

    @Override
    public String process(JMSRequest jmsRequest) {
        JMSGetClientRequest jmsCommand = mapRequest(jmsRequest, JMSGetClientRequest.class);

        GetClientCommand coreCommand = new GetClientCommand(jmsCommand.getClientId());
        GetClientResult coreResult = executeCoreCommand(coreCommand);

        JMSGetClientResponse jmsResponse = new JMSGetClientResponse();
        jmsResponse.setClientDTO(coreResult.getClient());
        return buildPayload(jmsResponse);
    }


}
