package lv.javaguru.java3OnlineBanking.core.api.jms.requests.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;
import lv.javaguru.java3OnlineBanking.core.api.jms.SupportedCommandId;
import lv.javaguru.java3OnlineBanking.core.api.jms.requests.JMSAPIRequest;

public class JMSUpdateClientRequest implements JMSAPIRequest {

    @JsonProperty("client")
    private ClientDTO clientDTO;

    @Override
    public String getCommandId() {
        return SupportedCommandId.UPDATE_CLIENT;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }
}
