package lv.javaguru.java3OnlineBanking.core.domain;

import lv.javaguru.java3OnlineBanking.common.dtos.enums.TransactionType;
import lv.javaguru.java3OnlineBanking.common.dtos.enums.TransactionStatus;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "client_account_transactions")
public class ClientAccountTransaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_account_id", nullable = false, referencedColumnName = "id")
    private ClientAccount clientAccount;

    @Column(name = "transaction_type", columnDefinition = "enum('DUMMY')")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "result_balance", nullable = false)
    private BigDecimal resultBalance;

    @Column(name = "status", columnDefinition = "enum('DUMMY')")
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
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
        return "ClientAccountTransaction{" +
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
