package lv.javaguru.java3OnlineBanking.core.integrations.rest.impl;


import lv.javaguru.java3OnlineBanking.core.commands.clients.CreateClientCommand;
import lv.javaguru.java3OnlineBanking.core.commands.clients.CreateClientResult;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.api.RESTResource;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RESTResource.API_PATH)
public class ClientResourceImpl {

    @Autowired
    private CommandExecutor commandExecutor;

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO) {
        CreateClientCommand command = new CreateClientCommand(
                clientDTO.getLogin(),
                clientDTO.getPassword(),
                clientDTO.getFullName()
        );
        CreateClientResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getClient());
    }
}
