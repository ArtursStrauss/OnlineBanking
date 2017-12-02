package lv.javaguru.java3OnlineBanking.core.jms.send;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.ApplicationException;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

public interface JMSResponseBuilder {

    JMSResponse buildSuccess(JMSRequest request, String payload);

    JMSResponse buildFail(JMSRequest request, RuntimeException e);

    JMSResponse buildFail(JMSRequest request, String payload, ApplicationException e);
}

@Component
class JMSResponseBuilderImpl implements JMSResponseBuilder {

    @Override
    public JMSResponse buildSuccess(JMSRequest request, String payload) {
        return build(request, HttpStatus.OK, payload, null);
    }

    /*  @Override
      public JMSResponse buildFail(JMSRequest request, CoreValidationException e) {
          //String payload = jsonMapper.mapToString(e.getValidationErrors());
          String payload = jmsCoreValidationExceptionHandler.process(e);
          return build(request, e.getResultStatus(), payload, CoreExceptionTypes.CORE_VALIDATION_ERROR);
      }

      @Override
      public JMSResponse buildFail(JMSRequest request, InternalServerException e) {
          return build(request, e.getResultStatus(), null, null);
      }
  */
    @Override
    public JMSResponse buildFail(JMSRequest request, RuntimeException e) {
        return build(request, HttpStatus.INTERNAL_SERVER_ERROR, null, null);
    }

    @Override
    public JMSResponse buildFail(JMSRequest request, String payload, ApplicationException e) {
        return build(request, e.getResultStatus(), payload, e.getExceptionType());
    }

    private JMSResponse build(JMSRequest request,
                              HttpStatus responseStatus,
                              String payload,
                              String error) {
        JMSResponse response = new JMSResponse();
        response.setCommandId(request.getCommandId());
        response.setCorrelationId(request.getCorrelationId());
        response.setResponseStatus(responseStatus);
        response.setPayload(payload);
        response.setError(error);
        return response;
    }
}