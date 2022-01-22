package ru.geekbrains.chat.server;

import ru.geekbrains.chat.server.AuthService;

import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {

    private final List<UserData> users;

    public SimpleAuthService() {
        users = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            users.add(new UserData("login"+i,"pass"+i, "nick" + i));
        }
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        for (UserData user : users) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                return user.getNick();
            }
        }
        return null;
    }

    @Override
    public boolean signUp(String login, String password, String nick) {
        return false;
    }


}
