package main;

public class HealthPotion extends Item {
    private GameState state = ConfigScreen.getGameState();
    private int playerHealth = state.getPlayerHealth();

    public HealthPotion() {
        cost = 50;
    }

    public void useHealthPotion() {
        playerHealth += 20;
    }
}
