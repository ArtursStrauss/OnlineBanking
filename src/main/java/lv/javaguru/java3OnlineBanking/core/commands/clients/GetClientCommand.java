package lv.javaguru.java3OnlineBanking.core.commands.clients;

import lv.javaguru.java3OnlineBanking.core.commands.clients.api.DomainCommand;

public class GetClientCommand implements DomainCommand<GetClientResult> {

    private Long clientId;

    public GetClientCommand(Long clientId){
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
