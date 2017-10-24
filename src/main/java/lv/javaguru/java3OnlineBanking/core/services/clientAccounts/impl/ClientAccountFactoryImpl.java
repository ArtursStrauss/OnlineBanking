package lv.javaguru.java3OnlineBanking.core.services.clientAccounts.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientAccountDAO;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.services.clientAccounts.api.ClientAccountFactory;
import lv.javaguru.java3OnlineBanking.core.services.clients.api.ClientService;
import lv.javaguru.java3OnlineBanking.core.utils.GenerateAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3OnlineBanking.core.domain.ClientAccountBuilder.createClientAccount;

import java.math.BigDecimal;

@Component
public class ClientAccountFactoryImpl implements ClientAccountFactory {

    private static final BigDecimal INITIAL_BALANCE = new BigDecimal("0.0");

    @Autowired
    private GenerateAccount generateAccount;
    @Autowired
    private ClientAccountDAO clientAccountDAO;
    @Autowired
    private ClientService clientService;

    @Override
    public ClientAccount create(String currency, ClientDTO clientDTO) {

        String accountNumber = generateAccount.generateAccount();
        Client client = clientService.get(clientDTO.getId());

        ClientAccount clientAccount = createClientAccount()
                .withAccountNumber(accountNumber)
                .withCurrency(currency)
                .withBalance(INITIAL_BALANCE)
                .withClient(client)
                .build();

        clientAccountDAO.create(clientAccount);

        return clientAccount;
    }
}
