package lv.javaguru.java3OnlineBanking.core.handlers.clients;


import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.api.clients.GetClientCommand;
import lv.javaguru.java3OnlineBanking.core.api.clients.GetClientResult;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.handlers.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clients.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetClientCommandHandler implements DomainCommandHandler<GetClientCommand, GetClientResult> {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConverter clientConverter;


    @Override
    public GetClientResult execute(GetClientCommand command) {
        Client client = clientService.get(command.getClientId());
        ClientDTO clientDTO = clientConverter.convert(client);
        return new GetClientResult(clientDTO);
    }

    @Override
    public Class getCommandType() {
        return GetClientCommand.class;
    }
}
