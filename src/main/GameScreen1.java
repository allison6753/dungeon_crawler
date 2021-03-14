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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameScreen1 {
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



    public GameScreen1(ConfigScreen.Difficulty difficulty, ConfigScreen.Weapon weapon, boolean setUp) {
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


        setDoor("#door1", 1);
        setDoor("#door2", 2);
        setDoor("#door3", 3);
        setDoor("#door4", 4);
    }

    private void doSetUp() {
        backgroundImgs = new String[]{
                "Blue_Room.png",
                "Pink_Room.png",
                "Green_Room.png",
                "Yellow_Room.png",
                "Side_Room.png",
                "Side_Room.png"
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
        InteriorRoom next = new InteriorRoom(0, difficulty, weapon, startingMoney, pathNum);
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