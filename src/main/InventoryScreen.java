package main;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class InventoryScreen {

    private Scene scene;
    private DungeonRoomParent prevRoom;
    private Pane root;
    public InventoryScreen(DungeonRoomParent prevRoom) {
        try {
            root = FXMLLoader.load(ConfigScreen.class.getResource("../resources/Inventory.fxml"));
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        scene = new Scene(root, Main.getScreenWidth(), Main.getScreenHeight());
        this.prevRoom = prevRoom;
        addBackgroundImg();

        // when you press i exit the inventory screen
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.I) {
                    // i key was pressed
                    Stage currentWindow = (Stage) Stage.getWindows().stream()
                            .filter(Window::isShowing).findFirst().orElse(null);
                    Main.changeWindowTo(currentWindow, prevRoom.getScene());
                    prevRoom.update();
                }
            }
        });
    }

    private void addBackgroundImg() {
        //add background image using css
        root.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Inventory_Screen.png").toExternalForm()
                + "');\n-fx-background-position: center center; \n-fx-background-repeat: stretch;");
    }



    private void exitInventory() {
        System.out.println("exit");

    }

    public Scene getScene() {
        return this.scene;
    }
}
