package main;

public class HealthPotion extends Item {
    private GameState state = ConfigScreen.getGameState();
    private int playerHealth = state.getPlayerHealth();

    public HealthPotion() {
        cost = 50;
    }

    public void useItem() {
        playerHealth += 20;
    }

    public String getImage() {
        return "../resources/Health_Potion.png";
    }
}
