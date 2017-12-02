package lv.javaguru.java3OnlineBanking.core.jms;

import lv.javaguru.java3OnlineBanking.core.api.jms.JMSRequest;
import lv.javaguru.java3OnlineBanking.core.commands.DomainCommand;
import lv.javaguru.java3OnlineBanking.core.commands.DomainCommandResult;
import lv.javaguru.java3OnlineBanking.core.commons.JsonMapper;
import lv.javaguru.java3OnlineBanking.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class JMSRequestHandler {

    @Autowired
    protected JsonMapper jsonMapper;
    @Autowired
    protected CommandExecutor commandExecutor;

    public abstract String getSupportedCommandId();

    public boolean canProcess(JMSRequest jmsRequest) {
        return jmsRequest.getCommandId().equals(getSupportedCommandId());
    }

    public abstract String process(JMSRequest jmsRequest);

    public <T> T mapRequest(JMSRequest jmsRequest, Class<T> clazz) {
        String payload = jmsRequest.getPayload();
        return jsonMapper.mapToObject(payload, clazz);
    }

    protected <C extends DomainCommand<T>, T extends DomainCommandResult> T executeCoreCommand(DomainCommand<T> coreCommand) {
        return commandExecutor.execute(coreCommand);
    }

    protected String buildPayload(Object jmsResponse) {
        return jsonMapper.mapToString(jmsResponse);
    }
}
