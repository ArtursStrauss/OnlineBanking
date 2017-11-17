package lv.javaguru.java3OnlineBanking.core.api.exceptions;

public abstract class ApplicationException extends RuntimeException {

    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }
}
