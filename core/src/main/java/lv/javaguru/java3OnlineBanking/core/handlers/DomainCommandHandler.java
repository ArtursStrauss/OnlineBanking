package lv.javaguru.java3OnlineBanking.core.handlers;

public interface DomainCommandHandler<C, R> {

    R execute(C command);

    Class getCommandType();
}
