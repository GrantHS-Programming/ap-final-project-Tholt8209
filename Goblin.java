public class Goblin {

    public int health = (int) ((Math.random() * 3) + 3);
    public int strength = (int) ((Math.random() * 3 ) + 3);
    public int endurance = (int) ((Math.random() * 2) + 3);
    public int intelligence = 2;
    public int amplifier = Main.level();

    public Goblin() {
        health = ((int)((Math.random() * 3) + 2)) * amplifier;
        strength = ((int)((Math.random() * 3) + 2)) * amplifier;
        endurance = ((int)((Math.random() * 3) + 2)) * amplifier;
        intelligence = 2 * amplifier;

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
