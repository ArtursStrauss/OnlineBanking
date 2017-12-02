package lv.javaguru.java3OnlineBanking.core.api.exceptions;

import lv.javaguru.java3OnlineBanking.core.api.jms.CoreExceptionTypes;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApplicationException {

    private Object object;

    public ResourceNotFoundException(Object object, String message) {
        super(HttpStatus.BAD_REQUEST, message);
        this.object = object;
    }

    @Override
    public String getExceptionType() {
        return CoreExceptionTypes.RESOURCE_NOT_FOUND_ERROR;
    }
}
