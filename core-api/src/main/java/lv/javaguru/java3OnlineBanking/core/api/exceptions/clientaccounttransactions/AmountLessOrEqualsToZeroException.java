package lv.javaguru.java3OnlineBanking.core.api.exceptions.clientaccounttransactions;


import lv.javaguru.java3OnlineBanking.core.api.exceptions.ApplicationException;
import lv.javaguru.java3OnlineBanking.core.api.jms.CoreExceptionTypes;

public class AmountLessOrEqualsToZeroException extends ApplicationException {

    public AmountLessOrEqualsToZeroException(String message) {
        super(message);
    }

    @Override
    public String getExceptionType() {
        return CoreExceptionTypes.AMOUNT_LESS_OR_ZERO_ERROR;
    }
}
