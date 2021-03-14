package tests;

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
import java.util.ArrayList;

public class MazeUnitTests extends ApplicationTest {
    private GameScreen1 startScreen;
    private Window window;
    private InteriorRoom room;
    private LastRoom lastRoom;

    @Override
    public void start(Stage primaryStage) throws Exception {
        startScreen = new GameScreen1(ConfigScreen.Difficulty.IN_STATE,
                ConfigScreen.Weapon.CALCULATOR, true);
        primaryStage.setScene(startScreen.getScene());
        primaryStage.show();

        //get the displayed window from javafx
        //window = ((List<Window>)Stage.getWindows().stream().filter(Window::isShowing)).get(0);
    }

    @Test
    public void testCorrectImgLoading() {
        Button door1Button = (Button) startScreen.getScene().lookup("#door1");
        clickOn(door1Button);
        //assert(window.getScene() )
    }

    @Test
    public void testMazeBackground() {
        Button door1Button = (Button) startScreen.getScene().lookup("#door1");
        clickOn(door1Button);
        assert (room.getBackgroundImage() == "../resources/"
                + GameScreen1.getBackgroundImgs()[room.getRoomNum()]);
    }

    /** Tests that there are at least 8 rooms in total **/
    //Doesn't work yet
    /** Alison's Test **/
    @Test
    public void test8RoomsTotal() {
        Button door1Button = (Button) startScreen.getScene().lookup("#door1");
        clickOn(door1Button);
        int countRooms = 0;
        countRooms++; //for gameScreen1
        while (lastRoom == null) {
            Button nextDoorLeft = (Button) room.getScene().lookup("#nextDoorLeft");
            clickOn(nextDoorLeft);
            countRooms++; //for each interior room
        }
        countRooms++; //for last room
        assert (countRooms >= 8);
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

    /**
     * Tests that the win screen is 6 doors away
     *
     * Nathan Malta wrote this test
     */
    @Test
    public void test6Clicks() throws InterruptedException {
        Button door1Button = (Button) startScreen.getScene().lookup("#door3");
        clickOn(door1Button);

        for (int i = 0; i < 6; ++i) {
            Window newRoom = Stage.getWindows().stream().filter(Window::isShowing)
                    .findFirst().orElse(null);
            Button nextDoorLeft = (Button) newRoom.getScene().lookup("#nextDoorLeft");

            //make sure we see the objects that should be in a maze room
            assert (newRoom.getScene().lookup("#nextDoorLeft") != null);
            assert (newRoom.getScene().lookup("#prevDoorLeft") != null);

            //go to the next room
            clickOn(nextDoorLeft);
        }

        //make sure we're in the last room
        Window lastRoom = Stage.getWindows().stream().filter(Window::isShowing)
                .findFirst().orElse(null);
        assert (lastRoom.getScene().lookup("#lastRoom") != null);
    }

    /**
     * Tests that the same maze room doesn't show up twice
     *
     * Nathan Malta wrote this test
     */
    @Test
    public void test6RoomsUnique() throws InterruptedException {
        Button door1Button = (Button) startScreen.getScene().lookup("#door3");
        clickOn(door1Button);
        ArrayList<String> roomNums = new ArrayList<>();

        for (int i = 0; i < 6; ++i) {
            Window newRoom = Stage.getWindows().stream().filter(Window::isShowing)
                    .findFirst().orElse(null);

            //make sure we see the objects that should be in a maze room
            assert (newRoom.getScene().lookup("#nextDoorLeft") != null);
            assert (newRoom.getScene().lookup("#prevDoorLeft") != null);
            assert (newRoom.getScene().lookup("#roomNum") != null);

            Button nextDoorLeft = (Button) newRoom.getScene().lookup("#nextDoorLeft");
            Label roomNumLabel = (Label) newRoom.getScene().lookup("#roomNum");

            assert (!roomNums.contains(roomNumLabel.getText()));
            roomNums.add(roomNumLabel.getText());

            //go to the next room
            clickOn(nextDoorLeft);
        }

        //make sure we're in the last room
        Window lastRoom = Stage.getWindows().stream().filter(Window::isShowing)
                .findFirst().orElse(null);
        assert (lastRoom.getScene().lookup("#lastRoom") != null);
    }

}

