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

    @Column(name = "balance")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
}
