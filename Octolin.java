public class Octolin {

    public int health;
    public int strength;
    public int endurance;
    public int intelligence;
    public int amplifier = Main.level();

    public Octolin() {
        health = ((int)((Math.random() * 3) + 3)) * amplifier;
        strength = ((int)((Math.random() * 3) + 3)) * amplifier;
        endurance = ((int)((Math.random() * 3) + 3)) * amplifier;
        intelligence = 4 * amplifier;

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



}
