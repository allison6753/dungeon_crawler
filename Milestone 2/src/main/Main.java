package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    private int screenWidth = 1920;
    private int screenHeight = 1080;

    @Override
    public void start(Stage primaryStage) throws Exception {

        ConfigScreen configScreen = new ConfigScreen(screenWidth, screenHeight);
        primaryStage.setScene(configScreen.getScene());
        primaryStage.setTitle("Our Game");
        primaryStage.show();
    }
}
