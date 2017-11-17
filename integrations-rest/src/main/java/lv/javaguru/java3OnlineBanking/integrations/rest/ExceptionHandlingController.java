package lv.javaguru.java3OnlineBanking.integrations.rest;

import lv.javaguru.java3OnlineBanking.common.dtos.ApplicationErrorDTO;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.ResourceNotFoundException;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.clientaccounttransactions.AccountBalanceHasNotEnoughResources;
import lv.javaguru.java3OnlineBanking.core.api.exceptions.clientaccounttransactions.AmountLessOrEqualsToZeroException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import static lv.javaguru.java3OnlineBanking.common.dtos.builders.ApplicationErrorDTOBuilder.createApplicationErrorDTOBuilder;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        ApplicationErrorDTO applicationError = createApplicationErrorDTOBuilder()
                .withStatus(BAD_REQUEST)
                .withMessage("Malformed JSON request")
                .withDebugMessage(exception)
                .build();

        return ResponseEntity
                .status(applicationError.getStatus())
                .body(applicationError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException exception) {

        ApplicationErrorDTO applicationError = createApplicationErrorDTOBuilder()
                .withStatus(NOT_FOUND)
                .withMessage(exception.getMessage())
                .build();

        return ResponseEntity
                .status(applicationError.getStatus())
                .body(applicationError);
    }

    @ExceptionHandler(AmountLessOrEqualsToZeroException.class)
    public ResponseEntity<Object> handleAmountLessOrEqualsToZero(AmountLessOrEqualsToZeroException exception) {

        ApplicationErrorDTO applicationError = createApplicationErrorDTOBuilder()
                .withStatus(BAD_REQUEST)
                .withMessage(exception.getMessage())
                .build();

        return ResponseEntity
                .status(applicationError.getStatus())
                .body(applicationError);
    }

    @ExceptionHandler(AccountBalanceHasNotEnoughResources.class)
    public ResponseEntity<Object> handleAccountBalanceHasNotEnoughResources(AccountBalanceHasNotEnoughResources exception) {

        ApplicationErrorDTO applicationError = createApplicationErrorDTOBuilder()
                .withStatus(BAD_REQUEST)
                .withMessage(exception.getMessage())
                .build();

        return ResponseEntity
                .status(applicationError.getStatus())
                .body(applicationError);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleInternalError(Throwable exception) {

        ApplicationErrorDTO applicationError = createApplicationErrorDTOBuilder()
                .withStatus(INTERNAL_SERVER_ERROR)
                .withMessage(exception.getMessage())
                .withDebugMessage(exception)
                .build();

        return ResponseEntity
                .status(applicationError.getStatus())
                .body(applicationError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        ApplicationErrorDTO applicationError = createApplicationErrorDTOBuilder()
                .withStatus(BAD_REQUEST)
                .withMessage("Validation error")
                .withSubErrorsFieldErrors(ex.getBindingResult().getFieldErrors())
                .withSubErrorsGlobalErrors(ex.getBindingResult().getGlobalErrors())
                .build();

        return ResponseEntity
                .status(applicationError.getStatus())
                .body(applicationError);
    }
}
