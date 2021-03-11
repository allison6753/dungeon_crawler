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
    private int roomIndex; // 0-5 sequentially in mazOrder
    private int roomNum; // 0-5 randomly to create a "random maze"
    private int order;
    private ConfigScreen.Weapon weapon;
    private ConfigScreen.Difficulty difficulty;

    public InteriorRoom(int roomIndex, ConfigScreen.Difficulty difficulty,
                        ConfigScreen.Weapon weapon, int money, int order) {
        try {
            root = FXMLLoader.load(
                    GameScreen1.class.getResource("../resources/mazeRoom.fxml")
            );
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        this.weapon = weapon;
        this.difficulty = difficulty;
        this.money = money;
        this.roomIndex = roomIndex;
        this.order = order;
        checkOrder(order);

        scene = new Scene(root, Main.getScreenWidth(), Main.getScreenHeight());
        addBackgroundImage("../resources/" + Main.getBackgroundImgs()[roomNum]);
        setMoneyLabel();

        setupDoors();

    }

    private void checkOrder(int order) {
        if (order == 1) {
            this.roomNum = Main.getMazeOrder1().get(this.roomIndex);
        } else if (order == 2) {
            this.roomNum = Main.getMazeOrder2().get(this.roomIndex);
        } else if (order == 3) {
            this.roomNum = Main.getMazeOrder3().get(this.roomIndex);
        } else {
            this.roomNum = Main.getMazeOrder4().get(this.roomIndex);
        }
    }

    public Scene getScene() {
        return this.scene;
    }

    public Pane getRoot() {
        return root;
    }

    private void addBackgroundImage(String background) {
        root.setStyle("-fx-background-image: url('"
                + Main.class.getResource(background)
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
        Label moneyLabel = (Label) scene.lookup("#money");
        moneyLabel.setText("Room:" + roomNum + "Money: $" + money);
    }


    private void setupDoors() {
        //make the next door
        Button prevDoor = (Button) scene.lookup("#prevRoomDoor");
        prevDoor.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Door.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        prevDoor.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (roomIndex == 0) {
                    Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    GameScreen1 screen1 = new GameScreen1(difficulty, weapon);

                    Main.changeWindowTo(currentWindow, screen1.getScene());
                }
                if (roomIndex > 0) {
                    Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    InteriorRoom nextRoom = new InteriorRoom(roomIndex - 1, difficulty,
                            weapon, money, order);
                    Main.changeWindowTo(currentWindow, nextRoom.getScene());
                }
            }
        });

        //make the next door
        Button nextDoor = (Button) scene.lookup("#nextRoomDoor");
        nextDoor.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Door.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        nextDoor.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (roomIndex < 5) {
                    Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    InteriorRoom nextRoom = new InteriorRoom(roomIndex + 1, difficulty,
                            weapon, money, order);
                    Main.changeWindowTo(currentWindow, nextRoom.getScene());
                }
            }
        });
    }


}