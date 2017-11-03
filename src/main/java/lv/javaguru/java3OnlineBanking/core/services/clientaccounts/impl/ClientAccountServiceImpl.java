package lv.javaguru.java3OnlineBanking.core.services.clientaccounts.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientAccountDAO;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.exceptions.ResourceNotFoundException;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounts.api.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private ClientAccountDAO clientAccountDAO;

    @Override
    public ClientAccount update(ClientAccount clientAccount) {

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
