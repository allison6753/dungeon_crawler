package main;

import static main.ConfigScreen.Weapon.*;

public class Weapon extends Item {
    private int damage;
    private int cost;
    private int health;
    private int healthDamage;
    private boolean alive;
    private ConfigScreen.Weapon weapon;

    public Weapon(ConfigScreen.Weapon weapon) {
        switch (weapon) {
        case PENCIL:
            this.cost = 10;
            this.damage = 2;
            this.healthDamage = 5;
            this.weapon = PENCIL;
            break;
        case TEXTBOOK:
            this.cost = 25;
            this.damage = 5;
            this.healthDamage = 10;
            this.weapon = TEXTBOOK;
            break;
        case CALCULATOR:
            this.cost = 50;
            this.damage = 10;
            this.healthDamage = 20;
            this.weapon = CALCULATOR;
            break;
        default:
            break;
        }
        this.health = 100;
        this.alive = true;
    }

    @Override
    public void useItem() {
        if (alive) {
            this.health -= healthDamage;
        }
        if (health == 0) {
            this.alive = false;
        }
    }

    @Override
    public String getImage() {
        switch (weapon) {
            case PENCIL:
                return "./resources/Pencil.png";
            case TEXTBOOK:
                return "./resources/Textbook.png";
            case CALCULATOR:
                return "./resources/Calculator.png";
            default:
                return null;
        }
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }

    public void setHeath(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    public void setHealthDamage(int healthDamage) {
        this.healthDamage = healthDamage;
    }
    public int getHealthDamage() {
        return healthDamage;
    }
}
