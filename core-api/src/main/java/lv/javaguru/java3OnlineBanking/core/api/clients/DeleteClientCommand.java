package lv.javaguru.java3OnlineBanking.core.api.clients;


import lv.javaguru.java3OnlineBanking.core.api.DomainCommand;
import lv.javaguru.java3OnlineBanking.core.api.VoidResult;

public class DeleteClientCommand implements DomainCommand<VoidResult> {
    private Long clientId;

    public DeleteClientCommand(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
