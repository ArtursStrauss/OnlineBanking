package lv.javaguru.java3OnlineBanking.app.rest.controllers;


import lv.javaguru.java3OnlineBanking.app.jms.receive.JMSRequestProcessor;
import lv.javaguru.java3OnlineBanking.app.rest.RESTResource;
import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.client.*;
//import lv.javaguru.java3OnlineBanking.core.services.CommandExecutor;
//import lv.javaguru.java3OnlineBanking.core.commands.VoidResult;
//import lv.javaguru.java3OnlineBanking.core.commands.clients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.validation.Valid;

@RestController
@RequestMapping(value = RESTResource.API_PATH)
public class ClientResourceImpl {

    @Autowired
    private JMSRequestProcessor jmsRequestProcessor;


    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public DeferredResult<ResponseEntity> create(@Valid @RequestBody ClientDTO clientDTO) {
        JMSCreateClientRequest jmsRequest = new JMSCreateClientRequest();
        jmsRequest.setClientDTO(clientDTO);
        return jmsRequestProcessor.process(jmsRequest);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.PUT)
    public DeferredResult<ResponseEntity> put(@RequestBody ClientDTO clientDTO) {
        JMSUpdateClientRequest jmsRequest = new JMSUpdateClientRequest();
        jmsRequest.setClientDTO(clientDTO);
        return jmsRequestProcessor.process(jmsRequest);
    }

    /*@RequestMapping(value = "/clients/{clientId}", method = RequestMethod.GET)
    public DeferredResult<ResponseEntity> get(@PathVariable("clientId") Long clientId) {
        JMSGetClientRequest jmsRequest = new JMSGetClientRequest();
        jmsRequest.setClientId(clientId);
        return jmsRequestProcessor.process(jmsRequest);
    }*/

    @RequestMapping(value = "/clients/{login}", method = RequestMethod.GET)
    public DeferredResult<ResponseEntity> get(@PathVariable("login") String login) {
        JMSGetClientByLoginRequest jmsRequest = new JMSGetClientByLoginRequest();
        jmsRequest.setLogin(login);
        return jmsRequestProcessor.process(jmsRequest);
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.DELETE)
    public DeferredResult<ResponseEntity> delete(@PathVariable("clientId") Long clientId) {
        JMSDeleteClientRequest jmsRequest = new JMSDeleteClientRequest();
        jmsRequest.setClientId(clientId);

        return jmsRequestProcessor.process(jmsRequest);
    }

   /* @Autowired
    private CommandExecutor commandExecutor;

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO clientDTO) {

        CreateClientCommand command = new CreateClientCommand(
                clientDTO.getLogin(),
                clientDTO.getPassword(),
                clientDTO.getFullName()
        );

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
    }*/
}
