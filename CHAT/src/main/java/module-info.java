module ru.geekbrains.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ru.geekbrains.chat to javafx.fxml;

    exports ru.geekbrains.chat.server;
    opens ru.geekbrains.chat.server to javafx.fxml;
  //  exports ru.geekbrains.chat.client;
    opens ru.geekbrains.chat.client to javafx.fxml;
    exports ru.geekbrains.chat.client;

}