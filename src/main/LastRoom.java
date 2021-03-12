package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class LastRoom {
    private Scene scene;
    private Pane root;

    private int money;
    private ConfigScreen.Difficulty difficulty;
    private ConfigScreen.Weapon weapon;

    //constructor for last room
    //ConfigScreen.Difficulty difficulty, ConfigScreen.Weapon weapon, int money
    public LastRoom(ConfigScreen.Difficulty difficulty, ConfigScreen.Weapon weapon, int money) {
        try {
            root = FXMLLoader.load(
                    GameScreen1.class.getResource("../resources/Last_Room.fxml")
            );
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        this.weapon = weapon;
        this.difficulty = difficulty;
        this.money = money;

        scene = new Scene(root, Main.getScreenWidth(), Main.getScreenHeight());
        addBackgroundImage();
        exitRoomButton();
        setMoneyLabel();

    }

    public Scene getScene() {
        return this.scene;
    }

    public Pane getRoot() {
        return root;
    }

    private void addBackgroundImage() {
        root.setStyle("-fx-background-image: url('"
                + Main.class.getResource(
                        "../resources/InitialGameScreenBackground.png").toExternalForm()
                + "');\n-fx-background-position: center center; \n-fx-background-repeat: stretch;");
    }

    //getters for money, weapon, difficulty
    public int getMoney() {
        return money;
    }

    public ConfigScreen.Weapon getWeapon() {
        return weapon;
    }

    public ConfigScreen.Difficulty getDifficulty() {
        return difficulty;
    }

    //setter for money label
    private void setMoneyLabel() {
        Label moneyLabel = (Label) scene.lookup("#money");
        moneyLabel.setText("Room: Final Room" + "Money: $" + money);
    }

    //exit room door to go to congrats screen :)
    private void exitRoomButton() {
        Button exitButton = (Button) scene.lookup("#Door");
        exitButton.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Door.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        exitButton.setText("");

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Change to Config Screen
                WinScreen winScreen = new WinScreen();
                Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Main.changeWindowTo(currentWindow, winScreen.getScene());
            }
        });



    }
}
