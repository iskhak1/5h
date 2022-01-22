package ru.geekbrains.chat.server;

import ru.geekbrains.chat.server.ChatServer;

import java.io.IOException;

public class ServerRunner {
    public static void main(String[] args) throws IOException {
        new ChatServer().run();
    }
}
