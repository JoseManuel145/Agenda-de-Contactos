module manuel.cruz.aplicacionagenda {
    requires javafx.controls;
    requires javafx.fxml;


    opens manuel.cruz.aplicacionagenda to javafx.fxml;
    exports manuel.cruz.aplicacionagenda;
    exports controllers;
    opens controllers to javafx.fxml;
    exports models;
    opens models to javafx.fxml;
}