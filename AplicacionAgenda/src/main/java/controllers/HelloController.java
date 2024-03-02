package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.*;

import java.util.Optional;

public class HelloController{
    @FXML
    private AnchorPane Principal;

    @FXML
    private Button btn_AgregarContact;

    @FXML
    private Button btn_AgregarPersona;

    @FXML
    private Button btn_EliminaContacto;

    @FXML
    private Button btn_EliminarPersona;

    @FXML
    private Button btn_MostrarContactos;
    @FXML
    private Button btn_MostrarPersonasCategoria;

    private Lista lista = new Lista();
    @FXML
    void agregarContacto(MouseEvent event){
        Contacto nuevoContacto = new Contacto();
        nuevoContacto.setSeudonimo(ventana("Ingresa su seudonimo"));
        nuevoContacto.setNumTel(Integer.parseInt(ventana("Ingresa el numero de telefono")));
        lista.agregarContacto(nuevoContacto);
    }
    private String ventana(String contentText){
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Contactos");
        inputDialog.setHeaderText("Ingrese los datos del contacto");
        inputDialog.setContentText(contentText);

        Optional<String> result = inputDialog.showAndWait();
        return result.orElse("");
    }
    @FXML
    void agregarPersona(MouseEvent event){
        Optional <Persona> nuevaPersona = PersonaDialog.mostrarAgregarPersona();
        nuevaPersona.ifPresent(lista::agregarPersona);
    }
    @FXML
    void eliminarContacto(MouseEvent event){
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Eliminar Contacto");
        inputDialog.setHeaderText("Eliminar Contacto");
        inputDialog.setContentText("Ingresa el contacto a eliminar:");Optional<String> result = inputDialog.showAndWait();

        result.ifPresent(contacto -> {
            boolean eliminado = lista.eliminarContacto(contacto);
            Alert alert;
            if (eliminado) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Eliminar Contacto");
                alert.setHeaderText(null);
                alert.setContentText("El contacto se elimino con Exito");
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("No se encontró el Contacto deseado.");
            }
            alert.showAndWait();
        });
    }
    @FXML
    void eliminarPersona(MouseEvent event) {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Eliminar Elemento");
        inputDialog.setHeaderText("Eliminar Elemento");
        inputDialog.setContentText("Por favor, ingresa el nombre del elemento a eliminar:");

        Optional<String> result = inputDialog.showAndWait();

        result.ifPresent(nombreElemento -> {
            boolean eliminado = lista.eliminarPersona(nombreElemento);
            Alert alert;
            if (eliminado) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Eliminar Persona");
                alert.setHeaderText(null);
                alert.setContentText("La persona se elimino correctamente.");
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No se encontró la persona.");
            }
            alert.showAndWait();
        });
    }
    @FXML
    void mostrarContactos(MouseEvent event) {
        String allContactos = lista.mostrarContactos();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Contactos");
        alert.setHeaderText("Información del contacto");
        alert.setContentText(allContactos);
        alert.getDialogPane().setPrefSize(480, 320);
        alert.showAndWait();
    }
    @FXML
    void mostrarPersonas (MouseEvent event){
        String personasPorCategoria = lista.mostrarPersonasPorTipo();
        System.out.println("Personas por Categoría: " + personasPorCategoria);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Personas por Categoría");
        alert.setHeaderText(null);
        alert.setContentText(personasPorCategoria);
        alert.showAndWait();
    }
}