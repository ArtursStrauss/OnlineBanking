package lv.javaguru.java3OnlineBanking.core.services.clientaccounts;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.domain.builders.ClientAccountBuilder;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.domain.repositories.ClientAccountRepository;
import lv.javaguru.java3OnlineBanking.core.services.clients.ClientService;
import lv.javaguru.java3OnlineBanking.core.utils.GenerateAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public interface ClientAccountFactory {
    ClientAccount create(String currency, ClientDTO clientDTO);
}

@Component
class ClientAccountFactoryImpl implements ClientAccountFactory {

    private static final BigDecimal INITIAL_BALANCE = new BigDecimal("0.0");

    @Autowired
    private GenerateAccount generateAccount;
    @Autowired
    private ClientAccountRepository clientAccountRepository;
    @Autowired
    private ClientService clientService;

    @Override
    public ClientAccount create(String currency, ClientDTO clientDTO) {

        String accountNumber = generateAccount.generateAccount();
        Client client = clientService.get(clientDTO.getId());

        ClientAccount clientAccount = ClientAccountBuilder.createClientAccount()
                .withAccountNumber(accountNumber)
                .withCurrency(currency)
                .withBalance(INITIAL_BALANCE)
                .withClient(client)
                .build();

        clientAccountRepository.save(clientAccount);

        return clientAccount;
    }
}
