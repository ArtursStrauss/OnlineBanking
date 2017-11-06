package lv.javaguru.java3OnlineBanking.core.handlers.clients;

import lv.javaguru.java3OnlineBanking.core.api.VoidResult;
import lv.javaguru.java3OnlineBanking.core.api.clients.DeleteClientCommand;
import lv.javaguru.java3OnlineBanking.core.handlers.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clients.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteClientCommandHandler implements DomainCommandHandler<DeleteClientCommand, VoidResult> {

    @Autowired
    private ClientService clientService;

    @Override
    public VoidResult execute(DeleteClientCommand command) {
        clientService.delete(command.getClientId());
        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return DeleteClientCommand.class;
    }
}
