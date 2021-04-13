package main;

public class Armour extends Item {
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

    @Override
    public void useItem() {
        usesLeft--;
        if (usesLeft == 0) {
            alive = false;
        }
    }

    @Override
    public String getImage() {
        /*TODO: change image */
        return "../resources/Attack_Potion.png";

    }

    public void buy() {
        alive = true;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
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
