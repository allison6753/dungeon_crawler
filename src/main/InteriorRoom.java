package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class InteriorRoom {
    private Scene scene;
    private Pane root;
    private Label alertLabel;

    private int money;
    private int roomIndex; // 0-5 sequentially in mazOrder
    private int roomNum; // 0-5 randomly to create a "random maze"
    private int order;
    private String backGroundImage;
    private ConfigScreen.Weapon weapon;
    private ConfigScreen.Difficulty difficulty;

    Monster monster = new Monster();

    public InteriorRoom(int roomIndex, ConfigScreen.Difficulty difficulty,
                        ConfigScreen.Weapon weapon, int money, int order) {
        try {
            root = FXMLLoader.load(
                    GameScreen1.class.getResource("../resources/LectureRoom.fxml")
            );
        } catch (IOException except) {
            //the fxml loader can't find the file
        }

        this.weapon = weapon;
        this.difficulty = difficulty;
        this.money = money;
        this.roomIndex = roomIndex;
        this.order = order;
        checkOrder(order);

        scene = new Scene(root, Main.getScreenWidth(), Main.getScreenHeight());
        addBackgroundImage("../resources/" + GameScreen1.getBackgroundImgs()[roomNum]);
        setMoneyLabel();

        setupDoors();
        monsterButton();
        setHealthLabel();

    }

    private void checkOrder(int order) {
        if (order == 1) {
            this.roomNum = GameScreen1.getMazeOrder1().get(this.roomIndex);
        } else if (order == 2) {
            this.roomNum = GameScreen1.getMazeOrder2().get(this.roomIndex);
        } else if (order == 3) {
            this.roomNum = GameScreen1.getMazeOrder3().get(this.roomIndex);
        } else {
            this.roomNum = GameScreen1.getMazeOrder4().get(this.roomIndex);
        }
    }

    public Scene getScene() {
        return this.scene;
    }

    public Pane getRoot() {
        return root;
    }

    private void addBackgroundImage(String background) {
        root.setStyle("-fx-background-image: url('"
                + Main.class.getResource(background)
                .toExternalForm()
                + "');\n-fx-background-position: center center; \n-fx-background-repeat: stretch;");
        backGroundImage = background;
    }

    public int getMoney() {
        return money;
    }

    public ConfigScreen.Weapon getWeapon() {
        return weapon;
    }

    public ConfigScreen.Difficulty getDifficulty() {
        return difficulty;
    }


    private void setMoneyLabel() {
        Label moneyLabel = (Label) scene.lookup("#money");
        moneyLabel.setText("Room:" + roomNum + "Money: $" + money);
    }


    private void setupDoors() {
        //make the prev door


        Button nextDoorLeft = (Button) scene.lookup("#nextDoorLeft");
        nextDoorLeft.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Open_Door_Left.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        this.alertLabel = (Label) scene.lookup("#alertLabel");
        nextDoorLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (monster.getHealth() == 0) {
                    Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    if (roomIndex < 5) {
                        InteriorRoom nextRoom = new InteriorRoom(roomIndex + 1, difficulty,
                                weapon, money, order);
                        Main.changeWindowTo(currentWindow, nextRoom.getScene());
                    } else {
                        LastRoom lastRoom = new LastRoom(difficulty, weapon, money);
                        Main.changeWindowTo(currentWindow, lastRoom.getScene());
                    }
                } else {
                    alertLabel.setVisible(true);
                }

            }
        });

        Button nextDoorRight = (Button) scene.lookup("#nextDoorRight");
        nextDoorRight.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Open_Door_Right.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        nextDoorRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (monster.getHealth() == 0) {
                    Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    if (roomIndex < 5) {
                        InteriorRoom nextRoom = new InteriorRoom(roomIndex + 1, difficulty,
                                weapon, money, order);
                        Main.changeWindowTo(currentWindow, nextRoom.getScene());
                    } else {
                        LastRoom lastRoom = new LastRoom(difficulty, weapon, money);
                        Main.changeWindowTo(currentWindow, lastRoom.getScene());
                    }
                } else {
                    alertLabel.setVisible(true);
                }
            }
        });

        Button prevDoorLeft = (Button) scene.lookup("#prevDoorLeft");
        prevDoorLeft.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Open_Door.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        prevDoorLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                if (roomIndex == 0) {
                    GameScreen1 screen1 = new GameScreen1(difficulty, weapon, false);
                    Main.changeWindowTo(currentWindow, screen1.getScene());
                }
                if (roomIndex > 0) {
                    InteriorRoom prevRoom = new InteriorRoom(roomIndex - 1, difficulty,
                            weapon, money, order);
                    Main.changeWindowTo(currentWindow, prevRoom.getScene());
                }
            }
        });
        Button prevDoorRight = (Button) scene.lookup("#prevDoorRight");
        prevDoorRight.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Open_Door.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        prevDoorRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                if (roomIndex == 0) {
                    GameScreen1 screen1 = new GameScreen1(difficulty, weapon, false);
                    Main.changeWindowTo(currentWindow, screen1.getScene());
                }
                if (roomIndex > 0) {
                    InteriorRoom prevRoom = new InteriorRoom(roomIndex - 1, difficulty,
                            weapon, money, order);
                    Main.changeWindowTo(currentWindow, prevRoom.getScene());
                }
            }
        });

    }

    public String getBackgroundImage() {
        return backGroundImage;
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    private void setHealthLabel() {
        Label monHealthLab = (Label) scene.lookup("#monHealth");
        monHealthLab.setText("Health: " + monster.getHealth());
    }

    //setting up monster
    private void monsterButton() {
        Button monsterButton = (Button) scene.lookup("#examBoss");
        monsterButton.setStyle("-fx-background-image: url('"
                + Main.class.getResource("../resources/Exam_Boss.png").toExternalForm()
                + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
                + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
        monsterButton.setText("");

        monsterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // when monster is clicked (attacked), health declines by 10
                monster.attack(10);
                //monster.updateHealthLabel();
            }
        });



    }

    /**
     Button prevDoor = (Button) scene.lookup("#prevRoomDoor");
     prevDoor.setStyle("-fx-background-image: url('"
     + Main.class.getResource("../resources/Door.png").toExternalForm()
     + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
     + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
     prevDoor.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
    Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
    if (roomIndex == 0) {
    GameScreen1 screen1 = new GameScreen1(difficulty, weapon, false);
    Main.changeWindowTo(currentWindow, screen1.getScene());
    }
    if (roomIndex > 0) {
    InteriorRoom prevRoom = new InteriorRoom(roomIndex - 1, difficulty,
    weapon, money, order);
    Main.changeWindowTo(currentWindow, prevRoom.getScene());
    }
    }
    });
     //make the next door
     Button nextDoor = (Button) scene.lookup("#nextRoomDoor");
     nextDoor.setStyle("-fx-background-image: url('"
     + Main.class.getResource("../resources/Door.png").toExternalForm()
     + "'); \n-fx-background-position: center center; \n-fx-background-repeat: stretch;"
     + "\n-fx-background-size: stretch;\n-fx-background-color: transparent;");
     nextDoor.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
    Stage currentWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
    if (roomIndex < 5) {
    InteriorRoom nextRoom = new InteriorRoom(roomIndex + 1, difficulty,
    weapon, money, order);
    Main.changeWindowTo(currentWindow, nextRoom.getScene());
    } else {
    LastRoom lastRoom = new LastRoom(difficulty, weapon, money);
    Main.changeWindowTo(currentWindow, lastRoom.getScene());
    }
    }
    });
     */

}