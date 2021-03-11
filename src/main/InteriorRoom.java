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

public class InteriorRoom {
    private Scene scene;
    private Pane root;

    private int money;
    private ConfigScreen.Weapon weapon;
    private ConfigScreen.Difficulty difficulty;

    public InteriorRoom(String background, ConfigScreen.Difficulty difficulty, ConfigScreen.Weapon weapon, int money) {
        try {
            root = FXMLLoader.load(
                    GameScreen1.class.getResource("../resources/interiorRoom.fxml")
            );
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        this.weapon = weapon;
        this.difficulty = difficulty;
        this.money = money;

        scene = new Scene(root, Main.getScreenWidth(), Main.getScreenHeight());
        addBackgroundImage(background);
        setMoneyLabel();


        //change next rooms to actual next rooms once we create them
        setDoor("#door", new InteriorRoom(background, difficulty, weapon, money));


    }

    public Scene getScene() {
        return this.scene;
    }

    public Pane getRoot() {
        return root;
    }

    private void addBackgroundImage(String background) {
        root.setStyle("-fx-background-image: url('"
                + Main.class.getResource("background")
                .toExternalForm()
                + "');\n-fx-background-position: center center; \n-fx-background-repeat: stretch;");
    }

    public int getMoney() {
        return money;
    }

    public ConfigScreen.Weapon getWeapon() {
        return weapon;
    }

    public ConfigScreen.Difficulty getDifficulty() {
        return difficulty;
    }


    private void setMoneyLabel() {
        Label moneyLabel = (Label) scene.lookup("#startingMoney");
        moneyLabel.setText("StartingMoney: $" + money);
    }


    /** Uncomment when add buttons to door images **/
    private void setDoor(String id, InteriorRoom next) {
        Button doorButton = (Button) scene.lookup(id);
        doorButton.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Door.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        doorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Main.changeWindowTo(currentWindow, next.getScene());
            }
        });
    }


}
