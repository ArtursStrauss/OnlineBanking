package lv.javaguru.java3OnlineBanking.core.api.exceptions.clientaccounttransactions;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.ApplicationException;
import lv.javaguru.java3OnlineBanking.core.api.jms.CoreExceptionTypes;

public class AccountBalanceHasNotEnoughResources extends ApplicationException {
    public AccountBalanceHasNotEnoughResources(String message) {
        super(message);
    }

    @Override
    public String getExceptionType() {
        return CoreExceptionTypes.BALANCE_HAS_NOT_ENOUGH_RESOURCES_ERROR;
    }
}
