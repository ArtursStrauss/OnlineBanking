package lv.javaguru.java3OnlineBanking.integrations.rest;


import lv.javaguru.java3OnlineBanking.core.api.CommandExecutor;
import lv.javaguru.java3OnlineBanking.core.api.clientaccounttransactions.CreateClientAccountTransactionCommand;
import lv.javaguru.java3OnlineBanking.core.api.clientaccounttransactions.CreateClientAccountTransactionResult;
import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = RESTResource.API_PATH)
public class ClientAccountTransactionResourceImpl {

    @Autowired
    private CommandExecutor commandExecutor;

    @RequestMapping(value = "/client/account/transactions", method = RequestMethod.POST)
    public ResponseEntity<ClientAccountTransactionDTO> create(@Valid @RequestBody ClientAccountTransactionDTO clientAccountTransactionDTO) {

        CreateClientAccountTransactionCommand command = new CreateClientAccountTransactionCommand(
                clientAccountTransactionDTO.getClient(),
                clientAccountTransactionDTO.getClientAccount(),
                clientAccountTransactionDTO.getTransactionType(),
                clientAccountTransactionDTO.getAmount(),
                clientAccountTransactionDTO.getCurrency()
        );

        CreateClientAccountTransactionResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getClientAccountTransaction());
    }
}
