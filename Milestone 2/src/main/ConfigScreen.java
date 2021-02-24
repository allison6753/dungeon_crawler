package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ConfigScreen {
    private Scene scene;
    private Pane root;

    public TextField NameField;
    public Button buttonStart;
    public Label alertLabel;
    public ConfigScreen(int width, int height) {
        try {
            root = FXMLLoader.load(getClass().getResource("../resources/configPane.fxml"));
        } catch (IOException except) {

        }

        scene = new Scene(root, width, height);
        styleButton();
        addBackgroundImg();
    }

    public ConfigScreen() {} //default constructor so fxml can load an instance of this class as a controller

    public Scene getScene() {
        return this.scene;
    }

    private void styleButton() {
        Button startButton = (Button) scene.lookup("#buttonStart");
        startButton.setStyle("-fx-background-image: url('" + Main.class.getResource("../resources/startButton.png").toExternalForm() + "');" +
                " \n-fx-background-position: center center; \n-fx-background-repeat: stretch; \n-fx-background-size: stretch;\n" +
                "\n-fx-border-width: 0;\n -fx-background-radius: 0;\n-fx-background-color: transparent;");
        startButton.setText(""); //Image already has the text on it so remove it
    }

    private void addBackgroundImg() {
        //add background image using css
        root.setStyle("-fx-background-image: url('" + Main.class.getResource("../resources/techMenu.png").toExternalForm() + "');" +
                " \n-fx-background-position: center center; \n-fx-background-repeat: stretch;\n-fx-background-size: stretch;");
    }

    // Check if name is null, empty, or whitespaces only
    public boolean validation () {
        if (NameField == null || NameField.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    // Move on to next screen
    public void toNextScreen(ActionEvent actionEvent) {
        if (validation()) {
            // Change to Initial Game Screen
            /* Still need <initialGame> to change scene
            Pane initialGame = FXMLLoader.load(getClass().getResource("<initialGame>.fxml"));
            Scene initialScene = new Scene(initialGame);

            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            window.setScene(initialScene);
            window.show();
             */
        } else {
            // Prompt the user to enter correct name
            alertLabel.setVisible(true);
        }
    }
}
