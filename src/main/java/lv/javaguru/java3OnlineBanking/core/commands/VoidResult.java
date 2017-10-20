package lv.javaguru.java3OnlineBanking.core.commands;

import lv.javaguru.java3OnlineBanking.core.commands.api.DomainCommandResult;

public class VoidResult implements DomainCommandResult {

    public static final VoidResult INSTANCE = new VoidResult();

    private VoidResult() {
    }
}
