package lv.javaguru.java3OnlineBanking.core.jms.handlers.clients;

import lv.javaguru.java3OnlineBanking.core.api.jms.JMSRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.SupportedCommandId;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.JMSUpdateClientRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.JMSUpdateClientResponse;
import lv.javaguru.java3OnlineBanking.core.commands.clients.UpdateClientCommand;
import lv.javaguru.java3OnlineBanking.core.commands.clients.UpdateClientResult;
import lv.javaguru.java3OnlineBanking.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class JMSUpdateClientRequestHandler extends JMSRequestHandler {
    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.UPDATE_CLIENT;
    }

    @Override
    public String process(JMSRequest jmsRequest) {
        JMSUpdateClientRequest jmsCommand = mapRequest(jmsRequest, JMSUpdateClientRequest.class);

        UpdateClientCommand coreCommand = new UpdateClientCommand(jmsCommand.getClientDTO().getId(),
                jmsCommand.getClientDTO().getLogin(),
                jmsCommand.getClientDTO().getPassword(),
                jmsCommand.getClientDTO().getFullName());
        UpdateClientResult coreResult = executeCoreCommand(coreCommand);

        JMSUpdateClientResponse jmsResponse = new JMSUpdateClientResponse();
        jmsResponse.setClientDTO(coreResult.getClient());
        return buildPayload(jmsResponse);
    }
}
