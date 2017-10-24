package lv.javaguru.java3OnlineBanking.core.services.clientAccounts.api;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;

public interface ClientAccountFactory {
    ClientAccount create(String currency, ClientDTO clientDTO);
}
