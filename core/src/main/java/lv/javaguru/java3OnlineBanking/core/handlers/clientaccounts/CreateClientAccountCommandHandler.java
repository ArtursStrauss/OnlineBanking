package lv.javaguru.java3OnlineBanking.core.handlers.clientaccounts;

import lv.javaguru.java3OnlineBanking.core.api.clientaccounts.CreateClientAccountCommand;
import lv.javaguru.java3OnlineBanking.core.api.clientaccounts.CreateClientAccountResult;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.handlers.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounts.ClientAccountFactory;
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
