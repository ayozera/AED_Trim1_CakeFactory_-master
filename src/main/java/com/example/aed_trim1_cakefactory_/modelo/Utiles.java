package com.example.aed_trim1_cakefactory_.modelo;

import com.example.aed_trim1_cakefactory_.AppMain;
import com.example.aed_trim1_cakefactory_.views.LogIn;
import javafx.stage.Stage;

import java.io.IOException;

public class Utiles {

    public static void cerrarSesion() throws IOException {
        for (Stage ventana : AppMain.ventanas) {
            ventana.close();
        }
        AppMain.ventanas.clear();
        LogIn.show();
    }
}
