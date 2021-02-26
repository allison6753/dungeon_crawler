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
import org.testfx.toolkit.PrimaryStageApplication;

import static org.junit.Assert.assertEquals;

public class NameFieldTest extends ApplicationTest {
    private static final int TIMEOUT = 500;
    private ConfigScreen configScreen;

    @Override
    public void start(Stage primaryStage) throws Exception {
        configScreen = new ConfigScreen(1920, 1080);
        primaryStage.setScene(configScreen.getScene());
        primaryStage.show();
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
