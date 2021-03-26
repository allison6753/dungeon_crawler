package tests;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.ConfigScreen;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import org.testfx.framework.junit.ApplicationTest;

public class AllisonTests extends ApplicationTest {
    private ConfigScreen config;

    @Override
    public void start(Stage primaryStage) throws Exception {
        config = new ConfigScreen();
        primaryStage.setScene(config.getScene());
        primaryStage.show();
    }

    @Before
    public void setUp() {
        config.getNameField().setText("name");
        clickOn("#diffIS");
        clickOn("#weapPencil");
        clickOn("#buttonStart");
        clickOn("#door1");
    }

    //Test that the player should not be able to use any doors to
    // rooms that they have not yet visited if they have not defeated the monster
    @Test
    public void testAdvance() {
        Window currRoom = Stage.getWindows().stream().filter(Window::isShowing)
                .findFirst().orElse(null);
        assertEquals(false, currRoom.getScene().lookup("#alertLabel").isVisible());
        clickOn("#nextDoorLeft");
        assertEquals(true, currRoom.getScene().lookup("#alertLabel").isVisible());
    }

    //Test that monster health saves when leave and re-enter room
    @Test
    public void testReEnter() {
        clickOn("#examBoss");
        Window currRoom = Stage.getWindows().stream().filter(Window::isShowing)
                .findFirst().orElse(null);
        Label monsterHP = (Label) currRoom.getScene().lookup("#monHealth");
        clickOn("#prevDoorLeft");
        clickOn("#door1");
        assertEquals(monsterHP, (Label) currRoom.getScene().lookup("#monHealth"));
    }
}
