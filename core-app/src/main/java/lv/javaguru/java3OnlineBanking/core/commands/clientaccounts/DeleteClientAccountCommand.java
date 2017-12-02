package lv.javaguru.java3OnlineBanking.core.commands.clientaccounts;

import lv.javaguru.java3OnlineBanking.core.commands.DomainCommand;
import lv.javaguru.java3OnlineBanking.core.commands.VoidResult;

public class DeleteClientAccountCommand implements DomainCommand<VoidResult> {
    private Long clientAccountId;

    public DeleteClientAccountCommand(Long clientAccountId) {
        this.clientAccountId = clientAccountId;
    }

    public Long getClientAccountId() {
        return clientAccountId;
    }
}

