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

public class Last_Room {
    private Scene scene;
    private Pane root;

    private int money;
    private ConfigScreen.Difficulty difficulty;
    private ConfigScreen.Weapon weapon;

    //constructor for last room
    public Last_Room(ConfigScreen.Difficulty difficulty, ConfigScreen.Weapon weapon, int money, int order) {
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
                + Main.class.getResource("../resources/InitialGameScreenBackground.png").toExternalForm()
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

    //congrats screen thing

}
