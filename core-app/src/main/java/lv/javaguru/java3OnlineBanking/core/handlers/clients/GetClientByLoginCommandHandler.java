package lv.javaguru.java3OnlineBanking.core.handlers.clients;


import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.commands.clients.GetClientByLoginCommand;
import lv.javaguru.java3OnlineBanking.core.commands.clients.GetClientByLoginResult;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.handlers.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clients.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetClientByLoginCommandHandler implements DomainCommandHandler<GetClientByLoginCommand, GetClientByLoginResult> {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConverter clientConverter;


    @Override
    public GetClientByLoginResult execute(GetClientByLoginCommand command) {
        Client client = clientService.getByLogin(command.getLogin());
        ClientDTO clientDTO = clientConverter.convert(client);
        return new GetClientByLoginResult(clientDTO);
    }

    @Override
    public Class getCommandType() {
        return GetClientByLoginCommand.class;
    }
}
