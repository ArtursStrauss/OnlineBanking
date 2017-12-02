package lv.javaguru.java3OnlineBanking.common.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lv.javaguru.java3OnlineBanking.common.dtos.api.ApplicationValidationError;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApplicationErrorDTO {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;

    private String message;
    private String debugMessage;
    private List<ApplicationValidationError> subErrors;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<ApplicationValidationError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApplicationValidationError> subErrors) {
        this.subErrors = subErrors;
    }

    @Override
    public String toString() {
        return "ApplicationErrorDTO{" +
                "status=" + status +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                ", subErrors=" + subErrors +
                '}';
    }
}
