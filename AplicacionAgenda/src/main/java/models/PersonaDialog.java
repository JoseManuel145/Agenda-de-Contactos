package models;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.Optional;

public class PersonaDialog {
    public static Optional<Persona> mostrarAgregarPersona() {

        Dialog<Persona> dialog = new Dialog<>();
        dialog.setTitle("Agregar Persona");
        dialog.setHeaderText("Ingrese los datos de la persona");

        ButtonType agregarButtonType =new ButtonType("Agregar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(agregarButtonType, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10,10));

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre");

        TextField apellido = new TextField();
        apellido.setPromptText("Apellido");

        ComboBox<String> tipoPersona = new ComboBox<>();
        tipoPersona.getItems().addAll("Familiar", "Amigo");
        tipoPersona.setPromptText("Relacion");

        gridPane.add(new Label("Nombre: "), 0, 0);
        gridPane.add(nombre, 1, 0);

        gridPane.add(new Label("Apellido: "), 0, 1);
        gridPane.add(apellido, 1, 1);

        gridPane.add(new Label("Relacion: "), 0, 2);
        gridPane.add(tipoPersona, 1, 2);

        dialog.getDialogPane().setContent(gridPane);

        Platform.runLater(nombre::requestFocus);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == agregarButtonType) {
                if (tipoPersona.getValue() != null) {
                    Persona nuevaPersona = null;

                    if (tipoPersona.getValue().equalsIgnoreCase("Familiar")) {
                        nuevaPersona = new Familiar();
                    } else if (tipoPersona.getValue().equalsIgnoreCase("Amigo")) {
                        nuevaPersona = new Amigo();
                    }
                    if (nuevaPersona != null) {
                        nuevaPersona.setNombre(nombre.getText());
                        nuevaPersona.setApellido(apellido.getText());
                        return nuevaPersona;
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Por favor, seleccione un tipo de persona.");
                    alert.showAndWait();
                }
            }
            return null;
        });
        Optional <Persona> resultado = dialog.showAndWait();

        resultado.ifPresent(persona -> System.out.println("Nombre: " + persona.getNombre() + ", Apellido: " + persona.getApellido() + "."));
        return resultado;
    }
}