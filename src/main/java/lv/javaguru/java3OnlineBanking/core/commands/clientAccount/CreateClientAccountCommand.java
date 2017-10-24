package lv.javaguru.java3OnlineBanking.core.commands.clientAccount;

import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommand;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;


public class CreateClientAccountCommand implements DomainCommand<CreateClientAccountResult> {

    private String currency;
    private Long clientId;

    public CreateClientAccountCommand(String currency, Long clientId) {

        this.currency = currency;
        this.clientId = clientId;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getClientId() {
        return clientId;
    }
}
