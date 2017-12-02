package lv.javaguru.java3OnlineBanking.core.commands.clientaccounts;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.commands.DomainCommandResult;

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
