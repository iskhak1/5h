package ru.geekbrains.chat.server;

public class UserData {

        private final String login;
        private final String password;
        private final String nick;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNick() {
        return nick;
    }

    public UserData(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }
    }

