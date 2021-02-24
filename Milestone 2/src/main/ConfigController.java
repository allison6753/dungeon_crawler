package main;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConfigController {
    public TextField NameField;
    public Button buttonStart;
    public Label alertLabel;

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
