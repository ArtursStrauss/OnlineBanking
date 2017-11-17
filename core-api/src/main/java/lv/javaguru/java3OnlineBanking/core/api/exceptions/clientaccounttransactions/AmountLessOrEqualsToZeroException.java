package lv.javaguru.java3OnlineBanking.core.api.exceptions.clientaccounttransactions;


import lv.javaguru.java3OnlineBanking.core.api.exceptions.ApplicationException;

public class AmountLessOrEqualsToZeroException extends ApplicationException {

    public AmountLessOrEqualsToZeroException(String message) {
        super(message);
    }
}
