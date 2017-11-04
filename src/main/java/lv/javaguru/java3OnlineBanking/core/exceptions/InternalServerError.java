package lv.javaguru.java3OnlineBanking.core.exceptions;

public class InternalServerError extends ApplicationException {

    public InternalServerError() {
        super(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}
