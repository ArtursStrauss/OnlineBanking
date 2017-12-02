package lv.javaguru.java3OnlineBanking.core.jms.handlers.exceptions;

import lv.javaguru.java3OnlineBanking.common.dtos.ApplicationErrorDTO;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.ApplicationException;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.InternalServerException;
import lv.javaguru.java3OnlineBanking.core.api.jms.CoreExceptionTypes;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.exceptions.JMSInternalServerErrorResponse;
import lv.javaguru.java3OnlineBanking.core.jms.JMSRequestExceptionHandler;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3OnlineBanking.common.dtos.builders.ApplicationErrorDTOBuilder.createApplicationErrorDTO;

@Component
public class JMSInternalServerExceptionHandler extends JMSRequestExceptionHandler {

    @Override
    public String getSupportedExceptionType() {
        return CoreExceptionTypes.CORE_VALIDATION_ERROR;
    }

    @Override
    public String process(ApplicationException e) {

        InternalServerException exception = (InternalServerException) e;

        ApplicationErrorDTO applicationErrorDTO = createApplicationErrorDTO()
                .withMessage(exception.getMessage())
                .withStatus(exception.getResultStatus())
                .build();

        JMSInternalServerErrorResponse response = new JMSInternalServerErrorResponse();
        response.setApplicationErrorDTO(applicationErrorDTO);

        return buildPayload(response);
    }
}
