package lv.javaguru.java3OnlineBanking.core.domain.builders;

import lv.javaguru.java3OnlineBanking.core.domain.Client;
import org.junit.Test;

import static lv.javaguru.java3OnlineBanking.core.domain.builders.ClientBuilder.createClient;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClientBuilderTest {

    @Test
    public void shouldCreateClient(){
        Client client = createClient()
                .withId(1L)
                .withLogin("test-login")
                .withPassword("test-password")
                .withFullName("Test FullName")
                .build();

        assertThat(client.getId(),is(1L));
        assertThat(client.getLogin(),is("test-login"));
        assertThat(client.getPassword(),is("test-password"));
        assertThat(client.getFullName(),is("Test FullName"));
    }
}
