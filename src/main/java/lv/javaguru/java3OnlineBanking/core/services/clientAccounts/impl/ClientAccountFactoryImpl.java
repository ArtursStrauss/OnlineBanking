package lv.javaguru.java3OnlineBanking.core.services.clientAccounts.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientAccountDAO;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.services.clientAccounts.api.ClientAccountFactory;
import lv.javaguru.java3OnlineBanking.core.services.clients.api.ClientService;
import lv.javaguru.java3OnlineBanking.core.utils.GenerateAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3OnlineBanking.core.domain.ClientAccountBuilder.createClientAccount;

import java.math.BigDecimal;

@Component
public class ClientAccountFactoryImpl implements ClientAccountFactory {

    @Autowired
    private GenerateAccount generateAccount;
    @Autowired
    private ClientAccountDAO clientAccountDAO;
    @Autowired
    private ClientService clientService;

    @Override
    public ClientAccount create(String currency, Long clientId) {

        String accountNumber = generateAccount.generateAccount();
        BigDecimal balance = new BigDecimal("0.0");
        Client client = clientService.get(clientId);

        ClientAccount clientAccount = createClientAccount()
                .withAccountNumber(accountNumber)
                .withCurrency(currency)
                .withBalance(balance)
                .withClient(client)
                .build();

        clientAccountDAO.create(clientAccount);
        System.out.println(clientAccount);
        return clientAccount;
    }
}
