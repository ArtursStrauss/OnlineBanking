package lv.javaguru.java3OnlineBanking.core.commands.clients;


import lv.javaguru.java3OnlineBanking.core.commands.DomainCommand;

public class GetClientByLoginCommand implements DomainCommand<GetClientByLoginResult> {

    private String login;

    public GetClientByLoginCommand(String login){
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
