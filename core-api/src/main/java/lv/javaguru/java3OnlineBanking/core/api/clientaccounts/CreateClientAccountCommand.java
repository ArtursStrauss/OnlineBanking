package lv.javaguru.java3OnlineBanking.core.api.clientaccounts;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.api.DomainCommand;


public class CreateClientAccountCommand implements DomainCommand<CreateClientAccountResult> {

    private String currency;
    private ClientDTO client;

    public CreateClientAccountCommand(String currency, ClientDTO client) {

        this.currency = currency;
        this.client = client;
    }

    public String getCurrency() {
        return currency;
    }

    public ClientDTO getClient(){
        return client;
    }
}
