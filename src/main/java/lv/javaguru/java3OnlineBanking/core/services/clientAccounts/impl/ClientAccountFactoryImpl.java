package lv.javaguru.java3OnlineBanking.core.services.clientAccounts.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientAccountDAO;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.services.clientAccounts.api.ClientAccountFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static lv.javaguru.java3OnlineBanking.core.domain.ClientAccountBuilder.createClientAccount;

import java.math.BigDecimal;

public class ClientAccountFactoryImpl implements ClientAccountFactory {

    @Autowired
    private ClientAccountDAO clientAccountDAO;

    @Override
    public ClientAccount create(String accountNumber, String currency, BigDecimal balance, Client client) {

        ClientAccount clientAccount = createClientAccount()
                .withAccountNumber(accountNumber)
                .withCurrency(currency)
                .withBalance(balance)
                .withClient(client)
                .build();

        clientAccountDAO.create(clientAccount);
        return clientAccount;
    }
}
