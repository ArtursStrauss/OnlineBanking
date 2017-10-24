package lv.javaguru.java3OnlineBanking.core.services.clientAccounts.api;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;

public interface ClientAccountFactory {
    ClientAccount create(String currency, Long clientId);
}
