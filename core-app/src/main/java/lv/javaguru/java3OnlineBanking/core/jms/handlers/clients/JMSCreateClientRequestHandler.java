package lv.javaguru.java3OnlineBanking.core.jms.handlers.clients;

import lv.javaguru.java3OnlineBanking.core.api.jms.JMSRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.SupportedCommandId;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.JMSCreateClientRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.JMSCreateClientResponse;
import lv.javaguru.java3OnlineBanking.core.commands.clients.CreateClientCommand;
import lv.javaguru.java3OnlineBanking.core.commands.clients.CreateClientResult;
import lv.javaguru.java3OnlineBanking.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class JMSCreateClientRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.CREATE_CLIENT;
    }

    @Override
    public String process(JMSRequest jmsRequest) {
        JMSCreateClientRequest jmsCommand = mapRequest(jmsRequest, JMSCreateClientRequest.class);

        CreateClientCommand coreCommand = new CreateClientCommand(jmsCommand.getClientDTO().getLogin(),
                jmsCommand.getClientDTO().getPassword(),
                jmsCommand.getClientDTO().getFullName());
        CreateClientResult coreResult = executeCoreCommand(coreCommand);

        JMSCreateClientResponse jmsResponse = new JMSCreateClientResponse();
        jmsResponse.setClientDTO(coreResult.getClient());
        return buildPayload(jmsResponse);
    }
}
