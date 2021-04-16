package main;

public class AttackPotion extends Item {
    private int damage;



    public AttackPotion() {
        setCost(50);
    }

    public void useAttackPotion(ConfigScreen.Weapon weapon) {
        switch (weapon) {
        case PENCIL:
            damage = 10;
            break;
        case TEXTBOOK:
            damage = 15;
            break;
        case CALCULATOR:
            damage = 20;
            break;
        default:
            break;
        }
    }

    public void useItem() {
        // to do: make attack potion attack
        GameState currGameState = ConfigScreen.getGameState();
        currGameState.setAttackPotion();
    }

    @Override
    String getImage() {
        return "../resources/Attack_Potion.png";
    }
}
