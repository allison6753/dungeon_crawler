package main;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.io.IOException;

/**
 * This is the win screen that should be triggered when user clicks on exit door in last room.
 * We will most likely need to add a functionality to play again.
 */

public class WinScreen {
    private Scene scene;
    private Pane root;

    public WinScreen() {
        try {
            root = FXMLLoader.load(WelcScreen.class.getResource("../resources/winScreen.fxml"));
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        scene = new Scene(root, Main.getScreenWidth(), Main.getScreenHeight());
        addBackgroundImage();

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
}
