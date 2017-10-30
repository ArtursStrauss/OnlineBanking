package lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions.api;

import lv.javaguru.java3OnlineBanking.core.domain.enums.TransactionType;

import java.math.BigDecimal;

public interface ClientAccountTransactionValidator {
    void validate(TransactionType transactionType, BigDecimal amount);
}
