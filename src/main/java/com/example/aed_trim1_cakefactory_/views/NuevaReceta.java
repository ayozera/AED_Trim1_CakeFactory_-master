package com.example.aed_trim1_cakefactory_.views;

import com.example.aed_trim1_cakefactory_.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NuevaReceta {

    private static Stage stageNuevaReceta = new Stage();
    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("NuevaReceta.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stageNuevaReceta.setTitle("Cake Factory");
        stageNuevaReceta.setScene(scene);
        stageNuevaReceta.show();
    }
}
