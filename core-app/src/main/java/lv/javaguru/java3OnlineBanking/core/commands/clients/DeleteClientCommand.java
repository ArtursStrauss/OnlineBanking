package lv.javaguru.java3OnlineBanking.core.commands.clients;


import lv.javaguru.java3OnlineBanking.core.commands.DomainCommand;
import lv.javaguru.java3OnlineBanking.core.commands.VoidResult;

public class DeleteClientCommand implements DomainCommand<VoidResult> {
    private Long clientId;

    public DeleteClientCommand(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
