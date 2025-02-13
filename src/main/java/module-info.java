module com.javolife.javolife {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javolife.application to javafx.fxml;
    exports com.javolife.application;
    exports com.javolife.game;
    opens com.javolife.game to javafx.fxml;
}