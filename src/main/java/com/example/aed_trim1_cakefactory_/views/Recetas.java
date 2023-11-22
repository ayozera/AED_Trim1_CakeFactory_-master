package com.example.aed_trim1_cakefactory_.views;

import com.example.aed_trim1_cakefactory_.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Recetas {
    private static Stage stageRecetas = new Stage();
    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("Recetas.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stageRecetas.setTitle("Cake Factory");
        stageRecetas.setScene(scene);
        stageRecetas.setResizable(false);
        stageRecetas.show();
        AppMain.ventanas.add(stageRecetas);
    }

    public static Stage getStageRecetas() {
        return stageRecetas;
    }
}
