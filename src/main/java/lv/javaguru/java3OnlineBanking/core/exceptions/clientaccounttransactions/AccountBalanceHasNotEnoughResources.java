package lv.javaguru.java3OnlineBanking.core.exceptions.clientaccounttransactions;

public class AccountBalanceHasNotEnoughResources extends RuntimeException {
    public AccountBalanceHasNotEnoughResources(String message) {
        super(message);
    }
}
