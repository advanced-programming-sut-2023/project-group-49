module approjet {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires json.simple;
    requires java.desktop;


    exports view;
    opens view to javafx.fxml;
}