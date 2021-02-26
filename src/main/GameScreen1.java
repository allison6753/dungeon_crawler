package main;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class GameScreen1 {
    private Scene scene;
    private Pane root;

    private int startingMoney;

    public GameScreen1(ConfigScreen.Difficulty difficulty, ConfigScreen.Weapon weapon) {
        try {
            root = FXMLLoader.load(
                    GameScreen1.class.getResource("../resources/InitialGameScreen.fxml")
            );
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        scene = new Scene(root, Main.getScreenWidth(), Main.getScreenHeight());
        addBackgroundImage();
        setStartingMoney(difficulty);
        //setMoneyLabel();



        /** Uncomment when creating buttons for doors **/
        /*
            //change next rooms to actual next rooms once we create them
            setDoor("#door1", new WelcScreen());
            setDoor("#door2", new WelcScreen());
            setDoor("#door3", new WelcScreen());
            setDoor("#door4", new WelcScreen());
        */


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


    /**Uncomment when add moneyLabel to fxml **/
    /*
        private void setMoneyLabel() {
            Label moneyLabel = (Label) scene.lookup("#startingMoney");
            moneyLabel.setText("StartingMoney: $" + startingMoney);
        }
    */


    /** Uncomment when add buttons to door images **/
    /*
        private void setDoor(String id, WelcScreen next) {
            Button nextRoom = (Button) scene.lookup(id);

            nextRoom.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    // Change to next room
                    Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    Main.changeWindowTo(currentWindow, next.getScene());
                }
            });
        }
    */


}

