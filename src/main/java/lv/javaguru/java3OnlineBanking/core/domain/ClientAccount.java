package lv.javaguru.java3OnlineBanking.core.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "client_accounts")
public class ClientAccount extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "balance", columnDefinition = "decimal default 0.0")
    private BigDecimal balance;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    private Client client;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientAccount{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", balance=" + balance +
                ", client=" + client +
                '}';
    }
}
