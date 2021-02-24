package main;

import javafx.application.Application;
import javafx.stage.Stage;


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
