package lv.javaguru.java3OnlineBanking.core.api.clientaccounts;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.api.DomainCommandResult;

public class CreateClientAccountResult implements DomainCommandResult {

    private ClientAccountDTO clientAccount;

    public CreateClientAccountResult(ClientAccountDTO clientAccountDTO) {
        this.clientAccount = clientAccountDTO;
    }

    public ClientAccountDTO getClientAccount() {
        return clientAccount;
    }
}
