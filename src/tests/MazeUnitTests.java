package tests;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.ConfigScreen;
import main.GameScreen1;
import main.InteriorRoom;
import main.LastRoom;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MazeUnitTests extends ApplicationTest {
    private GameScreen1 startScreen;
    private Window window;
    private InteriorRoom room;
    private LastRoom lastRoom;

    @Override
    public void start(Stage primaryStage) throws Exception {
        startScreen = new GameScreen1(ConfigScreen.Difficulty.IN_STATE, ConfigScreen.Weapon.CALCULATOR, true);
        primaryStage.setScene(startScreen.getScene());
        primaryStage.show();

        //get the displayed window from javafx
        //window = ((List<Window>)Stage.getWindows().stream().filter(Window::isShowing)).get(0);
    }

    @Test
    public void testCorrectImgLoading() {
        Button door1Button = (Button) startScreen.getScene().lookup("#door1");
        clickOn(door1Button);
//        assert(window.getScene() )
    }

    @Test
    public void testMazeBackground() {
        Button door1Button = (Button) startScreen.getScene().lookup("#door1");
        clickOn(door1Button);
        assert(room.getBackgroundImage() == "../resources/" + GameScreen1.getBackgroundImgs()[room.getRoomNum()]);
    }

    /** Tests that the path backward equals the reverse of the path going forward **/
    /** Alison's Test **/
    @Test
    public void pathBackward() {
        String[] forwardScenes = new String[8];
        forwardScenes[0] = ((Label) startScreen.getScene().lookup("#startingMoney")).getText();

        Button button = (Button) startScreen.getScene().lookup("#door1");
        clickOn(button);
        Window nextRoom = Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
        System.out.println(((Label) (nextRoom.getScene().lookup("#roomNum"))));
        forwardScenes[1] = ((Label) nextRoom.getScene().lookup("#roomNum")).getText();

        //going forward
        for (int i = 2; i <= 6; i++) {
            button = (Button) nextRoom.getScene().lookup("#nextDoorLeft");
            clickOn(button);
            nextRoom = Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
            forwardScenes[i] = ((Label) nextRoom.getScene().lookup("#roomNum")).getText();
        }

        //going backward
        for (int i = 6; i > 0; i--) {
            button = (Button) nextRoom.getScene().lookup("#prevDoorLeft");
            clickOn(button);
            nextRoom = Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
            assertEquals(forwardScenes[i], ((Label) nextRoom.getScene().lookup("#roomNum")).getText());
        }

        button = (Button) nextRoom.getScene().lookup("#prevDoorLeft");
        clickOn(button);
        nextRoom = Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
        assertEquals(forwardScenes[0], ((Label) nextRoom.getScene().lookup("#startingMoney")).getText());

    }

    /** Tests that prevDoor leads you to room you wee previously in **/
    //Doesn't work yet
    /** Alison's Test **/
    @Test
    public void testForwardAndBackward() {
        Button door1Button = (Button) startScreen.getScene().lookup("#door1");
        clickOn(door1Button);
        while (lastRoom == null) {
            Button nextDoorLeft = (Button) room.getScene().lookup("#nextDoorLeft");
            Button prevDoorLeft = (Button) room.getScene().lookup("#prevDoorLeft");
            //pastPrev = current room now
            clickOn(nextDoorLeft);
            clickOn(prevDoorLeft);
            //currPrev == current room now
            // assert(pastPrev.equals(currPrev));
        }


    }

}