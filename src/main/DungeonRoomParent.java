package main;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

abstract class DungeonRoomParent {
    protected Timeline monsterAttackThread;
    DungeonRoomParent() {

    }

    /**
     * Called when the window is entered after being exited
     */
    abstract void update();

    /**
     * Returns the scene associated with the given dungeon room
     */
    abstract Scene getScene();


}
