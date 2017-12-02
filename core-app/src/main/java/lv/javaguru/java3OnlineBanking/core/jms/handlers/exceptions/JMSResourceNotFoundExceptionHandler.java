package lv.javaguru.java3OnlineBanking.core.jms.handlers.exceptions;

import lv.javaguru.java3OnlineBanking.common.dtos.ApplicationErrorDTO;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.ApplicationException;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.ResourceNotFoundException;
import lv.javaguru.java3OnlineBanking.core.api.jms.CoreExceptionTypes;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.exceptions.JMSResourceNotFoundErrorResponse;
import lv.javaguru.java3OnlineBanking.core.jms.JMSRequestExceptionHandler;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3OnlineBanking.common.dtos.builders.ApplicationErrorDTOBuilder.createApplicationErrorDTO;

@Component
public class JMSResourceNotFoundExceptionHandler extends JMSRequestExceptionHandler {

    @Override
    public String getSupportedExceptionType() {
        return CoreExceptionTypes.RESOURCE_NOT_FOUND_ERROR;
    }

    @Override
    public String process(ApplicationException e) {

        ResourceNotFoundException exception = (ResourceNotFoundException) e;

        ApplicationErrorDTO applicationErrorDTO = createApplicationErrorDTO()
                .withMessage(exception.getMessage())
                .withStatus(exception.getResultStatus())
                .build();

        JMSResourceNotFoundErrorResponse response = new JMSResourceNotFoundErrorResponse();
        response.setApplicationErrorDTO(applicationErrorDTO);

        return buildPayload(response);
    }
}
