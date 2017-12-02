package lv.javaguru.java3OnlineBanking.core.domain.repositories;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {

    public List<ClientAccount> findAllByClientId(Long clientId);
}
