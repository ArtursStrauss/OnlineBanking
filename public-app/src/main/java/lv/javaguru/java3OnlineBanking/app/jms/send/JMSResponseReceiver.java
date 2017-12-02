package lv.javaguru.java3OnlineBanking.app.jms.send;

import lv.javaguru.java3OnlineBanking.app.common.JsonMapper;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSQueues;
import lv.javaguru.java3OnlineBanking.core.api.jms.JMSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class JMSResponseReceiver {

    @Autowired
    private JsonMapper jsonMapper;
    @Autowired
    private JMSResponseProcessor jmsResponseProcessor;

    @JmsListener(destination = JMSQueues.PUBLIC_APP_RESPONSE_QUEUE,
            selector = "JMSCorrelationID = '#{ApplicationCorrelationIdHolder.CORRELATION_ID}'",
            concurrency = "${jms.response.listener.concurrency:10}")
    public void onMessage(TextMessage message) throws JMSException {
        String messageText = message.getText();
        JMSResponse response = jsonMapper.mapToObject(messageText, JMSResponse.class);
        jmsResponseProcessor.process(response);
    }
}
