package lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions.impl;

import lv.javaguru.java3OnlineBanking.core.domain.enums.TransactionType;
import lv.javaguru.java3OnlineBanking.core.exceptions.clientaccounttransactions.AmountLessOrEqualsToZeroException;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions.api.ClientAccountTransactionValidator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ClientAccountTransactionValidatorImpl implements ClientAccountTransactionValidator {


    @Override
    public void validate(TransactionType transactionType, BigDecimal amount) {

        amountNotZeroOrNegative(transactionType, amount);
    }

    private void amountNotZeroOrNegative(TransactionType transactionType, BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new AmountLessOrEqualsToZeroException("Amount should be greater than Zero! amount = " + amount.toString());
        }
    }
}
