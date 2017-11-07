package lv.javaguru.java3OnlineBanking.core.services.clients;

import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3OnlineBanking.core.domain.builders.ClientBuilder.createClient;

public interface ClientFactory {

    Client create(String login, String password, String fullName);
}

@Component
class ClientFactoryImpl implements ClientFactory {

    @Autowired
    private ClientValidator clientValidator;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client create(String login, String password, String fullName) {
        clientValidator.validate(login, password);
        Client client = createClient()
                .withLogin(login)
                .withPassword(password)
                .withFullName(fullName)
                .build();
        clientRepository.save(client);
        return client;
    }
}
