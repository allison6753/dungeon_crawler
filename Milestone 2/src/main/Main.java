package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    private int screenWidth = 800;
    private int screenHeight = 800;

    // Weapon Choices
    private String[] weaponChoice = {"Weapon 1", "Weapon 2", "Weapon 3"};
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        // Weapon Selection
        Label option = new Label("Select your weapons ");
        ComboBox<String> weaponBox = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList(weaponChoice);
        weaponBox.getItems().addAll(items);
        weaponBox.setValue("Weapon 1");

        // Button for next screen
        Button play = new Button("Play");

        // HBox
        VBox vBoxWeapon = new VBox();
        vBoxWeapon.getChildren().addAll(option, weaponBox, play);
        vBoxWeapon.setAlignment(Pos.CENTER);
        vBoxWeapon.setSpacing(20);
        // Border Pane (Main Pane)
        BorderPane configPane = new BorderPane();
        configPane.setCenter(vBoxWeapon);


        Scene scene = new Scene(configPane, screenWidth, screenHeight);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Our Game");
        primaryStage.show();
    }
}
