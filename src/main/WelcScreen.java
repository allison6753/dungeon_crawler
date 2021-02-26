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

public class WelcScreen {
    private Scene scene;
    private Pane root;

    public WelcScreen(int width, int height) {
        try {
            root = FXMLLoader.load(WelcScreen.class.getResource("../resources/welcPane.fxml"));
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        scene = new Scene(root, width, height);
        addBackgroundImage();

    }

    public Scene getScene() {
        return this.scene;
    }

    private void startupStartButton() {
        Button playButton = (Button) scene.lookup("#buttonPlay");
        playButton.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/startButton.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        playButton.setText("");

        /*playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Label alertLabel = (Label) scene.lookup("#alertLabel");
                Scene initialScene = new Scene(new Pane());
                Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                //Main.changeWindowTo(currentWindow, configScreen);
            }
        });*/

    }

    private void addBackgroundImage() {
        root.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/techMenu.png").toExternalForm()
                + "');\n-fx-background-position: center center; \n-fx-background-repeat: stretch;");
    }

    public Pane getRoot() {
        return root;
    }


}


