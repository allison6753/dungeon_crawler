import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.ConfigScreen;
import org.assertj.core.internal.bytebuddy.build.ToStringPlugin;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class ConfigWindowUnitTests extends ApplicationTest {
    private static final int TIMEOUT = 500;
    private ConfigScreen configScreen;

    @Override
    public void start(Stage primaryStage) throws Exception {
        configScreen = new ConfigScreen(1920, 1080);
        primaryStage.setScene(configScreen.getScene());
        primaryStage.show();
    }
/*
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
        configScreen = new ConfigScreen(1920, 1080);
    }

 */

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

    @Test
    public void testNullName() {
        TextField nameField = null;
        Button startButton = (Button) configScreen.getScene().lookup("#buttonStart");
        clickOn(startButton);
        Label alert = (Label) configScreen.getScene().lookup("#alertLabel");
        assertEquals(true, alert.isVisible());
    }

    @Test
    public void testEmptySpaceName() {
        TextField nameField = configScreen.getNameField();
        nameField.setText("");
        Button startButton = (Button) configScreen.getScene().lookup("#buttonStart");
        clickOn(startButton);
        Label alert = (Label) configScreen.getScene().lookup("#alertLabel");
        assertEquals(true, alert.isVisible());
    }

    @Test
    public void testTrailSpaceName() {
        TextField nameField = configScreen.getNameField();
        nameField.setText("            ");
        Button startButton = (Button) configScreen.getScene().lookup("#buttonStart");
        clickOn(startButton);
        Label alert = (Label) configScreen.getScene().lookup("#alertLabel");
        assertEquals(true, alert.isVisible());
    }
}
