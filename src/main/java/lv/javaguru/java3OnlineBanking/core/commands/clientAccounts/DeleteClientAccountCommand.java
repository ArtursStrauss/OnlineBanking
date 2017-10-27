package lv.javaguru.java3OnlineBanking.core.commands.clientAccounts;

import lv.javaguru.java3OnlineBanking.core.commands.VoidResult;
import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommand;

public class DeleteClientAccountCommand implements DomainCommand<VoidResult> {
    private Long clientAccountId;

    public DeleteClientAccountCommand(Long clientAccountId) {
        this.clientAccountId = clientAccountId;
    }

    public Long getClientAccountId() {
        return clientAccountId;
    }
}

