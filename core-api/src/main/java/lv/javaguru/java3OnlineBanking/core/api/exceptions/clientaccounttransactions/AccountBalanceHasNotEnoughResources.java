package lv.javaguru.java3OnlineBanking.core.api.exceptions.clientaccounttransactions;

public class AccountBalanceHasNotEnoughResources extends RuntimeException {
    public AccountBalanceHasNotEnoughResources(String message) {
        super(message);
    }
}
