package lv.javaguru.java3OnlineBanking.core.commands.clientAccount;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.services.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clientAccounts.api.ClientAccountFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateClientAccountCommandHandler implements DomainCommandHandler<CreateClientAccountCommand, CreateClientAccountResult> {

    @Autowired
    private ClientAccountFactory clientAccountFactory;
    @Autowired
    private ClientAccountConverter clientAccountConverter;

    @Override
    public CreateClientAccountResult execute(CreateClientAccountCommand command) {
        ClientAccount clientAccount = clientAccountFactory.create(
                command.getCurrency(),
                command.getClient()
        );

        ClientAccountDTO clientAccountDTO = clientAccountConverter.convert(clientAccount);
        return new CreateClientAccountResult(clientAccountDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateClientAccountCommand.class;
    }
}
