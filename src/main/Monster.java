package main;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Random;

public class Monster {

    //instance variables for attributes
    private int health;
    private boolean isAlive;
    @FXML
    private Label healthLabel;
    private Scene scene;

    public Monster() {
        health = 100;
        isAlive = true;
    }

    public void attack(int damage) {
        this.scene = Stage.getWindows().stream().filter(Window::isShowing)
                .findFirst().orElse(null).getScene();

        health -= damage;
        updateHealthLabel();
        checkStatus();
        //implement this later when we have person class
        //person.setHealth(person.getHealth - Math.random() * (10 - 0 + 1) + 1));

        //also - do we want the attacker's health to go down too?
        //this.setHealth((int) (this.getHealth() - Math.random() * ((5 - 0 + 1) + 1)));
        //checkStatus();
        //updateHealthLabel();

    }

    public void die() {
        //make monster disappear
        healthLabel.setVisible(false);

        Button monsterButton = (Button) scene.lookup("#examBoss");
        monsterButton.setVisible(false);
        // Item (random money, weapon, potion) drop
        dropItem();
    }

    // Get the drop item
    private void dropItem() {
        Random rand = new Random();
        int randomNum = rand.nextInt(2);
        processRandom(randomNum);
    }

    private void processRandom(int randomNum) {
        GameState currGameState = ConfigScreen.getGameState();
        if (randomNum == 0) {
            // Money Drop (+100), maybe (the number of room index can change money?
            int currMoney = currGameState.getMoney();
            currGameState.setMoney(currMoney + 100);
        } else if (randomNum == 1) {
            // Potion Drop (+10 Health)
            int currHealth = currGameState.getPlayerHealth();
            currGameState.setPlayerHealth(currHealth + 10);
        } /*
        else {
            // Attack Potion : increase attack power of current weapon (+10) - Problem: cannot access weapon;

            ConfigScreen.Weapon currWeapon = currGameState.getWeapon();
            int currDam = currWeapon.getDamage();

            Weapon currWeapon = new Weapon(currGameState.getWeapon());
            int currDam = currWeapon.getDamage();
            int newDam = currDam + 10;
            currWeapon.setDamage(newDam);
            currGameState.setWeapon(currWeapon);
        }
        */
        int currRoomOrder = currGameState.getRoomOrder();
        int currRoomIndex = currGameState.getRoomIndex();
        InteriorRoom currRoom = currGameState.getInteriorRoom(currRoomOrder, currRoomIndex);
        currRoom.updateLabels();
    }


    public void checkStatus() {
        if (health <= 0) {
            isAlive = false;
            this.die();
        }
    }

    public void updateHealthLabel() {
        healthLabel = (Label) scene.lookup("#monHealth");
        healthLabel.setText("Health: " + getHealth());
    }


    //getters and setters for instance variables
    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsAlive(boolean val) {
        this.isAlive = val;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int num) {
        this.health = num;
    }

}
