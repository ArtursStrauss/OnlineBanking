package lv.javaguru.java3OnlineBanking.core.services.clients;

import lv.javaguru.java3OnlineBanking.core.database.api.ClientDAO;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.services.clients.api.ClientFactory;
import lv.javaguru.java3OnlineBanking.core.services.clients.api.ClientValidator;
import lv.javaguru.java3OnlineBanking.core.services.clients.impl.ClientFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientFactoryImplTest {

    @Mock
    private ClientValidator clientValidator;
    @Mock
    private ClientDAO clientDAO;

    @InjectMocks
    private ClientFactory clientFactory = new ClientFactoryImpl();

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FULL_NAME = "fullName";

    @Test
    public void createShouldInvokeValidator() {
        clientFactory.create(LOGIN, PASSWORD, FULL_NAME);
        verify(clientValidator).validate(LOGIN, PASSWORD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfValidationFail() {
        doThrow(new IllegalArgumentException())
                .when(clientValidator).validate(LOGIN, PASSWORD);
        clientFactory.create(LOGIN, PASSWORD, FULL_NAME);
    }

    @Test
    public void createShouldPersistClientAfterValidation() {
        Client client = clientFactory.create(LOGIN, PASSWORD,FULL_NAME);
        InOrder inOrder = inOrder(clientValidator, clientDAO);
        inOrder.verify(clientValidator).validate(LOGIN, PASSWORD);
        inOrder.verify(clientDAO).create(client);
    }

    @Test
    public void createShouldReturnNewClient() {
        Client client = clientFactory.create(LOGIN, PASSWORD,FULL_NAME);
        assertThat(client.getLogin(), is(LOGIN));
        assertThat(client.getPassword(), is(PASSWORD));
    }

}
