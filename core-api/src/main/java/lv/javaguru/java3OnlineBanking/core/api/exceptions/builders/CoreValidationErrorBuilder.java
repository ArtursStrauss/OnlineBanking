package lv.javaguru.java3OnlineBanking.core.api.exceptions.builders;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.CoreValidationError;

public class CoreValidationErrorBuilder {

    private String field;
    private String errorCode;
    private String description;

    private CoreValidationErrorBuilder() {

    }

    public static CoreValidationErrorBuilder createCoreValidationError() {
        return new CoreValidationErrorBuilder();
    }

    public CoreValidationError build() {
        CoreValidationError coreValidationError = new CoreValidationError();

        coreValidationError.setField(field);
        coreValidationError.setErrorCode(errorCode);
        coreValidationError.setDescription(description);

        return coreValidationError;
    }

    public CoreValidationErrorBuilder withField(String field) {
        this.field = field;
        return this;
    }

    public CoreValidationErrorBuilder withErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public CoreValidationErrorBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
}
