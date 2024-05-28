public class Octolin {

    public int health = (int)((Math.random() * 3) + 3);
    public int strength = (int)((Math.random() * 3) + 3);
    public int endurance = (int)((Math.random() * 2) + 3);
    public int intelligence = 2;
    public int amplifier = Main.level();

    public Octolin(int health, int strength, int endurance, int intelligence, int amplifier) {
        health *= amplifier;
        strength *= amplifier;
        endurance *= amplifier;
        intelligence *= amplifier;

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