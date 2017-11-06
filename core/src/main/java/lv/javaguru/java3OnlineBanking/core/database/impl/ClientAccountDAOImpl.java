package lv.javaguru.java3OnlineBanking.core.database.impl;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.database.api.ClientAccountDAO;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class ClientAccountDAOImpl extends CRUDOperationDAOImpl<ClientAccount, Long> implements ClientAccountDAO {

    public ClientAccount getByAccountNumber(String accountNumber) {

        return (ClientAccount) getCurrentSession()
                .createCriteria(ClientAccount.class)
                .add(Restrictions.eq("accountNumber", accountNumber))
                .uniqueResult();
    }

    @Override
    public List<ClientAccount> getAllAccountsByClientId(Long clientId) {

        String hql = "SELECT ca FROM ClientAccount ca inner join ca.client cl where cl.id = :client_id";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("client_id", clientId);

        List<ClientAccount> results = (List<ClientAccount>) query.list();

        return results;
    }
}
