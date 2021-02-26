package tests;

import javafx.application.Platform;
import javafx.scene.control.Button;
import main.ConfigScreen;
import org.junit.Before;
import org.junit.Test;

public class ConfigWindowUnitTests {
    private static final int TIMEOUT = 500;
    private ConfigScreen configScreen;

    @Before
    public void setUp() {
        try {
            //initialize JavaFX env without launching a window
            Platform.startup(() -> {

            });
        } catch (IllegalStateException e) {
            //the javaFX environment was already set up
        }

        //setup a dummy screen on the configuration page for testing
        configScreen = new ConfigScreen();
    }

    @Test(timeout = TIMEOUT)
    public void testFxmlLoading() {
        //if the constructor cannot find configPane.fxml, the root will be null and the scene
        //cannot be properly constructed
        assert (configScreen.getRoot() != null);
        assert (configScreen.getScene().getRoot() != null);
    }

    @Test(timeout = TIMEOUT)
    public void testDifficultySelection() {
        //config screen should start with an invalid (unselected) difficulty
        assert (configScreen.getDifficulty() == ConfigScreen.Difficulty.INVALID);
        //simulate clicking on the in state difficulty button
        Button inStateDifficulty = ((Button) configScreen.getScene().lookup("#diffIS"));
        inStateDifficulty.fire(); //simulate button click
        //difficulty should now be in state
        assert (configScreen.getDifficulty() == ConfigScreen.Difficulty.IN_STATE);
    }

}
