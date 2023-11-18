package com.example.aed_trim1_cakefactory_.views;


import com.example.aed_trim1_cakefactory_.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipal {

    private static Stage stageMenuPrincipal = new Stage();
    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("MenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stageMenuPrincipal.setTitle("Cake Factory");
        stageMenuPrincipal.setScene(scene);
        stageMenuPrincipal.show();
    }
}
