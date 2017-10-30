package lv.javaguru.java3OnlineBanking.core.commands.clientaccounts;

import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommandResult;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;

public class CreateClientAccountResult implements DomainCommandResult {

    private ClientAccountDTO clientAccount;

    public CreateClientAccountResult(ClientAccountDTO clientAccountDTO) {
        this.clientAccount = clientAccountDTO;
    }

    public ClientAccountDTO getClientAccount() {
        return clientAccount;
    }
}
