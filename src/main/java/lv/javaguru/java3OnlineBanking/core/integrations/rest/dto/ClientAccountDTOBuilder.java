package lv.javaguru.java3OnlineBanking.core.integrations.rest.dto;

import java.math.BigDecimal;

public class ClientAccountDTOBuilder {

    private Long id;
    private String accountNumber;
    private String currency;
    private BigDecimal balance;
    private Long clientId;

    private ClientAccountDTOBuilder() {
    }

    public static ClientAccountDTOBuilder createClientAccountDTO() {
        return new ClientAccountDTOBuilder();
    }

    public ClientAccountDTO build() {
        ClientAccountDTO clientAccountDTO = new ClientAccountDTO();
        clientAccountDTO.setId(id);
        clientAccountDTO.setAccountNumber(accountNumber);
        clientAccountDTO.setCurrency(currency);
        clientAccountDTO.setBalance(balance);
        clientAccountDTO.setClientId(clientId);

        return clientAccountDTO;
    }

    public ClientAccountDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientAccountDTOBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public ClientAccountDTOBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public ClientAccountDTOBuilder withBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public ClientAccountDTOBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }
}
