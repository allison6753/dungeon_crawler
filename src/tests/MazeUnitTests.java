package tests;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.ConfigScreen;
import main.GameScreen1;
import main.InteriorRoom;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MazeUnitTests extends ApplicationTest {
    private GameScreen1 startScreen;
    private Window window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        startScreen = new GameScreen1(ConfigScreen.Difficulty.IN_STATE, ConfigScreen.Weapon.CALCULATOR);
        primaryStage.setScene(startScreen.getScene());
        primaryStage.show();

        //get the displayed window from javafx
        window = ((List<Window>)Stage.getWindows().stream().filter(Window::isShowing)).get(0);
    }

    @Test
    public void testCorrectImgLoading() {
        Button door1Button = (Button) startScreen.getScene().lookup("#door1");
        clickOn(door1Button);
//        assert(window.getScene() )
    }
}
