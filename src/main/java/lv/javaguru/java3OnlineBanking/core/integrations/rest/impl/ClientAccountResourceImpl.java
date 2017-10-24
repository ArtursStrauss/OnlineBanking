package lv.javaguru.java3OnlineBanking.core.integrations.rest.impl;


import lv.javaguru.java3OnlineBanking.core.commands.clientAccount.CreateClientAccountCommand;
import lv.javaguru.java3OnlineBanking.core.commands.clientAccount.CreateClientAccountResult;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.api.RESTResource;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
}
