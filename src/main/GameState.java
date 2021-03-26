package main;

public class GameState {
    private int money;
    private int playerHealth;
    private ConfigScreen.Weapon weapon;
    private ConfigScreen.Difficulty difficulty;

    private GameScreen1 gameScreen1;

    private InteriorRoom[][] interiorRooms;

    public GameState(ConfigScreen.Weapon weapon, ConfigScreen.Difficulty difficulty) {

        interiorRooms = new InteriorRoom[4][5];

        this.weapon = weapon;
        this.difficulty = difficulty;
        this.playerHealth = 100;
        setStartingMoney(difficulty);
    }

    public void setStartingMoney(ConfigScreen.Difficulty difficulty) {
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

    public void setInteriorRoom(int roomOrder, int roomIndex, InteriorRoom interiorRoom) {
        interiorRooms[roomOrder][roomIndex] = interiorRoom;
    }
    public InteriorRoom getInteriorRoom(int roomOrder, int roomIndex) {
        return interiorRooms[roomOrder][roomIndex];
    }

    public void setGameScreen1(GameScreen1 gameScreen1) {
        this.gameScreen1 = gameScreen1;
    }
    public GameScreen1 getGameScreen1() {
        return gameScreen1;
    }

    public int getPlayerHealth() {
        return this.playerHealth;
    }

    public void setPlayerHealth(int newHealth) {
        this.playerHealth = newHealth;
    }

    public void damagePlayer(int damage) {
        this.playerHealth -= damage;
    }

    public boolean isPlayerAlive() {
        return this.playerHealth > 0;
    }


}
