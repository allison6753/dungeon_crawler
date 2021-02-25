package main;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;


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

    public static void changeWindowTo(Stage window, Scene newScene) {
        window.setScene(newScene);
        window.show();
    }
}
