package lv.javaguru.java3OnlineBanking.core.commands.clientAccountTransactions;

import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommand;
import lv.javaguru.java3OnlineBanking.core.domain.enums.TransactionStatus;
import lv.javaguru.java3OnlineBanking.core.domain.enums.TransactionType;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;

import java.math.BigDecimal;

public class CreateClientAccountTransactionCommand implements DomainCommand<CreateClientAccountTransactionResult> {

    private ClientDTO clientDTO;
    private ClientAccountDTO clientAccountDTO;
    private TransactionType transactionType;
    private BigDecimal amount;
    private String currency;
    private BigDecimal resultBalance;
    private TransactionStatus status;

    public CreateClientAccountTransactionCommand(ClientDTO clientDTO, ClientAccountDTO clientAccountDTO, TransactionType transactionType, BigDecimal amount, String currency, BigDecimal resultBalance, TransactionStatus status) {

        this.clientDTO = clientDTO;
        this.clientAccountDTO = clientAccountDTO;
        this.transactionType = transactionType;
        this.amount = amount;
        this.currency = currency;
        this.resultBalance = resultBalance;
        this.status = status;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public ClientAccountDTO getClientAccountDTO() {
        return clientAccountDTO;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getResultBalance() {
        return resultBalance;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "CreateClientAccountTransactionCommand{" +
                "clientDTO=" + clientDTO +
                ", clientAccountDTO=" + clientAccountDTO +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", resultBalance=" + resultBalance +
                ", status=" + status +
                '}';
    }
}
