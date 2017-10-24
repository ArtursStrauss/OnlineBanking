package lv.javaguru.java3OnlineBanking.core.commands.clientAccount;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;

import static lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTOBuilder.createClientAccountDTO;

import org.springframework.stereotype.Component;

@Component
public class ClientAccountConverter {

    public ClientAccountDTO convert(ClientAccount clientAccount) {

        return createClientAccountDTO()
                .withId(clientAccount.getId())
                .withAccountNumber(clientAccount.getAccountNumber())
                .withCurrency(clientAccount.getCurrency())
                .withBalance(clientAccount.getBalance())
                .withClientId(clientAccount.getId())
                .build();
    }
}
