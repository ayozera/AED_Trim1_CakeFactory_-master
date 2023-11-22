package com.example.aed_trim1_cakefactory_.views;

import com.example.aed_trim1_cakefactory_.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Pedidos {

    private static Stage stagePedidos = new Stage();
    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("Pedidos.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stagePedidos.setTitle("Cake Factory");
        stagePedidos.setScene(scene);
        stagePedidos.setResizable(false);
        stagePedidos.show();
        AppMain.ventanas.add(stagePedidos);

    }

    public static Stage getStagePedidos() {
        return stagePedidos;
    }
}
