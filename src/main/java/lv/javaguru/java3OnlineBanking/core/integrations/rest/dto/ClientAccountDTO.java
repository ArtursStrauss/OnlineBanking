package lv.javaguru.java3OnlineBanking.core.integrations.rest.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ClientAccountDTO implements Serializable {

    private Long id;
    private String accountNumber;

    @NotNull
    @NotEmpty
    private String currency;
    private BigDecimal balance;

    @NotNull
    private ClientDTO client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setClientDTO(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "ClientAccountDTO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", balance=" + balance +
                '}';
    }
}
