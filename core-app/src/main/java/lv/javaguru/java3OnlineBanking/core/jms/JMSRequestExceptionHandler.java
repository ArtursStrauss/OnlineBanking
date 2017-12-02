package lv.javaguru.java3OnlineBanking.core.jms;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.ApplicationException;
import lv.javaguru.java3OnlineBanking.core.commons.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class JMSRequestExceptionHandler {
    @Autowired
    protected JsonMapper jsonMapper;

    public abstract String getSupportedExceptionType();

    public boolean canProcess(ApplicationException exception) {
        return exception.getExceptionType().equals(getSupportedExceptionType());
    }

    public abstract String process(ApplicationException exception);

    protected String buildPayload(Object exceptionResponse) {
        return jsonMapper.mapToString(exceptionResponse);
    }
}
