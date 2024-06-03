
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Variables
    public static int score = 0;
    public static boolean createdPlayer = false;
    public static boolean monsterEncounter = false;
    public static boolean playerTurn = false;
    public static Character character;
    public int charhealth = character.getHealth();
    public String userInput;
    
    //Monster Type
    public static Goblin goblin;
    public Octolin octolin;
    public static Living_Toxic living_toxic;
    public static King_Goblin king_goblin;
    //arrays
    public static ArrayList < String > Inventory = new ArrayList < > ();
    public static ArrayList < Main > Enemies = new ArrayList < Main > ();

    //Main Method
    public static void main(String[] args) {
        //Instructions
        System.out.println("Enter a to go left, enter s to go right, enter w to go forward, enter s to go back. ");
        System.out.println(" ");
        stats();

    }
    public static String monstertype() {
        int encounternum = (int)((Math.random() * 3) + 1);
        if (encounternum == 1) {
            return "Living Toxic";
        } else if (encounternum == 2 && level() == 1) {
            return "Octolin";
        } else if (encounternum == 3) {
            return "Goblin";
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
        if (!createdPlayer) {
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
                    character = new Character(name, 100, str, end, intel);
                }

                if (total < 0 || intel == 0) {
                    System.out.println("Negative Points; 0 Points detected. - Restarting... ");
                }
            }
        }
        System.out.println("You have " + intel + " points in Intelligence.");
    }

    public int playerDef(String Monster) {
        int damage = 0;
        if (Monster.equals("Goblin"))
            if (character.getStrength() >= character.getEndurance()) {
                damage = goblin.getStrength() * 2 - character.getEndurance();
            } else {
                damage = goblin.getStrength() * goblin.getStrength() / character.getEndurance();
            }

        else if (Monster.equals("Octolin")) {
            if (character.getStrength() >= character.getEndurance()) {
                damage = octolin.getStrength() * 2 - character.getEndurance();
            } else {
                damage = octolin.getStrength() * octolin.getStrength() / character.getEndurance();
            }

        } else if (Monster.equals("Living_Toxic")) {
            if (character.getStrength() >= character.getEndurance()) {
                damage = living_toxic.getStrength() * 2 - character.getEndurance();
            } else {
                damage = living_toxic.getStrength() * living_toxic.getStrength() / character.getEndurance();
            }
        }
        charhealth -= damage;
        character.setHealth(charhealth);

        return charhealth;
    }

    public int playerAtk(String Monster) {
        int damage = 0;
        if (Monster.equals("Goblin"))
            if (goblin.getStrength() >= goblin.getEndurance()) {
                damage = character.getStrength() * 2 - goblin.getEndurance();
            } else {
                damage = character.getStrength() * character.getStrength() / goblin.getEndurance();
            }

        else if (Monster.equals("Octolin")) {
            if (octolin.getStrength() >= octolin.getEndurance()) {
                damage = character.getStrength() * 2 - octolin.getEndurance();
            } else {
                damage = character.getStrength() * character.getStrength() / octolin.getEndurance();
            }

        } else if (Monster.equals("Living_Toxic")) {
            if (living_toxic.getStrength() >= living_toxic.getEndurance()) {
                damage = character.getStrength() * 2 - living_toxic.getEndurance();
            } else {
                damage = character.getStrength() * character.getStrength() / living_toxic.getEndurance();
            }
        }
        charhealth -= damage;
        character.setHealth(charhealth);

        return charhealth;
    }

    public void fightScene() {
        if (monsterEncounter) {
            if (Enemies.size() > 1) {
                System.out.println("You encountered a swarm of mobs. Stands in front of you are  " + Enemies.size() + Enemies);
            } else {
                System.out.println("You encountered a " + monstertype());
            }

            if (monstertype().equals("Goblin")) {
                Goblin goblin1 = new Goblin();
                if (character.getHealth() > goblin.getHealth()) {
                    playerTurn = true;
                } else {
                    playerTurn = false;
                }
                if (playerTurn) {
                    playerAtk("Goblin");
                    stats();
                    goblin1.getHealth();
                    playerTurn = false;

                } else {
                    playerDef("Goblin");
                    stats();
                    character.setHealth(charhealth);
                }
            }
        }
    }

    public void runGame() {
        fightScene();
    }

    public static void room() {

        Room firstRoom = new Room("You wake up in a dense forest, sunlight filtering through the canopy above. " + "\n" +
                "Surrounded by towering trees and chirping birds, you sense an adventure waiting to unfold. Which Direction do plan on going? ");

        Room room1 = new Room("You turn left. Looking forward, you spot a mysterious pathway leading deeper into the forest. " +
                "On your right, a bubbling stream winds its way through the trees, while on your left, the underbrush thickens, " +
                "concealing whatever secrets lie beyond.");
        Room room2 = new Room("You stumble upon an overgrown ruin, its weathered stones hinting at a forgotten past. " +
                "Intrigued, you venture closer, drawn by the allure of uncovering its secrets. You pick up a sword lying in bushes." );

        Room room3 = new Room("You enter the ruin, its darkened halls echoing with whispers of forgotten stories. " +
                "The air is heavy with the scent of decay, yet the allure of uncovering what lies within drives you deeper into its depths.");


        Room room4 = new Room("You stumble upon a dimly lit room, its walls adorned with ancient symbols. " +
                "In the center, a pedestal holds a pulsating artifact. As you draw near, a shadowy figure springs from the darkness, its eyes glinting with malice.");
                //Encounter Monster
        
        Room room5 = new Room("hi");
        Room room6 = new Room("hi");
        Room room7 = new Room("hi");
        Room room8 = new Room("hi");

        Room room1l = new Room("hi");
        Room room2l= new Room("hi");
        Room room3l = new Room("hi");
        Room room4l = new Room("hi");
        Room room5l = new Room("hi");
        Room room6l = new Room("hi");
        Room room7l = new Room("hi");
        Room room8l = new Room("hi");

        Room room1r = new Room("hi");
        Room room2r = new Room("hi");
        Room room3r = new Room("hi");
        Room room4r = new Room("hi");
        Room room5r = new Room("hi");
        Room room6r = new Room("hi");
        Room room7r = new Room("hi");
        Room room8r = new Room("hi");
        
        Room currentRoom = firstRoom;

        int choices = currentRoom.getChoiceNum();
        Scanner myObj = new Scanner(System.in); // scanner

        while (choices > 0) { // loop ( When the choices option is equal to 0, It stops)

            System.out.println(currentRoom.getText()); // ( prints page text. )
            System.out.println("Which Direction? "); // gets input of the choice
            String userInput = myObj.nextLine(); //  1,2

            if (character.isDead()) {
                choices = 0;
            }

            if (userInput.equals("w")) {
                if (currentRoom == firstRoom) {
                    currentRoom = room1;
                } else if (currentRoom == room1) {
                    currentRoom = room2;
                } else if (currentRoom == room2) {
                    currentRoom = room3;
                } else if (currentRoom == room3) {
                    currentRoom = room4;
                } else if (currentRoom == room4) {
                    currentRoom = room5;
                } else if (currentRoom == room5) {
                    currentRoom = room6;
                } else if (currentRoom == room6) {
                    currentRoom = room7;
                } else if (currentRoom == room7) {
                    currentRoom = room8;
                }

            }

            else if (currentRoom.equals("a")) {
                if (currentRoom == firstRoom) {
                    currentRoom = room1l;
                } else if (currentRoom == room1l) {
                    currentRoom = room2l;
                } else if (currentRoom == room2l) {
                    currentRoom = room3l;
                } else if (currentRoom == room3l) {
                    currentRoom = room4l;
                } else if (currentRoom == room4l) {
                    currentRoom = room5l;
                } else if (currentRoom == room5l) {
                    currentRoom = room6l;
                } else if (currentRoom == room6l) {
                    currentRoom = room7l;
                } else if (currentRoom == room7l) {
                    currentRoom = room8l;
                }

            }
            else if (currentRoom.equals("d")) {
                if (currentRoom == firstRoom) {
                    currentRoom = room1r;
                } else if (currentRoom == room1r) {
                    currentRoom = room2r;
                } else if (currentRoom == room2r) {
                    currentRoom = room3r;
                } else if (currentRoom == room3r) {
                    currentRoom = room4r;
                } else if (currentRoom == room4r) {
                    currentRoom = room5r;
                } else if (currentRoom == room5r) {
                    currentRoom = room6r;
                } else if (currentRoom == room6r) {
                    currentRoom = room7r;
                } else if (currentRoom == room7r) {
                    currentRoom = room8r;
                }

            }
            else if (currentRoom.equals("s")) {



            }
            else {
                System.out.println("Not a valid choice.");
            }
        }
    }



}
// text

// which direction
// Where to go?





