package main;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class gameScreen1  {
    private Scene scene;
    private Pane root;

    public gameScreen1(int width, int height) {
        try {
            root = FXMLLoader.load(gameScreen1.class.getResource("../resources/InitialGameScreen.fxml"));
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        scene = new Scene(root, width, height);
        addBackgroundImage();
    }

    public gameScreen1() {}

    public Scene getScene() {
        return this.scene;
    }

    public Pane getRoot() {
        return root;
    }

    private void addBackgroundImage() {
        root.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/InitialGameScreenBackground.png").toExternalForm()
                + "');\n-fx-background-position: center center; \n-fx-background-repeat: stretch;");
    }


}

