package lv.javaguru.java3OnlineBanking.integrations.rest;


import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.api.CommandExecutor;
import lv.javaguru.java3OnlineBanking.core.api.VoidResult;
import lv.javaguru.java3OnlineBanking.core.api.clientaccounts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = RESTResource.API_PATH)
public class ClientAccountResourceImpl {

    @Autowired
    private CommandExecutor commandExecutor;

    @RequestMapping(value = "/client/accounts", method = RequestMethod.POST)
    public ResponseEntity<ClientAccountDTO> create(@Valid @RequestBody ClientAccountDTO clientAccountDTO) {

        CreateClientAccountCommand command = new CreateClientAccountCommand(
                clientAccountDTO.getCurrency(),
                clientAccountDTO.getClient()
        );

        CreateClientAccountResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getClientAccount());
    }

    @RequestMapping(value = "/client/{clientId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<List<ClientAccountDTO>> getAllClientAccounts(@PathVariable("clientId") Long clientId) {

        GetClientAccountsByClientIdCommand command = new GetClientAccountsByClientIdCommand(clientId);

        GetClientAccountsByClientIdResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getClientAccountDTOs());
    }

    @RequestMapping(value = "/client/account/{clientAccountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("clientAccountId") Long clientAccountId) {
        DeleteClientAccountCommand command = new DeleteClientAccountCommand(clientAccountId);
        VoidResult result = commandExecutor.execute(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
