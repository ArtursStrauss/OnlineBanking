package lv.javaguru.java3OnlineBanking.core.integrations.rest.impl;


import lv.javaguru.java3OnlineBanking.core.commands.VoidResult;
import lv.javaguru.java3OnlineBanking.core.commands.clients.*;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.api.RESTResource;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        System.out.println(clientDTO.getPassword());
        CreateClientResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getClient());
    }

    @RequestMapping(value = "/clients", method = RequestMethod.PUT)
    public ResponseEntity<ClientDTO> put(@RequestBody ClientDTO clientDTO) {
        UpdateClientCommand command = new UpdateClientCommand(
                clientDTO.getId(),
                clientDTO.getLogin(),
                clientDTO.getPassword(),
                clientDTO.getFullName());
        UpdateClientResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getClient());
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<ClientDTO> get(@PathVariable("clientId") Long clientId) {
        GetClientCommand command = new GetClientCommand(clientId);
        GetClientResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getClient());
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("clientId") Long clientId) {
        DeleteClientCommand command = new DeleteClientCommand(clientId);
        VoidResult result = commandExecutor.execute(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
