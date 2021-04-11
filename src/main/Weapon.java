package main;

public class Weapon {
    private int damage;
    private int cost;
    private int health;
    private int healthDamage;
    private boolean alive;

    public Weapon(ConfigScreen.Weapon weapon) {
        switch (weapon) {
        case PENCIL:
            cost = 10;
            damage = 2;
            healthDamage = 5;
            break;
        case TEXTBOOK:
            cost = 25;
            damage = 5;
            healthDamage = 10;
            break;
        case CALCULATOR:
            cost = 50;
            damage = 10;
            healthDamage = 20;
            break;
        default:
            break;
        }
        health = 100;
        alive = true;
    }

    public void use() {
        if (alive) {
            health -= healthDamage;
        }
        if (health == 0) {
            alive = false;
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
