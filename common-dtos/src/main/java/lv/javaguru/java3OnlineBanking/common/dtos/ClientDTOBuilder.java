package lv.javaguru.java3OnlineBanking.common.dtos;

public class ClientDTOBuilder {

    private Long id;
    private String login;
    private String password;
    private String fullName;

    private ClientDTOBuilder() {
    }

    public static ClientDTOBuilder createClientDTO() {
        return new ClientDTOBuilder();
    }

    public ClientDTO build() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(id);
        clientDTO.setLogin(login);
        clientDTO.setPassword(password);
        clientDTO.setFullName(fullName);
        return clientDTO;
    }

    public ClientDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientDTOBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public ClientDTOBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public ClientDTOBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
