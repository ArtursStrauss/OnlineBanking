package lv.javaguru.java3OnlineBanking.core.jms.handlers.exceptions;

import lv.javaguru.java3OnlineBanking.common.dtos.ApplicationErrorDTO;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.ApplicationException;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.CoreValidationException;
import lv.javaguru.java3OnlineBanking.core.api.jms.CoreExceptionTypes;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.exceptions.JMSCoreValidationErrorResponse;
import lv.javaguru.java3OnlineBanking.core.jms.JMSRequestExceptionHandler;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static lv.javaguru.java3OnlineBanking.common.dtos.builders.ApplicationErrorDTOBuilder.createApplicationErrorDTO;
import static lv.javaguru.java3OnlineBanking.common.dtos.builders.CoreValidationErrorDTOBuilder.createCoreValidationErrorDTO;

@Component
public class JMSCoreValidationExceptionHandler extends JMSRequestExceptionHandler {

    @Override
    public String getSupportedExceptionType() {
        return CoreExceptionTypes.CORE_VALIDATION_ERROR;
    }

    @Override
    public String process(ApplicationException e) {

        CoreValidationException exception = (CoreValidationException) e;

        ApplicationErrorDTO applicationErrorDTO = createApplicationErrorDTO()
                .withMessage(exception.getMessage())
                .withStatus(exception.getResultStatus())
                .withSubErrors(exception.getValidationErrors().stream().map(
                        error -> {
                            return createCoreValidationErrorDTO()
                                    .withErrorCode(error.getErrorCode())
                                    .withDescription(error.getDescription())
                                    .withField(error.getField())
                                    .build();

                        }
                        ).collect(Collectors.toList())
                ).build();

        JMSCoreValidationErrorResponse response = new JMSCoreValidationErrorResponse();
        response.setApplicationErrorDTO(applicationErrorDTO);

        return buildPayload(response);
    }
}
