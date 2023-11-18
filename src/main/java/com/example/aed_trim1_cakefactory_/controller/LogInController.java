package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.entidades.Usuario;
import com.example.aed_trim1_cakefactory_.modelo.excepciones.CampoVacioException;
import com.example.aed_trim1_cakefactory_.modelo.excepciones.UsuarioNoValidoException;
import com.example.aed_trim1_cakefactory_.views.MenuPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LogInController {

    public TextField textfieldUsuario;
    public TextField textfieldClave;

    public void signIn(ActionEvent actionEvent) throws IOException {
        String nombre = textfieldUsuario.getText();
        String clave = textfieldClave.getText();
        try {
            if (nombre.isBlank() || clave.isBlank()) {
                throw new CampoVacioException();
            }
            Usuario usuario = new Usuario(nombre, clave);
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Clave: " + usuario.getPassword_db());
            System.out.println("Administrador: " + usuario.isAdmin());

            MenuPrincipal.show();

        } catch (UsuarioNoValidoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validación fallida");
            alert.setHeaderText("Usuario o contraseña no válidas");
            alert.setContentText("Asegurese de que el nombre de usuario y su contraseña son correctas");
            alert.show();
        } catch (CampoVacioException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos vacíos");
            alert.setContentText("No se admiten campos vacíos o en blanco");
            alert.show();
        }

    }
}