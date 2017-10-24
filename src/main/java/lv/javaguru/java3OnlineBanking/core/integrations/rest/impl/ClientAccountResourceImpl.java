package lv.javaguru.java3OnlineBanking.core.integrations.rest.impl;


import lv.javaguru.java3OnlineBanking.core.commands.VoidResult;
import lv.javaguru.java3OnlineBanking.core.commands.clientAccount.CreateClientAccountCommand;
import lv.javaguru.java3OnlineBanking.core.commands.clientAccount.CreateClientAccountResult;
import lv.javaguru.java3OnlineBanking.core.commands.clientAccount.DeleteClientAccountCommand;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.api.RESTResource;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = RESTResource.API_PATH)
public class ClientAccountResourceImpl {

    @Autowired
    private CommandExecutor commandExecutor;

    @RequestMapping(value = "/client/accounts", method = RequestMethod.POST)
    public ResponseEntity<ClientAccountDTO> create(@RequestBody ClientAccountDTO clientAccountDTO) {

        CreateClientAccountCommand command = new CreateClientAccountCommand(
                clientAccountDTO.getCurrency(),
                clientAccountDTO.getClientId()
        );

        CreateClientAccountResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getClientAccount());
    }

    @RequestMapping(value = "/client/account/{clientAccountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("clientAccountId") Long clientAccountId) {
        DeleteClientAccountCommand command = new DeleteClientAccountCommand(clientAccountId);
        VoidResult result = commandExecutor.execute(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
