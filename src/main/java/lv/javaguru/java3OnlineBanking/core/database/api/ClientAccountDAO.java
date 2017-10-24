package lv.javaguru.java3OnlineBanking.core.database.api;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;

import java.util.List;

public interface ClientAccountDAO extends CRUDOperationDAO<ClientAccount, Long> {

    List<ClientAccount> getAllAccountsByClientId(Long clientId);
}
