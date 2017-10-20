package lv.javaguru.java3OnlineBanking.core.commands.clients;

import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientDTOBuilder.createClientDTO;

@Component
class ClientConverter {

    public ClientDTO convert(Client client) {
        return createClientDTO()
                .withId(client.getId())
                .withLogin(client.getLogin())
                .withPassword(client.getPassword())
                .withFullName(client.getFullName())
                .build();
    }
}
