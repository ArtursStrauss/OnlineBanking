package lv.javaguru.java3OnlineBanking.core.commands.clientAccount;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.integrations.rest.dto.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.services.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clientAccounts.api.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetClientAccountsByClientIdHandler implements DomainCommandHandler<GetClientAccountsByClientIdCommand, GetClientAccountsByClientIdResult> {

    @Autowired
    private ClientAccountService clientAccountService;
    @Autowired
    private ClientAccountConverter clientAccountConverter;

    @Override
    public GetClientAccountsByClientIdResult execute(GetClientAccountsByClientIdCommand command) {

        List<ClientAccount> clientAccounts = clientAccountService.getAllAccountsByClientId(
                command.getClientId()
        );

        List<ClientAccountDTO> clientAccountDTOs = new ArrayList<>();
        clientAccounts.forEach(
                clientAccount -> clientAccountDTOs.add(clientAccountConverter.convert(clientAccount))
        );

        return new GetClientAccountsByClientIdResult(clientAccountDTOs);
    }

    @Override
    public Class getCommandType() {
        return GetClientAccountsByClientIdCommand.class;
    }
}
