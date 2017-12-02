package lv.javaguru.java3OnlineBanking.core.domain.repositories;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.ResourceNotFoundException;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findOneByLogin(String login);

    default Client getRequiredByLogin(String login) {
        return findOneByLogin(login)
                .orElseThrow(() -> new ResourceNotFoundException(login, "Client not found!"));
    }
}
