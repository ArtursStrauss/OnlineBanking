package lv.javaguru.java3OnlineBanking.core.handlers.clientaccounttransactions;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountTransactionDTO;
import lv.javaguru.java3OnlineBanking.core.api.clientaccounttransactions.CreateClientAccountTransactionCommand;
import lv.javaguru.java3OnlineBanking.core.api.clientaccounttransactions.CreateClientAccountTransactionResult;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransaction;
import lv.javaguru.java3OnlineBanking.core.handlers.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions.ClientAccountTransactionFactory;
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
                command.getCurrency()
        );

        ClientAccountTransactionDTO clientAccountTransactionDTO = clientAccountTransactionConverter.convert(clientAccountTransaction);
        return new CreateClientAccountTransactionResult(clientAccountTransactionDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateClientAccountTransactionCommand.class;
    }
}
