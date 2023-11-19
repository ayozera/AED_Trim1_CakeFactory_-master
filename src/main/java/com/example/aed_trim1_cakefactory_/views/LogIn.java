package com.example.aed_trim1_cakefactory_.views;

import com.example.aed_trim1_cakefactory_.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LogIn {
    private static Stage stageLogIn = new Stage();
    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stageLogIn.setTitle("Cake Factory");
        stageLogIn.setScene(scene);
        stageLogIn.show();
    }

    public static Stage getStageLogIn() {
        return stageLogIn;
    }
}
