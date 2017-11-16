package lv.javaguru.java3OnlineBanking.core.api.exceptions.clientaccounttransactions;


public class AmountLessOrEqualsToZeroException extends RuntimeException{

    public AmountLessOrEqualsToZeroException(String message){
        super(message);
    }
}
