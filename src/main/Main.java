package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
    private static int screenWidth = 1920;
    private static int screenHeight = 1080;

    private static String[] rooms;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        rooms = new String[]{
                "InitialGameScreenBackground.png",
                "InitialGameScreenBackground.png",
                "InitialGameScreenBackground.png",
                "InitialGameScreenBackground.png",
                "InitialGameScreenBackground.png",
                "InitialGameScreenBackground.png"
        };

        WelcScreen welcome = new WelcScreen();
        primaryStage.setScene(welcome.getScene());
        primaryStage.setResizable(true);
        primaryStage.setTitle("Tech Game");
        primaryStage.show();
    }

    public static void changeWindowTo(Stage window, Scene newScene) {
        window.setScene(newScene);
        window.show();
    }

    public static String[] getRoomsArray() {
        return rooms;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

}
