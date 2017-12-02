package lv.javaguru.java3OnlineBanking.core.api.jms.requests.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3OnlineBanking.common.dtos.ApplicationErrorDTO;

public class JMSCoreValidationErrorResponse {

    @JsonProperty("application_error")
    private ApplicationErrorDTO applicationErrorDTO;

    public ApplicationErrorDTO getApplicationErrorDTO() {
        return applicationErrorDTO;
    }

    public void setApplicationErrorDTO(ApplicationErrorDTO applicationErrorDTO) {
        this.applicationErrorDTO = applicationErrorDTO;
    }

    @Override
    public String toString() {
        return "JMSCoreValidationErrorResponse{" +
                "applicationErrorDTO=" + applicationErrorDTO +
                '}';
    }
}
