package lv.javaguru.java3OnlineBanking.core.database.impl;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientAccountDAO;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

@Component
class ClientAccountDAOImpl extends CRUDOperationDAOImpl<ClientAccount, Long> implements ClientAccountDAO {

    public ClientAccount getByAccountNumber(String accountNumber) {

        return (ClientAccount) getCurrentSession()
                .createCriteria(ClientAccount.class)
                .add(Restrictions.eq("accountNumber", accountNumber))
                .uniqueResult();
    }
}
