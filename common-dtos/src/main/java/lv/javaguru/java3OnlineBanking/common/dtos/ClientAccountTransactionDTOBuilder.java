package lv.javaguru.java3OnlineBanking.common.dtos;

import lv.javaguru.java3OnlineBanking.common.dtos.enums.TransactionStatus;
import lv.javaguru.java3OnlineBanking.common.dtos.enums.TransactionType;

import java.math.BigDecimal;

public class ClientAccountTransactionDTOBuilder {

    private Long id;
    private ClientDTO clientDTO;
    private ClientAccountDTO clientAccountDTO;
    private TransactionType transactionType;
    private BigDecimal amount;
    private String currency;
    private BigDecimal resultBalance;
    private TransactionStatus status;

    private ClientAccountTransactionDTOBuilder() {
    }

    public static ClientAccountTransactionDTOBuilder createClientAccountTransactionDTOBuilder() {
        return new ClientAccountTransactionDTOBuilder();
    }

    public ClientAccountTransactionDTO build() {
        ClientAccountTransactionDTO clientAccountTransactionDTO = new ClientAccountTransactionDTO();

        clientAccountTransactionDTO.setId(id);
        clientAccountTransactionDTO.setClient(clientDTO);
        clientAccountTransactionDTO.setClientAccount(clientAccountDTO);
        clientAccountTransactionDTO.setTransactionType(transactionType);
        clientAccountTransactionDTO.setAmount(amount);
        clientAccountTransactionDTO.setCurrency(currency);
        clientAccountTransactionDTO.setResultBalance(resultBalance);
        clientAccountTransactionDTO.setStatus(status);

        return clientAccountTransactionDTO;
    }

    public ClientAccountTransactionDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientAccountTransactionDTOBuilder withClient(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
        return this;
    }

    public ClientAccountTransactionDTOBuilder withClientAccount(ClientAccountDTO clientAccountDTO) {
        this.clientAccountDTO = clientAccountDTO;
        return this;
    }

    public ClientAccountTransactionDTOBuilder withTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public ClientAccountTransactionDTOBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public ClientAccountTransactionDTOBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public ClientAccountTransactionDTOBuilder withResultBalance(BigDecimal resultBalance) {
        this.resultBalance = resultBalance;
        return this;
    }

    public ClientAccountTransactionDTOBuilder withStatus(TransactionStatus status) {
        this.status = status;
        return this;
    }
}
