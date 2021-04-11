package main;

public class Armour {
    //use if making different types of armour -> private int protection;
    //use if making different types of armour -> private int healthDamage;
    private int cost;
    private int usesLeft;
    private boolean alive;

    public Armour() {
        cost = 80;
        usesLeft = 5;
        alive = false;
    }

    public void use() {
        usesLeft--;
        if (usesLeft == 0) {
            alive = false;
        }
    }

    public void buy() {
        alive = true;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getCost() {
        return cost;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean getAlive() {
        return alive;
    }
}
