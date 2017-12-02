package lv.javaguru.java3OnlineBanking.core.domain.builders;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import org.junit.Test;

import java.math.BigDecimal;

import static lv.javaguru.java3OnlineBanking.core.domain.builders.ClientAccountBuilder.createClientAccount;
import static lv.javaguru.java3OnlineBanking.core.domain.builders.ClientBuilder.createClient;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClientAccountBuilderTest {

    @Test
    public void shouldCreateClientAccountWithClient() {
        ClientAccount clientAccount = createClientAccount()
                .withId(1L)
                .withCurrency("EUR")
                .withBalance(new BigDecimal("1.0"))
                .withAccountNumber("1111AAAABBBB")
                .withClient(createClient()
                        .withId(1L)
                        .withLogin("test-login")
                        .withPassword("test-password")
                        .withFullName("Test FullName")
                        .build())
                .build();

        assertThat(clientAccount.getId(),is(1L));
        assertThat(clientAccount.getCurrency(),is("EUR"));
        assertThat(clientAccount.getBalance().toString(),is("1.0"));
        assertThat(clientAccount.getAccountNumber(),is("1111AAAABBBB"));
        assertThat(clientAccount.getClient(),is(notNullValue()));
        assertThat(clientAccount.getClient().getId(),is(1L));
        assertThat(clientAccount.getClient().getLogin(),is("test-login"));
        assertThat(clientAccount.getClient().getPassword(),is("test-password"));
        assertThat(clientAccount.getClient().getFullName(),is("Test FullName"));
    }
}
