package com.example.aed_trim1_cakefactory_.modelo;

import com.example.aed_trim1_cakefactory_.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navegacion {
    public static void abrirVentana(String rutaFxml, String titulo) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource(rutaFxml));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cake Factory");
        stage.setScene(scene);
        stage.show();
    }
}
