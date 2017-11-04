package lv.javaguru.java3OnlineBanking.core.domain.builders;

import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransaction;
import lv.javaguru.java3OnlineBanking.core.domain.enums.TransactionStatus;
import lv.javaguru.java3OnlineBanking.core.domain.enums.TransactionType;

import java.math.BigDecimal;

public class ClientAccountTransactionBuilder {

    private Long id;
    private Client client;
    private ClientAccount clientAccount;
    private TransactionType transactionType;
    private BigDecimal amount;
    private String currency;
    private BigDecimal resultBalance;
    private TransactionStatus status;

    private ClientAccountTransactionBuilder() {
    }

    public static ClientAccountTransactionBuilder createClientAccountTransaction() {
        return new ClientAccountTransactionBuilder();
    }

    public ClientAccountTransaction build() {
        ClientAccountTransaction clientAccountTransaction = new ClientAccountTransaction();

        clientAccountTransaction.setId(id);
        clientAccountTransaction.setClient(client);
        clientAccountTransaction.setClientAccount(clientAccount);
        clientAccountTransaction.setTransactionType(transactionType);
        clientAccountTransaction.setAmount(amount);
        clientAccountTransaction.setCurrency(currency);
        clientAccountTransaction.setResultBalance(resultBalance);
        clientAccountTransaction.setStatus(status);

        return clientAccountTransaction;
    }

    public ClientAccountTransactionBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientAccountTransactionBuilder withClient(Client client) {
        this.client = client;
        return this;
    }

    public ClientAccountTransactionBuilder withClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
        return this;
    }

    public ClientAccountTransactionBuilder withTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public ClientAccountTransactionBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public ClientAccountTransactionBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public ClientAccountTransactionBuilder withResultBalance(BigDecimal resultBalance) {
        this.resultBalance = resultBalance;
        return this;
    }

    public ClientAccountTransactionBuilder withStatus(TransactionStatus status) {
        this.status = status;
        return this;
    }
}
