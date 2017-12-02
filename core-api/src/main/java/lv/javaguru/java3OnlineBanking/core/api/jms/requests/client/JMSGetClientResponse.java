package lv.javaguru.java3OnlineBanking.core.api.jms.requests.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3OnlineBanking.common.dtos.ClientDTO;

public class JMSGetClientResponse {

    @JsonProperty("client")
    private ClientDTO clientDTO;

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }
}
