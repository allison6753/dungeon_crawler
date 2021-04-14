package main;

abstract class Item {
    private int cost;

    public int getCost() {
        return cost;
    }
    public void setCost(int num) {
        cost = num;
    }

    abstract String getImage();
    abstract void useItem();

    protected boolean isSingleUse() {
        return true;
    }


}
