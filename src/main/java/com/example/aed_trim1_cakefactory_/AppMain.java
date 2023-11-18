package com.example.aed_trim1_cakefactory_;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.excepciones.ConexionFallidaException;
import com.example.aed_trim1_cakefactory_.views.LogIn;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.aed_trim1_cakefactory_.modelo.entidades.Credencial;
import com.example.aed_trim1_cakefactory_.modelo.DataUp;

public class AppMain extends Application {

    private static ConexionDB conexion;

    @Override
    public void start(Stage stage) throws IOException {
        LogIn.show();
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

        try {
            if(establecerConexionPredeterminada()) {
                System.out.println("Exito al establecer conexión con la DB");
            } else {
                System.out.println("Fallo al conectar con la DB");
            }
        } catch (Exception e) {
        }

        launch();
    }

    private static boolean establecerConexionPredeterminada() {
        try {
            conexion = new ConexionDB();
            if (!conexion.comprobarConexion()) {
                throw new ConexionFallidaException("No se ha podido establecer conexión");
            }
            return true;
        } catch (ConexionFallidaException ex) {
            System.out.println("[!] Atención. " + ex.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("[!] Atención. Ha ocurrido un error con la base de datos. Por favor, intentelo de nuevo.");
            return false;
        }
    }
}