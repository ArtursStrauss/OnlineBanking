package lv.javaguru.java3OnlineBanking.core.services.clientAccounts.api;

import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;

import java.math.BigDecimal;
import java.util.List;

public interface ClientAccountService {

    ClientAccount update(Long clientAccountId,
                         String accountNumber,
                         String currency,
                         BigDecimal balance,
                         Client client);

    void delete(Long clientAccountId);

    ClientAccount get(Long clientAccountId);

    List<ClientAccount> getAllAccountsByClientId(Long clientId);
}
