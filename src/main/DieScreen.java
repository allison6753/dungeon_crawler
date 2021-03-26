package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is the loss screen that should be triggered when user's health goes to 0.
 */

public class DieScreen {
    private Scene scene;
    private Pane root;

    public DieScreen() {
        try {
            root = FXMLLoader.load(WelcScreen.class.getResource("../resources/dieScreen.fxml"));
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        scene = new Scene(root, Main.getScreenWidth(), Main.getScreenHeight());
        addBackgroundImage();
        startOverButton();

    }

    public Scene getScene() {
        return this.scene;
    }

    private void addBackgroundImage() {
        root.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/techMenu.png").toExternalForm()
                + "');\n-fx-background-position: center center; \n-fx-background-repeat: stretch;");
    }

    public Pane getRoot() {
        return root;
    }

    //starting over
    private void startOverButton() {
        Button startOverButton = (Button) scene.lookup("#buttonStartOver");
        startOverButton.setText("Start Over");

        startOverButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Change to welcome screen
                WelcScreen welcScreen = new WelcScreen();
                Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Main.changeWindowTo(currentWindow, welcScreen.getScene());
            }
        });
    }
}
