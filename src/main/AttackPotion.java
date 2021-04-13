package main;

public class AttackPotion extends Item {
    private int damage;


    public AttackPotion() {
        cost = 50;
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
}
