package lv.javaguru.java3OnlineBanking.core.services;

import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommand;
import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommandResult;

public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command);

    Class getCommandType();
}
