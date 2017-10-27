package lv.javaguru.java3OnlineBanking.core.commands.clientAccounts;

import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommand;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;


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
