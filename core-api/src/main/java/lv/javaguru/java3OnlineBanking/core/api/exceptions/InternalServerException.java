package lv.javaguru.java3OnlineBanking.core.api.exceptions;

import lv.javaguru.java3OnlineBanking.core.api.jms.CoreExceptionTypes;
import org.springframework.http.HttpStatus;

public class InternalServerException extends ApplicationException {
    public InternalServerException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public String getExceptionType() {
        return CoreExceptionTypes.CORE_INTERNAL_SERVER_ERROR;
    }
}
