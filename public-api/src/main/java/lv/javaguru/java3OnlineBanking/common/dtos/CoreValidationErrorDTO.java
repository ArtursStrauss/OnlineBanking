package lv.javaguru.java3OnlineBanking.common.dtos;

import lv.javaguru.java3OnlineBanking.common.dtos.api.ApplicationValidationError;

public class CoreValidationErrorDTO implements ApplicationValidationError {

    private String field;
    private String errorCode;
    private String description;

    public CoreValidationErrorDTO() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CoreValidationErrorDTO{" +
                "field='" + field + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
