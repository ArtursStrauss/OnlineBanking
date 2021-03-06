package lv.javaguru.java3OnlineBanking.core.handlers.clientaccounts;

import lv.javaguru.java3OnlineBanking.common.dtos.ClientAccountDTO;
import lv.javaguru.java3OnlineBanking.core.commands.clientaccounts.GetClientAccountsByClientIdCommand;
import lv.javaguru.java3OnlineBanking.core.commands.clientaccounts.GetClientAccountsByClientIdResult;
import lv.javaguru.java3OnlineBanking.core.domain.ClientAccount;
import lv.javaguru.java3OnlineBanking.core.handlers.DomainCommandHandler;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounts.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetClientAccountsByClientIdCommandHandler implements DomainCommandHandler<GetClientAccountsByClientIdCommand, GetClientAccountsByClientIdResult> {

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
