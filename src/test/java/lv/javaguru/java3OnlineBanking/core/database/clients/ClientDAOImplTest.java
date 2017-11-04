package lv.javaguru.java3OnlineBanking.core.database.clients;

import lv.javaguru.java3OnlineBanking.core.domain.Client;
import org.junit.Test;

import javax.transaction.Transactional;

import static lv.javaguru.java3OnlineBanking.core.domain.builders.ClientBuilder.createClient;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ClientDAOImplTest extends DatabaseHibernateTest {

    @Test
    @Transactional
    public void testCreateClient() {
        Client client = getClient();

        assertThat(client.getId(), is(nullValue()));
        clientDAO.create(client);
        assertThat(client.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetClientById() {
        Client client = getClient();

        clientDAO.create(client);
        Client clientFromDb = clientDAO.getById(client.getId());
        assertThat(clientFromDb, is(notNullValue()));
    }

    @Test
    @Transactional
    public void testUpdateClient() {
        Client client = getClient();

        clientDAO.create(client);
        Client newClient = clientDAO.getById(client.getId());

        newClient.setFullName("name full");

        clientDAO.update(newClient);
        Client clientUpdate = clientDAO.getById(newClient.getId());

        assertEquals("name full", clientUpdate.getFullName());
    }

    @Test
    @Transactional
    public void testDeleteClient(){
        Client client = getClient();

        clientDAO.create(client);

        Client clientFromDb = clientDAO.getById(client.getId());
        clientDAO.delete(clientFromDb);
        Client clientDeleted = clientDAO.getById(client.getId());

        assertThat(clientDeleted, is(nullValue()));
    }

    private Client getClient() {
        return createClient()
                .withLogin("login")
                .withPassword("password")
                .withFullName("full name")
                .build();
    }
}
