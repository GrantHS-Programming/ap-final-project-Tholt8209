//Option 1 - Text Based game
//mapping out my game

// enter multiple options
// have multiple options for each indivisual action
// entering A, S, W, D will make your character go into a certain direction
// maybe even image with each directions or option

//Mechanics

//inventory is just a arraylist that could store objects
// those objects could have
// if (condition*)
// do this -

// direction could easily be done lke an array
// if (direction = a)
//         if (condition)
//              do this -
//similar to book class

// each time you are dont die, you gain +1 score

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public int charhealth = character.getHealth();
    public static int score = 0;
    public static boolean monsterEncounter = false;
    public static Character character;
    public static Goblin goblin;
    public static Octolin octolin;
    public static Living_Toxic living_toxic;
    public static King_Goblin king_goblin;
    public static ArrayList < String > Inventory = new ArrayList < > ();
    //Main Method
    public static void main(String[] args) {
        //Instructions
        System.out.println("Enter A to go left, enter D to go right, enter W to go forward, enter S to go back. ");
        System.out.println(" ");
        stats();
    }
    public static String monstertype() {
        int encounternum = (int)((Math.random() * 3) + 1);
        if (encounternum == 1) {
            return "Living Toxic";
        } else if (encounternum == 2) {
            return "Octolin";
        } else if (encounternum == 3) {
            return "King Goblin";
        } else {
            return "Goblin";
        }

    }

    public static int level() {
        int level = 1;

        if (score == 10) {
            level = 2;
        } else if (score == 20) {
            level = 3;
        } else if (score == 30) {
            level = 4;
        } else if (score == 40) {
            level = 5;
        }
        return level;
    }

    public static void stats() {
        Scanner myobj = new Scanner(System.in); // scanner
        int total = 20;
        int intel = 0;

        System.out.println("What is your name? ");
        String name = myobj.nextLine();

        System.out.println("You are given 20 total stat points. Enter values when asked.");
        while (total > 0) {
            System.out.println(total + " " + "total points. Enter points in Strength: ");
            int str = myobj.nextInt();
            total -= str;

            if (total > 0) {
                System.out.println(total + " " + "total points left. Enter points in Endurance: ");
                int end = myobj.nextInt();
                total -= end;

                intel = total;
                total -= intel;
                System.out.println("You have " + intel + " points in Intelligence.");
                character = new Character(name, 100, str, end, intel);

            }
            if (total < 0 || intel == 0) {
                System.out.println("Negative Points; 0 Points detected. - Restarting... ");
            }
        }

    }

    public void fightScene() {
        if (monsterEncounter) {
            boolean playerturn = false;
            boolean monsterturn = false;

            System.out.println("You encountered a" + monstertype());

            if (monstertype().equals("Goblin")) {
                if (character.getHealth() > goblin.getHealth()) {
                    playerturn = true;

                } else if (character.getHealth() < goblin.getHealth()) {
                    monsterturn = true;
                    if (monsterturn) {
                        int damage;
                        if (character.getStrength() >= character.getEndurance()) {
                            damage = goblin.getStrength() * 2 - character.getEndurance();
                        } else {
                            damage = goblin.getStrength() * goblin.getStrength() / character.getEndurance();
                        }
                        charhealth -= damage;
                        character.setHealth(charhealth);
                    }

                }




            }
        }
    }
    public int dmgcal(String Monster) {
        int damage = 0;
        if (Monster.equals("Goblin"))
            if (character.getStrength() >= character.getEndurance()) {
                damage = goblin.getStrength() * 2 - character.getEndurance();
            } else {
                damage = goblin.getStrength() * goblin.getStrength() / character.getEndurance();
            }
        if (Monster.equals("Octolin")) {
            if (character.getStrength() >= character.getEndurance()) {
                damage = Octolin.getStrength() * 2 - character.getEndurance();
            } else {
                damage = Octolin.getStrength() * Octolin.getStrength() / character.getEndurance();
            }


        }



        charhealth -= damage;
        character.setHealth(charhealth);

        return charhealth;
    }
}