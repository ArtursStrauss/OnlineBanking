package lv.javaguru.java3OnlineBanking.core.services.clients.api;

import lv.javaguru.java3OnlineBanking.core.domain.Client;

public interface ClientService {

    Client update(Long clientId,
                  String newLogin,
                  String newPassword,
                  String newFullName);

    void delete(Long clientId);

    Client get(Long clientId);
}
