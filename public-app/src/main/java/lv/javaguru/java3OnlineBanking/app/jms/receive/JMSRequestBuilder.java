package lv.javaguru.java3OnlineBanking.app.jms.receive;

import lv.javaguru.java3OnlineBanking.app.common.JsonMapper;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSRequest;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.JMSAPIRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface JMSRequestBuilder {

    JMSRequest build(JMSAPIRequest command);
}

@Component
class JMSRequestBuilderImpl implements JMSRequestBuilder {

    @Autowired
    private JMSRequestCorrelationIdGenerator jmsRequestCorrelationIdGenerator;
    @Autowired
    private JsonMapper jsonMapper;

    @Override
    public JMSRequest build(JMSAPIRequest command) {

        JMSRequest jmsRequest = new JMSRequest();
        jmsRequest.setCommandId(command.getCommandId());
        jmsRequest.setCorrelationId(jmsRequestCorrelationIdGenerator.generate());
        jmsRequest.setPayload(jsonMapper.mapToString(command));
        return jmsRequest;
    }
}

