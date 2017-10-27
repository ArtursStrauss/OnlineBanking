package lv.javaguru.java3OnlineBanking.core.commands.clientAccountTransactions;

import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommandResult;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountTransactionDTO;

public class CreateClientAccountTransactionResult implements DomainCommandResult{

    private ClientAccountTransactionDTO clientAccountTransactionDTO;

    public CreateClientAccountTransactionResult(ClientAccountTransactionDTO clientAccountTransactionDTO){
        this.clientAccountTransactionDTO = clientAccountTransactionDTO;
    }

    public ClientAccountTransactionDTO getClientAccountTransaction() {
        return clientAccountTransactionDTO;
    }
}
