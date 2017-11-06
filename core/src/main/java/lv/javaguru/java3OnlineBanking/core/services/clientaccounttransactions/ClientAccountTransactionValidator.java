package lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.common.dtos.enums.TransactionType;
import lv.javaguru.java3OnlineBanking.core.exceptions.clientaccounttransactions.AccountBalanceHasNotEnoughResources;
import lv.javaguru.java3OnlineBanking.core.exceptions.clientaccounttransactions.AmountLessOrEqualsToZeroException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public interface ClientAccountTransactionValidator {
    void validate(ClientAccount clientAccount, TransactionType transactionType, BigDecimal amount);
}

@Component
class ClientAccountTransactionValidatorImpl implements ClientAccountTransactionValidator {

    @Override
    public void validate(ClientAccount clientAccount, TransactionType transactionType, BigDecimal amount) {

        amountNotZeroOrNegative(amount);

        if (transactionType.equals(TransactionType.TRANSFER_OUT) || transactionType.equals(TransactionType.WITHDRAW)) {
            accountHasNotEnoughResources(clientAccount, amount);
        }
    }

    private void amountNotZeroOrNegative(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new AmountLessOrEqualsToZeroException("Amount should be greater than Zero! amount = " + amount.toString());
        }
    }

    private void accountHasNotEnoughResources(ClientAccount clientAccount, BigDecimal amount) {

        if (clientAccount.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
            throw new AccountBalanceHasNotEnoughResources("Account " + clientAccount.getAccountNumber() + " balance has not enough resources: " + clientAccount.getBalance().toString());
        }
    }
}
