package lv.javaguru.java3OnlineBanking.core.handlers.clients;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.api.clients.UpdateClientCommand;
import lv.javaguru.java3OnlineBanking.core.api.clients.UpdateClientResult;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.handlers.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clients.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientCommandHandler implements DomainCommandHandler<UpdateClientCommand, UpdateClientResult> {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConverter clientConverter;

    @Override
    public UpdateClientResult execute(UpdateClientCommand command) {
        Client client = clientService.update(
                command.getId(),
                command.getLogin(),
                command.getPassword(),
                command.getFullName()
        );
        ClientDTO clientDTO = clientConverter.convert(client);
        return new UpdateClientResult(clientDTO);
    }

    @Override
    public Class getCommandType() {
        return UpdateClientCommand.class;
    }
}
