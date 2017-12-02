package lv.javaguru.java3OnlineBanking.core.commands.clientaccounttransactions;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountTransactionDTO;
import lv.javaguru.java3OnlineBanking.core.commands.DomainCommandResult;

public class CreateClientAccountTransactionResult implements DomainCommandResult {

    private ClientAccountTransactionDTO clientAccountTransactionDTO;

    public CreateClientAccountTransactionResult(ClientAccountTransactionDTO clientAccountTransactionDTO){
        this.clientAccountTransactionDTO = clientAccountTransactionDTO;
    }

    public ClientAccountTransactionDTO getClientAccountTransaction() {
        return clientAccountTransactionDTO;
    }
}
