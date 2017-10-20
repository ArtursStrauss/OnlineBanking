package lv.javaguru.java3OnlineBanking.core.database.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientDAO;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientDAOImpl extends CRUDOperationDAOImpl<Client, Long> implements ClientDAO {

}
