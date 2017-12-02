package lv.javaguru.java3OnlineBanking.common.dtos.builders;

import lv.javaguru.java3OnlineBanking.common.dtos.CoreValidationErrorDTO;

public class CoreValidationErrorDTOBuilder {

    private String field;
    private String errorCode;
    private String description;

    private CoreValidationErrorDTOBuilder() {
    }

    public static CoreValidationErrorDTOBuilder createCoreValidationErrorDTO() {
        return new CoreValidationErrorDTOBuilder();
    }

    public CoreValidationErrorDTO build() {
        CoreValidationErrorDTO coreValidationErrorDTO = new CoreValidationErrorDTO();

        coreValidationErrorDTO.setField(field);
        coreValidationErrorDTO.setErrorCode(errorCode);
        coreValidationErrorDTO.setDescription(description);

        return coreValidationErrorDTO;
    }

    public CoreValidationErrorDTOBuilder withField(String field) {
        this.field = field;
        return this;
    }

    public CoreValidationErrorDTOBuilder withErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public CoreValidationErrorDTOBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
}
