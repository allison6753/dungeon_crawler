package main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;

public class LastRoom {
    private Scene scene;
    private Pane root;
    private Label alertLabel;

    private int money;
    private ConfigScreen.Difficulty difficulty;
    private ConfigScreen.Weapon weapon;
    private Monster monster = new Monster();
    private Timeline monsterAttackThread;


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
        updateLabels();
        monsterButton();
        setHealthLabel();

        this.monsterAttackThread = new Timeline(
                new KeyFrame(Duration.seconds(2),
                        new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            GameState currGameState = ConfigScreen.getGameState();
                            currGameState.damagePlayer(10);
                            System.out.println("monster attacks...");
                            System.out.println(currGameState.getPlayerHealth());
                            if (!currGameState.isPlayerAlive()) {
                                DieScreen screen = new DieScreen();
                                Stage currentWindow = (Stage) Stage.getWindows().stream()
                                        .filter(Window::isShowing).findFirst().orElse(null);
                                Main.changeWindowTo(currentWindow, screen.getScene());
                                monsterAttackThread.stop();
                            } else {
                                scene = Stage.getWindows().stream().filter(Window::isShowing)
                                        .findFirst().orElse(null).getScene();
                                updateLabels();
                            }
                        }
                    }));
        monsterAttackThread.setCycleCount(Timeline.INDEFINITE);

        if (this.monster.getIsAlive()) {
            monsterAttackThread.play();
        }

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
    private void updateLabels() {
        money = ConfigScreen.getGameState().getMoney();
        Label moneyLabel = (Label) scene.lookup("#money");
        moneyLabel.setText("Money: $" + money);

        Label roomNumLabel = (Label) scene.lookup("#roomNum");
        roomNumLabel.setText("Room: Final Room");

        int health = ConfigScreen.getGameState().getPlayerHealth();
        Label healthLabel = (Label) scene.lookup("#playerHealth");
        healthLabel.setText("Player Health: " + health);
    }

    private void setHealthLabel() {
        Label monHealthLab = (Label) scene.lookup("#monHealth");
        monHealthLab.setText("Health: " + monster.getHealth());
    }

    public Timeline getMonsterAttackThread() {
        return this.monsterAttackThread;
    }

    //setting up monster
    private void monsterButton() {
        Button monsterButton = (Button) scene.lookup("#examBoss");
        monsterButton.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Final_Boss.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");

        monsterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // when monster is clicked (attacked), health declines by 10
                Label monHealthLab = (Label) scene.lookup("#monHealth");
                monster.attack(10);
                monHealthLab.setText("Health: " + monster.getHealth());
                //monster.updateHealthLabel();
                if (!monster.getIsAlive()) {
                    monsterAttackThread.stop();
                }
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
