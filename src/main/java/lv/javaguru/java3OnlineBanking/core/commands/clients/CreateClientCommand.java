package lv.javaguru.java3OnlineBanking.core.commands.clients;

import lv.javaguru.java3OnlineBanking.core.commands.clients.api.DomainCommand;

public class CreateClientCommand implements DomainCommand<CreateClientResult> {

    private String login;
    private String password;
    private String fullName;

    public CreateClientCommand(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
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
