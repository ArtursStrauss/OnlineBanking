package lv.javaguru.java3OnlineBanking.core.jms.handlers.clients;

import lv.javaguru.java3OnlineBanking.core.api.jms.JMSRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.SupportedCommandId;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.JMSDeleteClientRequest;
import lv.javaguru.java3OnlineBanking.core.commands.VoidResult;
import lv.javaguru.java3OnlineBanking.core.commands.clients.DeleteClientCommand;
import lv.javaguru.java3OnlineBanking.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class JMSDeleteClientRequestHandler extends JMSRequestHandler {


    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.DELETE_CLIENT;
    }

    @Override
    public String process(JMSRequest jmsRequest) {
        JMSDeleteClientRequest jmsCommand = mapRequest(jmsRequest, JMSDeleteClientRequest.class);

        DeleteClientCommand coreCommand = new DeleteClientCommand(jmsCommand.getClientId());
        VoidResult coreResult = executeCoreCommand(coreCommand);

        return null;
    }


}
