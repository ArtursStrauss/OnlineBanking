package lv.javaguru.java3OnlineBanking.core.handlers.clients;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.commands.clients.CreateClientCommand;
import lv.javaguru.java3OnlineBanking.core.commands.clients.CreateClientResult;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.handlers.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clients.ClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateClientCommandHandler implements DomainCommandHandler<CreateClientCommand, CreateClientResult> {

    @Autowired
    private ClientFactory clientFactory;
    @Autowired
    private ClientConverter clientConverter;

    @Override
    public CreateClientResult execute(CreateClientCommand command) {
        Client client = clientFactory.create(
                command.getLogin(),
                command.getPassword(),
                command.getFullName()
        );

        ClientDTO clientDTO = clientConverter.convert(client);
        return new CreateClientResult(clientDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateClientCommand.class;
    }
}
