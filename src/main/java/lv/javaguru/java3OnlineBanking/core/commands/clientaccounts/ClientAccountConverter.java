package lv.javaguru.java3OnlineBanking.core.commands.clientaccounts;

import lv.javaguru.java3OnlineBanking.core.commands.clients.ClientConverter;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;

import static lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTOBuilder.createClientAccountDTO;

import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientAccountConverter {

    @Autowired
    private ClientConverter clientConverter;

    public ClientAccountDTO convert(ClientAccount clientAccount) {

        ClientDTO clientDTO = clientConverter.convert(clientAccount.getClient());

        return createClientAccountDTO()
                .withId(clientAccount.getId())
                .withAccountNumber(clientAccount.getAccountNumber())
                .withCurrency(clientAccount.getCurrency())
                .withBalance(clientAccount.getBalance())
                .withClientDTO(clientDTO)
                .build();
    }
}
