package lv.javaguru.java3OnlineBanking.core.services.clientAccounts.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientAccountDAO;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.exceptions.ResourceNotFoundException;
import lv.javaguru.java3OnlineBanking.core.services.clientAccounts.api.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private ClientAccountDAO clientAccountDAO;

    @Override
    public ClientAccount update(Long clientAccountId, String accountNumber, String currency, BigDecimal balance, Client client) {

        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setId(clientAccountId);
        clientAccount.setAccountNumber(accountNumber);
        clientAccount.setCurrency(currency);
        clientAccount.setBalance(balance);
        clientAccount.setClient(client);

        clientAccountDAO.update(clientAccount);
        return clientAccount;
    }

    @Override
    public void delete(Long clientAccountId) {
        ClientAccount clientAccount = get(clientAccountId);
        clientAccountDAO.delete(clientAccount);
    }

    @Override
    public ClientAccount get(Long clientAccountId) {
        ClientAccount clientAccount = clientAccountDAO.getRequired(clientAccountId);

        if (clientAccount == null) {
            throw new ResourceNotFoundException(clientAccountId, "Client Account not found!");
        }
        return clientAccount;
    }

    public List<ClientAccount> getAllAccountsByClientId(Long clientId) {
        return clientAccountDAO.getAllAccountsByClientId(clientId);
    }
}
