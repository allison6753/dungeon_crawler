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
    private Label alertLabel;

    private int money;
    private ConfigScreen.Difficulty difficulty;
    private ConfigScreen.Weapon weapon;
    Monster monster = new Monster();

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
        monsterButton();
        setHealthLabel();

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
        moneyLabel.setText("Room: Final Room " + "Money: $" + money);
    }

    private void setHealthLabel() {
        Label monHealthLab = (Label) scene.lookup("#monHealth");
        monHealthLab.setText("Health: " + monster.getHealth());
    }

    //setting up monster
    private void monsterButton() {
        Button monsterButton = (Button) scene.lookup("#examBoss");
        monsterButton.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Exam_Boss.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        monsterButton.setText("");

        monsterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // when monster is clicked (attacked), health declines by 10
                Label monHealthLab = (Label) scene.lookup("#monHealth");
                monster.attack(10);
                monHealthLab.setText("Health: " + monster.getHealth());
                //monster.updateHealthLabel();
            }
        });



    }

    //exit room door to go to congrats screen :)
    private void exitRoomButton() {
        Button exitButton = (Button) scene.lookup("#Door");
        exitButton.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Door.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        exitButton.setText("");

        this.alertLabel = (Label) scene.lookup("#alertLabel");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (monster.getHealth() == 0) {
                    // Change to Config Screen
                    WinScreen winScreen = new WinScreen();
                    Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    Main.changeWindowTo(currentWindow, winScreen.getScene());
                } else {
                    alertLabel.setVisible(true);
                }

            }
        });



    }
}
