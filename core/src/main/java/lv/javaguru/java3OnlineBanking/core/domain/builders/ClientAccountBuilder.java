package lv.javaguru.java3OnlineBanking.core.domain.builders;

import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;

import java.math.BigDecimal;

public class ClientAccountBuilder {

    private Long id;
    private String accountNumber;
    private String currency;
    private BigDecimal balance;
    private Client client;

    private ClientAccountBuilder() {
    }

    public static ClientAccountBuilder createClientAccount() {
        return new ClientAccountBuilder();
    }

    public ClientAccount build() {
        ClientAccount clientAccount = new ClientAccount();

        clientAccount.setId(id);
        clientAccount.setAccountNumber(accountNumber);
        clientAccount.setCurrency(currency);
        clientAccount.setBalance(balance);
        clientAccount.setClient(client);

        return clientAccount;
    }

    public ClientAccountBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientAccountBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public ClientAccountBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public ClientAccountBuilder withBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public ClientAccountBuilder withClient(Client client) {
        this.client = client;
        return this;
    }
}
