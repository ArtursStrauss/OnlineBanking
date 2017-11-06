package lv.javaguru.java3OnlineBanking.core.handlers.clientaccounts;


import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountDTOBuilder;
import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.handlers.clients.ClientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientAccountConverter {

    @Autowired
    private ClientConverter clientConverter;

    public ClientAccountDTO convert(ClientAccount clientAccount) {

        ClientDTO clientDTO = clientConverter.convert(clientAccount.getClient());

        return ClientAccountDTOBuilder.createClientAccountDTO()
                .withId(clientAccount.getId())
                .withAccountNumber(clientAccount.getAccountNumber())
                .withCurrency(clientAccount.getCurrency())
                .withBalance(clientAccount.getBalance())
                .withClientDTO(clientDTO)
                .build();
    }
}
