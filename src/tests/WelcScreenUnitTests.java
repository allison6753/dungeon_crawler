package tests;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.ConfigScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class WelcScreenUnitTests extends ApplicationTest {
    private static final int TIMEOUT = 500;
    private WelcScreen welcScreen;

    @Override
    public void start(Stage primaryStage) throws Exception {
        welcScreen = new welcScreen();
        primaryStage.setScene(welcScreen.getScene());
        primaryStage.show();
    }

    @Before
    public void setUp() {
        try {
            //initialize JavaFX env without launching a window
            Platform.startup(() -> {
            });
        } catch (IllegalStateException e) {
            //the javaFX environment was already set up
        }

        welcScreen = new welcScreen();
    }
    
    @Test(timeout = TIMEOUT)
    public void testFxmlLoading() {
        assert (welcScreen.getRoot() != null);
        assert (welcScreen.getScene().getRoot() != null);
    }

}
