package lv.javaguru.java3OnlineBanking.core.commands.clients;

import lv.javaguru.java3OnlineBanking.core.commands.VoidResult;
import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommand;

public class DeleteClientCommand implements DomainCommand<VoidResult> {
    private Long clientId;

    public DeleteClientCommand(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
