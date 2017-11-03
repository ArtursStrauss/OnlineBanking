package lv.javaguru.java3OnlineBanking.core.commands.clientaccounttransactions;

import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommand;
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

    public CreateClientAccountTransactionCommand(ClientDTO clientDTO, ClientAccountDTO clientAccountDTO, TransactionType transactionType, BigDecimal amount, String currency) {

        this.clientDTO = clientDTO;
        this.clientAccountDTO = clientAccountDTO;
        this.transactionType = transactionType;
        this.amount = amount;
        this.currency = currency;
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

    @Override
    public String toString() {
        return "CreateClientAccountTransactionCommand{" +
                "clientDTO=" + clientDTO +
                ", clientAccountDTO=" + clientAccountDTO +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", currency='" + currency +
                '}';
    }
}
