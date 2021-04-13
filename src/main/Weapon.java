package main;

import static main.ConfigScreen.Weapon.*;

public class Weapon extends Item {
    private int damage;
    private int cost;
    private int health;
    private int healthDamage;
    private boolean alive;
    private int weaponType;

    public Weapon(ConfigScreen.Weapon weapon) {
        switch (weapon) {
        case PENCIL:
            this.cost = 10;
            this.damage = 2;
            this.healthDamage = 5;
            this.weaponType = 0;
            break;
        case TEXTBOOK:
            this.cost = 25;
            this.damage = 5;
            this.healthDamage = 10;
            this.weaponType = 1;
            break;
        case CALCULATOR:
            this.cost = 50;
            this.damage = 10;
            this.healthDamage = 20;
            this.weaponType = 2;
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
        switch (weaponType) {
            case 0:
                return "./resources/Pencil.png";
            case 1:
                return "./resources/Textbook.png";
            case 2:
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
