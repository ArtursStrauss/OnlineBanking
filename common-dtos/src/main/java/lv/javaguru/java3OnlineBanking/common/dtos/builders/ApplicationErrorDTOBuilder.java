package lv.javaguru.java3OnlineBanking.common.dtos.builders;

import com.fasterxml.jackson.annotation.JsonFormat;
import lv.javaguru.java3OnlineBanking.common.dtos.ApplicationErrorDTO;
import lv.javaguru.java3OnlineBanking.common.dtos.ApplicationValidationErrorDTO;
import lv.javaguru.java3OnlineBanking.common.dtos.api.ApplicationValidationError;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static lv.javaguru.java3OnlineBanking.common.dtos.builders.ApplicationValidationErrorDTOBuilder.createApplicationValidationErrorDTO;

public class ApplicationErrorDTOBuilder {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ApplicationValidationError> subErrors;

    private ApplicationErrorDTOBuilder() {
        this.timestamp = LocalDateTime.now();
        this.subErrors = new ArrayList<>();
    }

    public static ApplicationErrorDTOBuilder createApplicationErrorDTOBuilder() {
        return new ApplicationErrorDTOBuilder();
    }

    public ApplicationErrorDTO build() {
        ApplicationErrorDTO applicationError = new ApplicationErrorDTO();
        applicationError.setStatus(status);
        applicationError.setTimestamp(timestamp);
        applicationError.setMessage(message);
        applicationError.setDebugMessage(debugMessage);
        applicationError.setSubErrors(subErrors);

        return applicationError;
    }

    public ApplicationErrorDTOBuilder withStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ApplicationErrorDTOBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public ApplicationErrorDTOBuilder withDebugMessage(Throwable ex) {
        this.debugMessage = ex.getLocalizedMessage();
        return this;
    }

    public ApplicationErrorDTOBuilder withSubErrors(List<ApplicationValidationError> subErrors) {
        this.subErrors = subErrors;
        return this;
    }

    public ApplicationErrorDTOBuilder withSubErrorsFieldErrors(List<FieldError> fieldErrors) {
        addValidationErrors(fieldErrors);
        return this;
    }

    public ApplicationErrorDTOBuilder withSubErrorsGlobalErrors(List<ObjectError> globalErrors) {
        addValidationError(globalErrors);
        return this;
    }

    public ApplicationErrorDTOBuilder withSubErrorsConstraintViolations(Set<ConstraintViolation<?>> constraintViolations) {
        addValidationErrors(constraintViolations);
        return this;
    }

    private void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

    private void addValidationError(List<ObjectError> globalErrors) {
        globalErrors.forEach(this::addValidationError);
    }

    private void addValidationError(FieldError fieldError) {

        ApplicationValidationErrorDTO applicationValidationError = createApplicationValidationErrorDTO()
                .withObject(fieldError.getObjectName())
                .withField(fieldError.getField())
                .withRejectedValue(fieldError.getRejectedValue())
                .withMessage(fieldError.getDefaultMessage())
                .build();

        addSubError(applicationValidationError);
    }

    private void addValidationError(ObjectError objectError) {

        ApplicationValidationErrorDTO applicationValidationError = createApplicationValidationErrorDTO()
                .withObject(objectError.getObjectName())
                .withMessage(objectError.getDefaultMessage())
                .build();

        addSubError(applicationValidationError);
    }

    private void addSubError(ApplicationValidationError applicationValidationError) {
        if (applicationValidationError == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(applicationValidationError);
    }

    /**
     * Utility method for adding error of ConstraintViolation. Usually when a @Validated validation fails.
     *
     * @param cv the ConstraintViolation
     */
    private void addValidationError(ConstraintViolation<?> cv) {

        ApplicationValidationErrorDTO applicationValidationError = createApplicationValidationErrorDTO()
                .withObject(cv.getRootBeanClass().getSimpleName())
                .withField(((PathImpl) cv.getPropertyPath()).getLeafNode().asString())
                .withRejectedValue(cv.getInvalidValue())
                .withMessage(cv.getMessage())
                .build();

        addSubError(applicationValidationError);
    }

    private void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
        constraintViolations.forEach(this::addValidationError);
    }
}
