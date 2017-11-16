package lv.javaguru.java3OnlineBanking.core.api.clientaccounts;

import lv.javaguru.java3OnlineBanking.core.api.DomainCommand;
import lv.javaguru.java3OnlineBanking.core.api.VoidResult;

public class DeleteClientAccountCommand implements DomainCommand<VoidResult> {
    private Long clientAccountId;

    public DeleteClientAccountCommand(Long clientAccountId) {
        this.clientAccountId = clientAccountId;
    }

    public Long getClientAccountId() {
        return clientAccountId;
    }
}

