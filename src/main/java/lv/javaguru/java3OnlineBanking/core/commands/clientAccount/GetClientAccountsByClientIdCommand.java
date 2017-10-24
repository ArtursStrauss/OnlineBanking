package lv.javaguru.java3OnlineBanking.core.commands.clientAccount;

import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommand;

public class GetClientAccountsByClientIdCommand implements DomainCommand<GetClientAccountsByClientIdResult> {

    private Long clientId;

    public GetClientAccountsByClientIdCommand(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
