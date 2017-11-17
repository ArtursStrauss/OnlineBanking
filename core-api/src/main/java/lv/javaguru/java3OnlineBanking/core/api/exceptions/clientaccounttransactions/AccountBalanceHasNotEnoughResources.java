package lv.javaguru.java3OnlineBanking.core.api.exceptions.clientaccounttransactions;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.ApplicationException;

public class AccountBalanceHasNotEnoughResources extends ApplicationException {
    public AccountBalanceHasNotEnoughResources(String message) {
        super(message);
    }
}
