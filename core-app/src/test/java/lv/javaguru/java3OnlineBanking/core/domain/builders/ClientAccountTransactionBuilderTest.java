package lv.javaguru.java3OnlineBanking.core.domain.builders;

import lv.javaguru.java3OnlineBanking.common.dtos.enums.TransactionStatus;
import lv.javaguru.java3OnlineBanking.common.dtos.enums.TransactionType;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransaction;
import org.junit.Test;

import java.math.BigDecimal;

import static lv.javaguru.java3OnlineBanking.core.domain.builders.ClientAccountBuilder.createClientAccount;
import static lv.javaguru.java3OnlineBanking.core.domain.builders.ClientAccountTransactionBuilder.createClientAccountTransaction;
import static lv.javaguru.java3OnlineBanking.core.domain.builders.ClientBuilder.createClient;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClientAccountTransactionBuilderTest {

    @Test
    public void shouldCreateClientAccountTransactionWithClientAndAccount() {
        ClientAccountTransaction clientAccountTransaction = createClientAccountTransaction()
                .withId(1L)
                .withStatus(TransactionStatus.SUCCESSFUL)
                .withAmount(new BigDecimal("1.0"))
                .withCurrency("EUR")
                .withResultBalance(new BigDecimal("1.0"))
                .withTransactionType(TransactionType.DEPOSIT)
                .withClient(createClient()
                        .withId(1L)
                        .withLogin("test-login")
                        .withPassword("test-password")
                        .withFullName("Test FullName")
                        .build())
                .withClientAccount(createClientAccount()
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
                        .build())
                .build();

        assertThat(clientAccountTransaction.getId(), is(1L));
        assertThat(clientAccountTransaction.getStatus(), is(TransactionStatus.SUCCESSFUL));
        assertThat(clientAccountTransaction.getAmount().toString(), is("1.0"));
        assertThat(clientAccountTransaction.getCurrency(), is("EUR"));
        assertThat(clientAccountTransaction.getResultBalance().toString(), is("1.0"));
        assertThat(clientAccountTransaction.getTransactionType(), is(TransactionType.DEPOSIT));
        assertThat(clientAccountTransaction.getClient(), is(notNullValue()));
        assertThat(clientAccountTransaction.getClient().getId(), is(1L));
        assertThat(clientAccountTransaction.getClient().getLogin(), is("test-login"));
        assertThat(clientAccountTransaction.getClient().getPassword(), is("test-password"));
        assertThat(clientAccountTransaction.getClient().getFullName(), is("Test FullName"));
        assertThat(clientAccountTransaction.getClientAccount(), is(notNullValue()));
        assertThat(clientAccountTransaction.getClientAccount().getId(), is(1L));
        assertThat(clientAccountTransaction.getClientAccount().getCurrency(), is("EUR"));
        assertThat(clientAccountTransaction.getClientAccount().getBalance().toString(), is("1.0"));
        assertThat(clientAccountTransaction.getClientAccount().getAccountNumber(), is("1111AAAABBBB"));
        assertThat(clientAccountTransaction.getClientAccount().getClient(), is(notNullValue()));

    }
}
