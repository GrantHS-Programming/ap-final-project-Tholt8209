public class Living_Toxic {

    public int health;
    public int strength;
    public int endurance;
    public int intelligence;
    public int amplifier = Main.level();

    public Living_Toxic() {
        health = 1;
        strength = ((int) ((Math.random() * 2) + 1)) * amplifier;
        endurance = ((int) ((Math.random() * 2) + 1)) * amplifier;
        intelligence = amplifier;

    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getIntelligence() {
        return intelligence;
    }


    public boolean isDead() {
        if (health == 0) {
            return true;
        } else {
            return false;
        }
    }
}