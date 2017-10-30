package lv.javaguru.java3OnlineBanking.core.exceptions.clientaccounttransactions;


public class AmountLessOrEqualsToZeroException extends RuntimeException{

    public AmountLessOrEqualsToZeroException(String message){
        super(message);
    }
}
