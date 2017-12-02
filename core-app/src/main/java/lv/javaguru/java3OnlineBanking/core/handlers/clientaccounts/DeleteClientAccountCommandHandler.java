package lv.javaguru.java3OnlineBanking.core.handlers.clientaccounts;

import lv.javaguru.java3OnlineBanking.core.commands.VoidResult;
import lv.javaguru.java3OnlineBanking.core.commands.clientaccounts.DeleteClientAccountCommand;
import lv.javaguru.java3OnlineBanking.core.handlers.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounts.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteClientAccountCommandHandler implements DomainCommandHandler<DeleteClientAccountCommand, VoidResult> {

    @Autowired
    private ClientAccountService clientAccountService;

    @Override
    public VoidResult execute(DeleteClientAccountCommand command) {
        clientAccountService.delete(command.getClientAccountId());
        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return DeleteClientAccountCommand.class;
    }
}
