package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameScreen1 extends DungeonRoomParent {
    private Scene scene;
    private Pane root;

    private int startingMoney;
    private ConfigScreen.Weapon weapon;
    private ConfigScreen.Difficulty difficulty;

    private static String[] backgroundImgs;
    private static List<Integer> mazeOrder1;
    private static List<Integer> mazeOrder2;
    private static List<Integer> mazeOrder3;
    private static List<Integer> mazeOrder4;

    private GameState currGameState;

    public GameScreen1(
            ConfigScreen.Difficulty difficulty, ConfigScreen.Weapon weapon, boolean setUp) {
        if (setUp) {
            doSetUp();
        }

        try {
            root = FXMLLoader.load(
                    GameScreen1.class.getResource("../resources/InitialGameScreen.fxml")
            );
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        this.weapon = weapon;
        this.difficulty = difficulty;

        scene = new Scene(root, Main.getScreenWidth(), Main.getScreenHeight());
        addBackgroundImage();
        setStartingMoney(difficulty);
        setMoneyLabel();


        setDoor("#door1", 0);
        setDoor("#door2", 1);
        setDoor("#door3", 2);
        setDoor("#door4", 3);

        DungeonRoomParent thisRoom = this;
        // when you press i enter the inventory screen
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.I) {
                    // i key was pressed
                    InventoryScreen inv = new InventoryScreen(thisRoom);
                    Stage currentWindow = (Stage) Stage.getWindows().stream()
                            .filter(Window::isShowing).findFirst().orElse(null);
                    Main.changeWindowTo(currentWindow, inv.getScene());
                }
            }
        });
    }

    private void doSetUp() {
        backgroundImgs = new String[]{
            "Blue_Room.png",
            "Pink_Room.png",
            "Green_Room.png",
            "Yellow_Room.png",
            "Orange_Room.png",
            "Purple_Room.png"
        };

        mazeOrder1 = new ArrayList<>();
        mazeOrder2 = new ArrayList<>();
        mazeOrder3 = new ArrayList<>();
        mazeOrder4 = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            mazeOrder1.add(i);
            mazeOrder2.add(i);
            mazeOrder3.add(i);
            mazeOrder4.add(i);
        }

        Collections.shuffle(mazeOrder1);
        Collections.shuffle(mazeOrder2);
        Collections.shuffle(mazeOrder3);
        Collections.shuffle(mazeOrder4);
    }

    @Override
    void update() {
        //no update needed for this class
    }

    public Scene getScene() {
        return this.scene;
    }

    public Pane getRoot() {
        return root;
    }

    private void addBackgroundImage() {
        root.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/InitialGameScreenBackground.png")
                .toExternalForm()
                + "');\n-fx-background-position: center center; \n-fx-background-repeat: stretch;");
    }

    private void setStartingMoney(ConfigScreen.Difficulty difficulty) {
        switch (difficulty) {
        case IN_STATE:
            startingMoney = 500;
            break;
        case OUT_OF_STATE:
            startingMoney = 300;
            break;
        case INTERNATIONAL:
            startingMoney = 100;
            break;
        default:
            break;
        }
    }

    public int getStartingMoney() {
        return startingMoney;
    }

    public ConfigScreen.Weapon getWeapon() {
        return weapon;
    }

    public ConfigScreen.Difficulty getDifficulty() {
        return difficulty;
    }


    private void setMoneyLabel() {
        Label moneyLabel = (Label) scene.lookup("#startingMoney");
        moneyLabel.setText("StartingMoney: $" + startingMoney);
    }


    private void setDoor(String id, int pathNum) {

        Button doorButton = (Button) scene.lookup(id);
        doorButton.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Door.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        doorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                // New change
                GameState currGameState = ConfigScreen.getGameState();
                InteriorRoom next;
                if (currGameState.getInteriorRoom(pathNum, 0) == null) {
                    next = new InteriorRoom(0, difficulty,
                            weapon, startingMoney, pathNum);
                    next.update();
                    currGameState.setRoomOrder(pathNum);
                    currGameState.setRoomIndex(0);
                    currGameState.setInteriorRoom(pathNum, 0, next);
                } else {
                    next = currGameState.getInteriorRoom(pathNum, 0);
                    next.update();
                }
                Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Main.changeWindowTo(currentWindow, next.getScene());
            }
        });
    }

    public static String[] getBackgroundImgs() {
        return backgroundImgs;
    }
    public static List<Integer> getMazeOrder1() {
        return mazeOrder1;
    }
    public static List<Integer> getMazeOrder2() {
        return mazeOrder2;
    }
    public static List<Integer> getMazeOrder3() {
        return mazeOrder3;
    }
    public static List<Integer> getMazeOrder4() {
        return mazeOrder4;
    }
}