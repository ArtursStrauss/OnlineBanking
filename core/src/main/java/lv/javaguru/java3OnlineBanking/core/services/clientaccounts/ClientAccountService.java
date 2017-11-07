package lv.javaguru.java3OnlineBanking.core.services.clientaccounts;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.domain.repositories.ClientAccountRepository;
import lv.javaguru.java3OnlineBanking.core.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ClientAccountService {

    ClientAccount update(ClientAccount clientAccount);

    void delete(Long clientAccountId);

    ClientAccount get(Long clientAccountId);

    List<ClientAccount> getAllAccountsByClientId(Long clientId);
}

@Component
class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private ClientAccountRepository clientAccountRepository;

    @Override
    public ClientAccount update(ClientAccount clientAccount) {

        clientAccountRepository.save(clientAccount);
        return clientAccount;
    }

    @Override
    public void delete(Long clientAccountId) {
        ClientAccount clientAccount = get(clientAccountId);
        clientAccountRepository.delete(clientAccount);
    }

    @Override
    public ClientAccount get(Long clientAccountId) {
        ClientAccount clientAccount = clientAccountRepository.findOne(clientAccountId);

        if (clientAccount == null) {
            throw new ResourceNotFoundException(clientAccountId, "Client Account not found!");
        }
        return clientAccount;
    }

    public List<ClientAccount> getAllAccountsByClientId(Long clientId) {
        return clientAccountRepository.findAllByClientId(clientId);
    }
}
