package lv.javaguru.java3OnlineBanking.core.services;

import lv.javaguru.java3OnlineBanking.core.commands.DomainCommand;
import lv.javaguru.java3OnlineBanking.core.commands.DomainCommandResult;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);
}
