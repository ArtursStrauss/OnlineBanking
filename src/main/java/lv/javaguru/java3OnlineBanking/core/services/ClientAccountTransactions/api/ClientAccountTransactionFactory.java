package lv.javaguru.java3OnlineBanking.core.services.ClientAccountTransactions.api;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransaction;
import lv.javaguru.java3OnlineBanking.core.domain.enums.TransactionStatus;
import lv.javaguru.java3OnlineBanking.core.domain.enums.TransactionType;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;

import java.math.BigDecimal;

public interface ClientAccountTransactionFactory {
    ClientAccountTransaction create(ClientDTO clientDTO, ClientAccountDTO clientAccountDTO, TransactionType transactionType, BigDecimal amount, String currency, BigDecimal resultBalance, TransactionStatus status);
}
