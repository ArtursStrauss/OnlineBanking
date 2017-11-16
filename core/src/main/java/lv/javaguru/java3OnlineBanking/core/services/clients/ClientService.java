package lv.javaguru.java3OnlineBanking.core.services.clients;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.ResourceNotFoundException;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface ClientService {

    Client update(Long clientId,
                  String newLogin,
                  String newPassword,
                  String newFullName);

    void delete(Long clientId);

    Client get(Long clientId);
}


@Component
class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientValidator clientValidator;

    @Override
    public Client update(Long clientId, String newLogin, String newPassword, String newFullName) {

        clientValidator.validate(newLogin, newPassword);

        Client client = get(clientId);
        client.setLogin(newLogin);
        client.setPassword(newPassword);
        client.setFullName(newFullName);

        clientRepository.save(client);
        return client;
    }

    @Override
    public void delete(Long clientId) {
        Client client = get(clientId);
        clientRepository.delete(client);
    }

    @Override
    public Client get(Long clientId) {
        Client client = clientRepository.findOne(clientId);

        if (client == null) {
            throw new ResourceNotFoundException(clientId, "user not found");
        }
        return client;
    }
}
