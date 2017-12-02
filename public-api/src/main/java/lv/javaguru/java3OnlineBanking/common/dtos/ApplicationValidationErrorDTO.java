package lv.javaguru.java3OnlineBanking.common.dtos;

import lv.javaguru.java3OnlineBanking.common.dtos.api.ApplicationValidationError;

public class ApplicationValidationErrorDTO implements ApplicationValidationError {

    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ApplicationValidationErrorDTO() {

    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApplicationValidationErrorDTO{" +
                "object='" + object + '\'' +
                ", field='" + field + '\'' +
                ", rejectedValue=" + rejectedValue +
                ", message='" + message + '\'' +
                '}';
    }
}
