package lv.javaguru.java3OnlineBanking.core.api;

public class VoidResult implements DomainCommandResult {

    public static final VoidResult INSTANCE = new VoidResult();

    private VoidResult() {
    }
}
