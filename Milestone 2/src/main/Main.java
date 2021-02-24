package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    private int screenWidth = 1920;
    private int screenHeight = 1080;
    private static List<Pane> panes = new ArrayList<Pane>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = FXMLLoader.load(getClass().getResource("configPane.fxml"));
        //add background image using css
        root.setStyle("-fx-background-image: url('" + Main.class.getResource("techMenu.png").toExternalForm() + "');" +
                " \n-fx-background-position: center center; \n-fx-background-repeat: stretch;");

        Scene scene = new Scene(root, screenWidth, screenHeight);

        Button startButton = (Button) scene.lookup("#buttonStart");
        startButton.setStyle("-fx-background-image: url('" + Main.class.getResource("startButton.png").toExternalForm() + "');" +
                " \n-fx-background-position: center center; \n-fx-background-repeat: stretch; \n-fx-background-size: stretch;\n" +
                "\n-fx-border-width: 0;\n -fx-background-radius: 0;\n-fx-background-color: transparent;");
        startButton.setText(""); //Image already has the text on it so remove it

        primaryStage.setScene(scene);
        primaryStage.setTitle("Our Game");
        primaryStage.show();
    }
}
