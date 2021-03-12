package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main extends Application {
    private static int screenWidth = 1920;
    private static int screenHeight = 1080;

    private static String[] backgroundImgs;
    private static List<Integer> mazeOrder1 = new ArrayList<>();
    private static List<Integer> mazeOrder2 = new ArrayList<>();
    private static List<Integer> mazeOrder3 = new ArrayList<>();
    private static List<Integer> mazeOrder4 = new ArrayList<>();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        backgroundImgs = new String[]{
            "InitialGameScreenBackground.png",
            "InitialGameScreenBackground.png",
            "InitialGameScreenBackground.png",
            "InitialGameScreenBackground.png",
            "InitialGameScreenBackground.png",
            "InitialGameScreenBackground.png"
        };

        for (int i = 0; i < 6; i++) {
            mazeOrder1.add(i);
            mazeOrder2.add(i);
            mazeOrder3.add(i);
            mazeOrder4.add(i);
        }

        Collections.shuffle(mazeOrder1);
        Collections.shuffle(mazeOrder2);
        Collections.shuffle(mazeOrder3);
        Collections.shuffle(mazeOrder4);

        WelcScreen welcome = new WelcScreen();
        primaryStage.setScene(welcome.getScene());
        primaryStage.setResizable(true);
        primaryStage.setTitle("Tech Game");
        primaryStage.show();
    }

    public static void changeWindowTo(Stage window, Scene newScene) {
        window.setScene(newScene);
        window.show();
    }

    public static String[] getBackgroundImgs() {
        return backgroundImgs;
    }
    public static List<Integer> getMazeOrder1() {
        return mazeOrder1;
    }
    public static List<Integer> getMazeOrder2() {
        return mazeOrder2;
    }
    public static List<Integer> getMazeOrder3() {
        return mazeOrder3;
    }
    public static List<Integer> getMazeOrder4() {
        return mazeOrder4;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }
}
