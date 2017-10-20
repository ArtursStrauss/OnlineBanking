package lv.javaguru.java3OnlineBanking.core.commands.clients;

import lv.javaguru.java3OnlineBanking.core.commands.VoidResult;
import lv.javaguru.java3OnlineBanking.core.services.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clients.api.ClientService;
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
