package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
    private int screenWidth = 800;
    private int screenHeight = 800;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        Scene scene = new Scene(root, screenWidth, screenHeight);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Our Game");
        primaryStage.show();
    }
}
