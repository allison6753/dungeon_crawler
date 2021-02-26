package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
    private int screenWidth = 1920;
    private int screenHeight = 1080;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WelcScreen welcome = new WelcScreen(screenWidth, screenHeight);
        primaryStage.setScene(welcome.getScene());
        primaryStage.setResizable(true);
        primaryStage.setTitle("Tech Game");
        primaryStage.show();
    }

    public static void changeWindowTo(Stage window, Scene newScene) {
        window.setScene(newScene);
        window.show();
    }
}
