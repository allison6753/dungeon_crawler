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
            this.cost = 10;
            this.damage = 2;
            this.healthDamage = 5;
            break;
        case TEXTBOOK:
            this.cost = 25;
            this.damage = 5;
            this.healthDamage = 10;
            break;
        case CALCULATOR:
            this.cost = 50;
            this.damage = 10;
            this.healthDamage = 20;
            break;
        default:
            break;
        }
        this.health = 100;
        this.alive = true;
    }

    public void use() {
        if (alive) {
            this.health -= healthDamage;
        }
        if (health == 0) {
            this.alive = false;
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
