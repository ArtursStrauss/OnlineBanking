package lv.javaguru.java3OnlineBanking.core.api.jms.requests.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3OnlineBanking.core.api.jms.SupportedCommandId;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.JMSAPIRequest;

public class JMSGetClientByLoginRequest implements JMSAPIRequest {

    @JsonProperty("login")
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getCommandId() {
        return SupportedCommandId.GET_CLIENT_BY_LOGIN;
    }
}
