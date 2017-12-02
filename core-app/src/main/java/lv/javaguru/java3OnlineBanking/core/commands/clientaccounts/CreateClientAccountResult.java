package lv.javaguru.java3OnlineBanking.core.commands.clientaccounts;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.commands.DomainCommandResult;

public class CreateClientAccountResult implements DomainCommandResult {

    private ClientAccountDTO clientAccount;

    public CreateClientAccountResult(ClientAccountDTO clientAccountDTO) {
        this.clientAccount = clientAccountDTO;
    }

    public ClientAccountDTO getClientAccount() {
        return clientAccount;
    }
}
