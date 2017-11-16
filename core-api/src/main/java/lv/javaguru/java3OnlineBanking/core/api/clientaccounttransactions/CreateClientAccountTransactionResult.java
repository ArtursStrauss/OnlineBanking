package lv.javaguru.java3OnlineBanking.core.api.clientaccounttransactions;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountTransactionDTO;
import lv.javaguru.java3OnlineBanking.core.api.DomainCommandResult;

public class CreateClientAccountTransactionResult implements DomainCommandResult {

    private ClientAccountTransactionDTO clientAccountTransactionDTO;

    public CreateClientAccountTransactionResult(ClientAccountTransactionDTO clientAccountTransactionDTO){
        this.clientAccountTransactionDTO = clientAccountTransactionDTO;
    }

    public ClientAccountTransactionDTO getClientAccountTransaction() {
        return clientAccountTransactionDTO;
    }
}
