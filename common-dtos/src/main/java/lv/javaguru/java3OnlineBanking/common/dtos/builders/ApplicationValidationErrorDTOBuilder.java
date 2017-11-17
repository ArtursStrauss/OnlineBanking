package lv.javaguru.java3OnlineBanking.common.dtos.builders;

import lv.javaguru.java3OnlineBanking.common.dtos.ApplicationValidationErrorDTO;

public class ApplicationValidationErrorDTOBuilder {

    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    private ApplicationValidationErrorDTOBuilder() {
    }

    public static ApplicationValidationErrorDTOBuilder createApplicationValidationErrorDTO() {
        return new ApplicationValidationErrorDTOBuilder();
    }

    public ApplicationValidationErrorDTO build() {

        ApplicationValidationErrorDTO validationError = new ApplicationValidationErrorDTO();

        validationError.setObject(object);
        validationError.setField(field);
        validationError.setRejectedValue(rejectedValue);
        validationError.setMessage(message);

        return validationError;
    }

    public ApplicationValidationErrorDTOBuilder withObject(String object) {
        this.object = object;
        return this;
    }

    public ApplicationValidationErrorDTOBuilder withField(String field) {
        this.field = field;
        return this;
    }

    public ApplicationValidationErrorDTOBuilder withRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
        return this;
    }

    public ApplicationValidationErrorDTOBuilder withMessage(String message) {
        this.message = message;
        return this;
    }
}
