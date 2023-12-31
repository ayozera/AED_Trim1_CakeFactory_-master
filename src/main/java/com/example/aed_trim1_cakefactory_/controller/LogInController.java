package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.entidades.Usuario;
import com.example.aed_trim1_cakefactory_.modelo.excepciones.CampoVacioException;
import com.example.aed_trim1_cakefactory_.modelo.excepciones.UsuarioNoValidoException;
import com.example.aed_trim1_cakefactory_.views.LogIn;
import com.example.aed_trim1_cakefactory_.views.MenuPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;

import static com.example.aed_trim1_cakefactory_.modelo.ConexionDB.establecerConexionPredeterminada;

public class LogInController {

    public TextField textfieldUsuario;
    public TextField textfieldClave;
    public Button botonSalir;

    public void signIn(ActionEvent actionEvent) throws IOException {
        String nombre = textfieldUsuario.getText();
        String clave = textfieldClave.getText();
        try {
            if (nombre.isBlank() || clave.isBlank()) {
                throw new CampoVacioException();
            }
            Usuario usuario = new Usuario(nombre, clave);

            try {
                if(establecerConexionPredeterminada(usuario.getNombre(), usuario.getPassword_db())) {
                    System.out.println("Exito al establecer conexión con la DB");
                } else {
                    System.out.println("Fallo al conectar con la DB");
                }
            } catch (Exception e) {
            }
            MenuPrincipal.show();
            LogIn.getStageLogIn().close();

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

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}