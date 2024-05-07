module pl.gornik.projektjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.gornik.projektjavafx to javafx.fxml;
    exports pl.gornik.projektjavafx;
}