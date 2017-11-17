package lv.javaguru.java3OnlineBanking.core.handlers.clients;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3OnlineBanking.common.dtos.builders.ClientDTOBuilder.createClientDTO;

@Component
public class ClientConverter {

    public ClientDTO convert(Client client) {
        return createClientDTO()
                .withId(client.getId())
                .withLogin(client.getLogin())
                .withPassword(client.getPassword())
                .withFullName(client.getFullName())
                .build();
    }
}
