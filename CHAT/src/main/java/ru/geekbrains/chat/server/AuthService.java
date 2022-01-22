package ru.geekbrains.chat.server;

public interface AuthService {
    String getNickByLoginAndPassword(String login , String password);

    boolean signUp(String login , String password,String nick);
}
