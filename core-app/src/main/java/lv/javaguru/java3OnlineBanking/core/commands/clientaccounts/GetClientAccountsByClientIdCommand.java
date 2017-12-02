package lv.javaguru.java3OnlineBanking.core.commands.clientaccounts;


import lv.javaguru.java3OnlineBanking.core.commands.DomainCommand;

public class GetClientAccountsByClientIdCommand implements DomainCommand<GetClientAccountsByClientIdResult> {

    private Long clientId;

    public GetClientAccountsByClientIdCommand(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
