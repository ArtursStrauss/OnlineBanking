package lv.javaguru.java3OnlineBanking.core.database.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientAccountDAO;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import org.springframework.stereotype.Component;

@Component
public class ClientAccountDAOImpl extends CRUDOperationDAOImpl<ClientAccount, Long> implements ClientAccountDAO {
}
