package lv.javaguru.java3OnlineBanking.core.services.clients;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.CoreValidationException;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.repositories.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static lv.javaguru.java3OnlineBanking.core.api.exceptions.builders.CoreValidationExceptionBuilder.createCoreValidationException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class ClientFactoryTest {

    @Mock
    private ClientValidator clientValidator;
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientFactory clientFactory = new ClientFactoryImpl();

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FULL_NAME = "fullName";

    @Test
    public void shouldInvokeValidator() {
        clientFactory.create(LOGIN, PASSWORD, FULL_NAME);
        verify(clientValidator).validate(LOGIN, PASSWORD);
    }

    @Test(expected = CoreValidationException.class)
    public void shouldFailIfValidationFails() {
        doThrow(createCoreValidationException().build(  ))
                .when(clientValidator).validate(LOGIN, PASSWORD);
        clientFactory.create(LOGIN, PASSWORD, FULL_NAME);
    }

    @Test
    public void shouldCreateClientAfterValidation() {
        when(clientRepository.save(any(Client.class))).then(returnsFirstArg());
        Client client = clientFactory.create(LOGIN, PASSWORD, FULL_NAME);
        InOrder inOrder = inOrder(clientValidator, clientRepository);
        inOrder.verify(clientValidator).validate(LOGIN, PASSWORD);
        inOrder.verify(clientRepository).save(client);
    }

    @Test
    public void createShouldReturnNewClient() {
        when(clientRepository.save(any(Client.class))).then(returnsFirstArg());
        Client client = clientFactory.create(LOGIN, PASSWORD, FULL_NAME);
        assertThat(client.getLogin(), is(LOGIN));
        assertThat(client.getPassword(), is(PASSWORD));
        assertThat(client.getFullName(), is(FULL_NAME));
    }
}
