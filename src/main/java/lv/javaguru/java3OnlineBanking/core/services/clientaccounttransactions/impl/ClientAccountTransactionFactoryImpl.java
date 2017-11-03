package lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientAccountTransactionDAO;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransaction;
import lv.javaguru.java3OnlineBanking.core.domain.enums.TransactionStatus;
import lv.javaguru.java3OnlineBanking.core.domain.enums.TransactionType;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions.api.ClientAccountTransactionFactory;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounts.api.ClientAccountService;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions.api.ClientAccountTransactionValidator;
import lv.javaguru.java3OnlineBanking.core.services.clients.api.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransactionBuilder.createClientAccountTransaction;

@Component
public class ClientAccountTransactionFactoryImpl implements ClientAccountTransactionFactory {

    @Autowired
    private ClientAccountTransactionValidator validator;
    @Autowired
    private ClientAccountTransactionDAO clientAccountTransactionDAO;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientAccountService clientAccountService;

    @Override
    public ClientAccountTransaction create(ClientDTO clientDTO, ClientAccountDTO clientAccountDTO, TransactionType transactionType, BigDecimal amount, String currency) {

        Client client = clientService.get(clientDTO.getId());
        ClientAccount clientAccount = clientAccountService.get(clientAccountDTO.getId());

        validator.validate(clientAccount, transactionType, amount);

        amountWithSign(transactionType, amount);

        BigDecimal resultBalance = calculateResultBalance(clientAccount, amount);
        TransactionStatus status = TransactionStatus.SUCCESSFUL;

        ClientAccountTransaction clientAccountTransaction = createClientAccountTransaction()
                .withClient(client)
                .withClientAccount(clientAccount)
                .withTransactionType(transactionType)
                .withAmount(amount)
                .withCurrency(currency)
                .withResultBalance(resultBalance)
                .withStatus(status)
                .build();

        clientAccountTransactionDAO.create(clientAccountTransaction);

        return clientAccountTransaction;
    }

    private void amountWithSign(TransactionType transactionType, BigDecimal amount) {
        if (transactionType.equals(TransactionType.TRANSFER_OUT) || transactionType.equals(TransactionType.WITHDRAW)) {
            amount.multiply(new BigDecimal("-1"));
        }
    }

    private BigDecimal calculateResultBalance(ClientAccount clientAccount, BigDecimal amount) {
        BigDecimal resultBalance = new BigDecimal(clientAccount.getBalance().toString());
        return resultBalance.add(amount);
    }
}
