package lv.javaguru.java3OnlineBanking.core.domain.repositories;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAccountTransactionRepository extends JpaRepository<ClientAccountTransaction, Long> {
}
