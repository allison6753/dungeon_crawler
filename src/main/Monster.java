package main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.lang.Math;

public class Monster {

    //instance variables for attributes
    private int health;
    private boolean isAlive;
    @FXML
    Label healthLabel;
    private Scene scene;

    public Monster() {
        health = 100;
        isAlive = true;
    }

    public void attack() {
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
    }

    public void checkStatus() {
        if (health <= 0) {
            isAlive = false;
            this.die();
        }
    }

    private void setHealthLabel() {
        healthLabel = (Label) scene.lookup("#healthLabel");
        healthLabel.setText("Health: " + health);
    }

    public void updateHealthLabel() {
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
        this.health = num + this.health;
    }

}
