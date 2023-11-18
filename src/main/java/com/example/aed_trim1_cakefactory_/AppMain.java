package com.example.aed_trim1_cakefactory_;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.example.aed_trim1_cakefactory_.modelo.entidades.Credencial;
import com.example.aed_trim1_cakefactory_.modelo.DataUp;
import static com.example.aed_trim1_cakefactory_.modelo.Navegacion.abrirVentana;

public class AppMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        abrirVentana("LogIn.fxml", "Cake Factory");
    }

    public static void main(String[] args) throws IOException {
        String ruta = "src/main/files/tartasCreativas.bin";
        File ficheroInicial = new File(ruta);

        if (!ficheroInicial.exists()) {
            Credencial admin = new Credencial("admin", "admin", true);
            ArrayList<Credencial> cargaInicial = new ArrayList<>();
            cargaInicial.add(admin);
            DataUp.guardarBin(ruta, cargaInicial);
        }

        launch();
    }
}