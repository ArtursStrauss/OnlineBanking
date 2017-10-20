package lv.javaguru.java3OnlineBanking.core.services.clients.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientDAO;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.services.clients.api.ClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3OnlineBanking.core.domain.ClientBuilder.createClient;

@Component
public class ClientFactoryImpl implements ClientFactory {

    // @Autowired private ClientValidator clientValidator;
    @Autowired
    private ClientDAO clientDAO;

    @Override
    public Client create(String login, String password, String fullName) {
        // clientValidator.validate(login, password);
        Client client = createClient()
                .withLogin(login)
                .withPassword(password)
                .withFullName(fullName)
                .build();
        clientDAO.create(client);
        return client;
    }
}
