package lv.javaguru.java3OnlineBanking.core.api.jms;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class JMSResponse {

    @JsonProperty("command_id")
    private String commandId;

    @JsonProperty("correlation_id")
    private String correlationId;

    @JsonProperty("response_status")
    private HttpStatus responseStatus;

    @JsonProperty("payload")
    private String payload;

    @JsonProperty("error")
    private String error;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return HttpStatus.OK.equals(responseStatus);
    }

    @Override
    public String toString() {
        return "JMSResponse{" +
                "commandId='" + commandId + '\'' +
                ", correlationId='" + correlationId + '\'' +
                ", responseStatus=" + responseStatus +
                ", payload='" + payload + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
