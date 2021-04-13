package main;

abstract class Item {
    int cost;

    public int getCost() {
        return cost;
    }

    abstract String getImage();
    abstract void useItem();

    boolean isSingleUse() {
        return true;
    }
}
