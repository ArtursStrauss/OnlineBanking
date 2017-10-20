package lv.javaguru.java3OnlineBanking.core.commands.clients;

import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.services.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clients.api.ClientFactory;
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