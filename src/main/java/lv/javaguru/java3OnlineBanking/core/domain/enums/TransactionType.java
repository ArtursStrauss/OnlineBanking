package lv.javaguru.java3OnlineBanking.core.domain.enums;

public enum TransactionType {
    DEPOSIT,
    WITHDRAW,
    TRANSFER_IN,
    TRANSFER_OUT,
    CORRECTION;

    public static boolean contains(String value){
        for (TransactionType p: TransactionType.values()){
            if (p.name().equals(value)){
                return true;
            }
        }
        return false;
    }
}
