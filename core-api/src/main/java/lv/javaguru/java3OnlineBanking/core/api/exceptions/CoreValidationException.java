package lv.javaguru.java3OnlineBanking.core.api.exceptions;

import lv.javaguru.java3OnlineBanking.core.api.jms.CoreExceptionTypes;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoreValidationException extends ApplicationException {

    private List<CoreValidationError> validationErrors;

    public CoreValidationException(HttpStatus resultStatus) {
        super(resultStatus);
    }

    public CoreValidationException(HttpStatus resultStatus, CoreValidationError... validationErrors) {
        super(resultStatus);
        this.validationErrors = Arrays.stream(validationErrors).collect(Collectors.toList());
    }

    public CoreValidationException(HttpStatus resultStatus,
                                   String message,
                                   CoreValidationError... validationErrors) {
        super(resultStatus, message);
        this.validationErrors = Arrays.stream(validationErrors).collect(Collectors.toList());
    }

    public List<CoreValidationError> getValidationErrors() {
        return validationErrors;
    }

    public String getExceptionType() {
        return CoreExceptionTypes.CORE_VALIDATION_ERROR;
    }

    @Override
    public String toString() {
        return "CoreValidationException{" +
                "validationErrors=" + validationErrors +
                '}';
    }
}
