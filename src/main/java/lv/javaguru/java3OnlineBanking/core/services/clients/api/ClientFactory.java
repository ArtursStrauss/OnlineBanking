package lv.javaguru.java3OnlineBanking.core.services.clients.api;

import lv.javaguru.java3OnlineBanking.core.domain.Client;

public interface ClientFactory {

    Client create(String login, String password, String fullName);
}
