package lv.javaguru.java3OnlineBanking.core.commands.clientAccounts;

import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommandResult;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;

import java.util.List;

public class GetClientAccountsByClientIdResult implements DomainCommandResult {

    private List<ClientAccountDTO> clientAccountDTOs;

    public GetClientAccountsByClientIdResult(List<ClientAccountDTO> clientAccountDTOs){
        this.clientAccountDTOs = clientAccountDTOs;
    }

    public List<ClientAccountDTO> getClientAccountDTOs() {
        return clientAccountDTOs;
    }
}
