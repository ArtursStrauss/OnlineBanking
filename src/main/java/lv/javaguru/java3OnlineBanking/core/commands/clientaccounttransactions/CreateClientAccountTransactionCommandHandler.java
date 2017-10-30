package lv.javaguru.java3OnlineBanking.core.commands.clientaccounttransactions;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransaction;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountTransactionDTO;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions.api.ClientAccountTransactionFactory;
import lv.javaguru.java3OnlineBanking.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateClientAccountTransactionCommandHandler implements DomainCommandHandler<CreateClientAccountTransactionCommand, CreateClientAccountTransactionResult> {

    @Autowired
    private ClientAccountTransactionFactory clientAccountTransactionFactory;
    @Autowired
    private ClientAccountTransactionConverter clientAccountTransactionConverter;

    @Override
    public CreateClientAccountTransactionResult execute(CreateClientAccountTransactionCommand command) {

        ClientAccountTransaction clientAccountTransaction = clientAccountTransactionFactory.create(
                command.getClientDTO(),
                command.getClientAccountDTO(),
                command.getTransactionType(),
                command.getAmount(),
                command.getCurrency(),
                command.getResultBalance(),
                command.getStatus()
        );

        ClientAccountTransactionDTO clientAccountTransactionDTO = clientAccountTransactionConverter.convert(clientAccountTransaction);
        return new CreateClientAccountTransactionResult(clientAccountTransactionDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateClientAccountTransactionCommand.class;
    }
}
