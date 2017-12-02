package lv.javaguru.java3OnlineBanking.common.dtos;

import lv.javaguru.java3OnlineBanking.common.dtos.enums.TransactionStatus;
import lv.javaguru.java3OnlineBanking.common.dtos.enums.TransactionType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ClientAccountTransactionDTO implements Serializable {

    private Long id;

    @NotNull
    private ClientDTO client;

    @NotNull
    private ClientAccountDTO clientAccount;

    @NotNull
    private TransactionType transactionType;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private String currency;

    private BigDecimal resultBalance;

    private TransactionStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public ClientAccountDTO getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccountDTO clientAccount) {
        this.clientAccount = clientAccount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getResultBalance() {
        return resultBalance;
    }

    public void setResultBalance(BigDecimal resultBalance) {
        this.resultBalance = resultBalance;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClientAccountTransactionDTO{" +
                "id=" + id +
                ", client=" + client +
                ", clientAccount=" + clientAccount +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", resultBalance=" + resultBalance +
                ", status=" + status +
                '}';
    }
}
