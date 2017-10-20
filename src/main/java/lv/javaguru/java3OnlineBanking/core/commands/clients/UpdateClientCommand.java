package lv.javaguru.java3OnlineBanking.core.commands.clients;

import lv.javaguru.java3OnlineBanking.core.commands.clients.api.DomainCommand;

public class UpdateClientCommand implements DomainCommand<UpdateClientResult> {

    private Long id;
    private String login;
    private String password;
    private String fullName;

    public UpdateClientCommand(Long id, String login, String password, String fullName) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
