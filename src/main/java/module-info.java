module proyecto16.proyecto16 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens proyecto16.proyecto16 to javafx.fxml;
    exports proyecto16.proyecto16;
}