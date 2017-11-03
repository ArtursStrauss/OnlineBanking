package lv.javaguru.java3OnlineBanking.core.services.clientaccounts.api;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;

import java.util.List;

public interface ClientAccountService {

    ClientAccount update(ClientAccount clientAccount);

    void delete(Long clientAccountId);

    ClientAccount get(Long clientAccountId);

    List<ClientAccount> getAllAccountsByClientId(Long clientId);
}
