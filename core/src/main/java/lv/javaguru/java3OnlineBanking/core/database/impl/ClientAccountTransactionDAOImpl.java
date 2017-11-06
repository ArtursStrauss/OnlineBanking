package lv.javaguru.java3OnlineBanking.core.database.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientAccountTransactionDAO;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransaction;
import org.springframework.stereotype.Component;

@Component
public class ClientAccountTransactionDAOImpl extends CRUDOperationDAOImpl<ClientAccountTransaction, Long> implements ClientAccountTransactionDAO {
}
