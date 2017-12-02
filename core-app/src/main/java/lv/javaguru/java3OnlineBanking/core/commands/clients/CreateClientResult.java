package lv.javaguru.java3OnlineBanking.core.commands.clients;


import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.commands.DomainCommandResult;

public class CreateClientResult implements DomainCommandResult {

    private ClientDTO client;

    public CreateClientResult(ClientDTO client){
        this.client = client;
    }

    public ClientDTO getClient(){
        return client;
    }
}
