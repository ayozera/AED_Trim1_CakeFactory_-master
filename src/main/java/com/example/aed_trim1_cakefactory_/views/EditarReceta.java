package com.example.aed_trim1_cakefactory_.views;

import com.example.aed_trim1_cakefactory_.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditarReceta {

    private static Stage stageEditarReceta = new Stage();
    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("EditarReceta.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stageEditarReceta.setTitle("Cake Factory");
        stageEditarReceta.setScene(scene);
        stageEditarReceta.setResizable(false);
        stageEditarReceta.show();
        AppMain.ventanas.add(stageEditarReceta);
    }

    public static Stage getStageEditarReceta() {
        return stageEditarReceta;
    }
}
