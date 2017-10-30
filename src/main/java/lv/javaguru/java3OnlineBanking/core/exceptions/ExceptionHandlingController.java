package lv.javaguru.java3OnlineBanking.core.exceptions;

import lv.javaguru.java3OnlineBanking.core.exceptions.clientaccounttransactions.AmountLessOrEqualsToZeroException;
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
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String errorMessage = "Malformed JSON request";
        ApiError error = new ApiError(BAD_REQUEST, errorMessage, ex);
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFound(ResourceNotFoundException exception) {

        ApiError error = new ApiError(NOT_FOUND);
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(AmountLessOrEqualsToZeroException.class)
    public ResponseEntity<Object> amountLessOrEqualsToZero(AmountLessOrEqualsToZeroException exception) {

        ApiError error = new ApiError(BAD_REQUEST);
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, error.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        ApiError error = new ApiError(BAD_REQUEST);
        error.setMessage("Validation error");

        error.addValidationErrors(ex.getBindingResult().getFieldErrors());
        error.addValidationError(ex.getBindingResult().getGlobalErrors());

        return new ResponseEntity<>(error, error.getStatus());
    }
}
