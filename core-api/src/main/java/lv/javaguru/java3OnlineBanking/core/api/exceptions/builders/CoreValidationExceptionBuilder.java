package lv.javaguru.java3OnlineBanking.core.api.exceptions.builders;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.CoreValidationError;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.CoreValidationException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class CoreValidationExceptionBuilder {


    private HttpStatus status;
    private String message;
    private List<CoreValidationError> errors = new ArrayList<>();

    private CoreValidationExceptionBuilder() {

    }

    public static CoreValidationExceptionBuilder createCoreValidationException() {
        return new CoreValidationExceptionBuilder();
    }

    public CoreValidationException build() {
        CoreValidationError[] validationErrors = errors.stream().toArray(CoreValidationError[]::new);
        return new CoreValidationException(status, message, validationErrors);
    }

    public CoreValidationExceptionBuilder withStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public CoreValidationExceptionBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public CoreValidationExceptionBuilder withValidationErrors(List<CoreValidationError> validationErrors) {
        this.errors.addAll(validationErrors);
        return this;
    }

    public CoreValidationExceptionBuilder withValidationError(CoreValidationError validationError) {
        this.errors.add(validationError);
        return this;
    }
}
