package ru.geekbrains.chat.server;

import java.sql.*;
import java.nio.*;

public class DBAuthService implements AuthService {

    private final Connection connection;

    public DBAuthService() {
        connection = connect();
    }

    private Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:ServerChat.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        try (final PreparedStatement ps = connection.prepareStatement("select nick " +
                "from client where login =? and password =?")) {
            ps.setString(1, login);
            ps.setString(2, password);
            final ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean signUp(String login, String password, String nick) {

        if (isUserExist(login, nick)) {
            return false;
        }
        try (final PreparedStatement ps = connection.prepareStatement("insert into" +
                "client(login, password,nick) values(?,?,?)")) {
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, nick);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isUserExist(String login, String nick) {

        try(final PreparedStatement ps = connection.prepareStatement("select" +
                "count(*) from client where login = ? or nick = ?")){
            ps.setString(1,login);
            ps.setString(2,nick);
            final ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return resultSet.getLong(1)>0;
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return false;
    }

}
