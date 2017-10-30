package lv.javaguru.java3OnlineBanking.core.commands.clientaccounttransactions;

import lv.javaguru.java3OnlineBanking.core.commands.clientaccounts.ClientAccountConverter;
import lv.javaguru.java3OnlineBanking.core.commands.clients.ClientConverter;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransaction;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountTransactionDTO;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountTransactionDTOBuilder.createClientAccountTransactionDTOBuilder;

@Component
public class ClientAccountTransactionConverter {

    @Autowired
    private ClientConverter clientConverter;
    @Autowired
    private ClientAccountConverter clientAccountConverter;

    public ClientAccountTransactionDTO convert(ClientAccountTransaction clientAccountTransaction) {

        ClientDTO clientDTO = clientConverter.convert(clientAccountTransaction.getClient());
        ClientAccountDTO clientAccountDTO = clientAccountConverter.convert(clientAccountTransaction.getClientAccount());

        return createClientAccountTransactionDTOBuilder()
                .withId(clientAccountTransaction.getId())
                .withClient(clientDTO)
                .withClientAccount(clientAccountDTO)
                .withTransactionType(clientAccountTransaction.getTransactionType())
                .withAmount(clientAccountTransaction.getAmount())
                .withCurrency(clientAccountTransaction.getCurrency())
                .withResultBalance(clientAccountTransaction.getResultBalance())
                .withStatus(clientAccountTransaction.getStatus())
                .build();
    }
}
