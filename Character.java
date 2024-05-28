public class Character {

    private String name;
    private int health;
    private int strength;
    private int endurance;
    private int intelligence;

    public Character(String WhatIsName, int healthStat, int strengthStat, int enduranceStat, int intelligenceStat) {
        name = WhatIsName;
        health = healthStat;
        strength = strengthStat;
        endurance = enduranceStat;
        intelligence = intelligenceStat;
    }

    public void setHealth(int newHealth) {this.health = newHealth;}

    public String toString() {
        return ("Character: " + name + "\n" + "Health: " + health + " \n" + "Endurance: " + endurance + "\n" + "Strength: " + strength + "\n"
                + "Intelligence: " + intelligence);
    }

    public int getHealth() {
        return health;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getStrength() {
        return strength;
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