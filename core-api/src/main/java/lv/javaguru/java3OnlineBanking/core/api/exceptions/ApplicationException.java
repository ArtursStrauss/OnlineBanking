package lv.javaguru.java3OnlineBanking.core.api.exceptions;

import org.springframework.http.HttpStatus;

public abstract class ApplicationException extends RuntimeException {

    private HttpStatus resultStatus;

    public ApplicationException() {
    }

    public ApplicationException(HttpStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(HttpStatus resultStatus,
                                String message) {
        super(message);
        this.resultStatus = resultStatus;
    }

    public HttpStatus getResultStatus() {
        return resultStatus;
    }
    public abstract String getExceptionType();
}
