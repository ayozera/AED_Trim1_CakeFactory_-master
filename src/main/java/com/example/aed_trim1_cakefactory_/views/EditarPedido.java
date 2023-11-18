package com.example.aed_trim1_cakefactory_.views;

import com.example.aed_trim1_cakefactory_.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditarPedido {

    private static Stage stageEditarPedido = new Stage();
    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("EditarPedido.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stageEditarPedido.setTitle("Cake Factory");
        stageEditarPedido.setScene(scene);
        stageEditarPedido.show();
    }
}
