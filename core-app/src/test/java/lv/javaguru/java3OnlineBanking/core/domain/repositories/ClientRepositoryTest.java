package lv.javaguru.java3OnlineBanking.core.domain.repositories;

import lv.javaguru.java3OnlineBanking.core.domain.Client;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static lv.javaguru.java3OnlineBanking.core.domain.builders.ClientBuilder.createClient;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ClientRepositoryTest extends DatabaseJPATest {

    @Test
    @Transactional
    public void testSaveClient() {
        Client client = getClient();
        assertThat(client.getId(), is(nullValue()));
        client = clientRepository.save(client);
        assertThat(client.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testFindOneByLogin(){
        //Optional<Client> clientFromDb = Optional.ofNullable(clientRepository.findOne(-1L));
        Optional<Client> clientFromDb = clientRepository.findOneByLogin("xxx-no-login-xxx");
        assertThat(clientFromDb.isPresent(), is(false));
    }

    @Test
    @Transactional
    public void testGetRequiredByLogin() {
        Client client = getClient();
        clientRepository.save(client);
        Client clientFromDb = clientRepository.getRequiredByLogin(client.getLogin());
        assertThat(clientFromDb, is(notNullValue()));
    }

    private Client getClient() {
        return createClient()
                .withLogin("test-login")
                .withPassword("test-password")
                .withFullName("Test FullName")
                .build();
    }
}
