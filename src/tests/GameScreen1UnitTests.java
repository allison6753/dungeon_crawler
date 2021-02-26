package tests;

import javafx.application.Platform;
import main.ConfigScreen;
import main.GameScreen1;
import org.junit.Before;
import org.junit.Test;

public class GameScreen1UnitTests {
    private static final int TIMEOUT = 500;
    private GameScreen1 screen1;

    @Before
    public void setUp() {
        try {
            //initialize JavaFX env without launching a window
            Platform.startup(() -> {

            });
        } catch (IllegalStateException e) {
            //the javaFX environment was already set up
        }

        //setup a dummy screen on the GameScreen1 page for testing
        screen1 = new GameScreen1(ConfigScreen.Difficulty.INVALID, ConfigScreen.Weapon.INVALID);
    }

    @Test(timeout = TIMEOUT)
    public void testFxmlLoading() {
        //if the constructor cannot find InitialGameScreen.fxml, the root will be null and the scene
        //cannot be properly constructed
        assert (screen1.getRoot() != null);
        assert (screen1.getScene().getRoot() != null);
    }

    //test that all 4 doors lead to correct room

    //test that shop leads to correct screen

    //test that label shows correct amount of starting money

}

