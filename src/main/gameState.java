package main;

public class gameState {
    private int money;
    private ConfigScreen.Weapon weapon;
    private ConfigScreen.Difficulty difficulty;

    private int[] monsters;

    public gameState(ConfigScreen.Weapon weapon, ConfigScreen.Difficulty difficulty) {
        switch (difficulty) {
            case IN_STATE:
                money = 500;
                break;
            case OUT_OF_STATE:
                money = 300;
                break;
            case INTERNATIONAL:
                money = 100;
                break;
            default:
                break;
        }

        this.weapon = weapon;
        this.difficulty = difficulty;

        monsters = new int[]{100,100,100,100,100};

    }


    public void setMoney(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }

    public void setWeapon(ConfigScreen.Weapon weapon) {
        this.weapon = weapon;
    }
    public ConfigScreen.Weapon getWeapon() {
        return weapon;
    }

    public void setDifficulty(ConfigScreen.Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    public ConfigScreen.Difficulty getDifficulty() {
        return difficulty;
    }

    public void setMonsters(int roomIndex) {
        monsters[roomIndex] -= 10;
    }
    public int getMonsters(int roomIndex) {
        return monsters[roomIndex];
    }


}
