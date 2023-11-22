package com.example.aed_trim1_cakefactory_.views;

import com.example.aed_trim1_cakefactory_.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NuevoPedido {

    private static Stage stageNuevoPedido = new Stage();
    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("NuevoPedido.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stageNuevoPedido.setTitle("Cake Factory");
        stageNuevoPedido.setScene(scene);
        stageNuevoPedido.setResizable(false);
        stageNuevoPedido.show();
        AppMain.ventanas.add(stageNuevoPedido);
    }

    public static Stage getStageNuevoPedido() {
        return stageNuevoPedido;
    }
}
