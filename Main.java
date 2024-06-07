
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
    public static ArrayList<String> Inventory = new ArrayList<>();
    public static ArrayList<Main> Enemies = new ArrayList<Main>();

    //Main Method
    public static void main(String[] args) {
        //Instructions
        System.out.println("Enter a to go left, enter s to go right, enter w to go forward, enter s to go back. ");
        System.out.println(" ");
        stats();

    }

    public static String monstertype() {
        int encounternum = (int) ((Math.random() * 3) + 1);
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
        Room firstRoom = new Room("firstRoom", 0, 0);
        Room room1 = new Room("room1", 0, 1);
        Room room2 = new Room("room2", 0, 2); 
        Room room3 = new Room("room3", 0, 3); 
        Room room4 = new Room("room4", 0, 4);
        Room room5 = new Room("room5", 0, 5);

        Room room1l = new Room("room1l", -1, 1);
        Room room2l = new Room("room2l", -2, 1);
        Room room3l = new Room("room3l", -3, 1); 
        Room room4l = new Room("room4l", -4, 1);

        Room room1r = new Room("room1r", 1, 1);
        Room room2r = new Room("room2r", 2, 1);
        Room room3r = new Room("room3r", 3, 1);
        Room room4r = new Room("room4r", 4, 1);

        Room room1R2Y = new Room("room1R2Y", 1, 2);
        Room room1R3Y = new Room("room1R3Y", 1, 3);
        Room room1R4Y = new Room("room1R4Y", 1, 4);
        Room room2R2Y = new Room("room2R2Y", 2, 2);
        Room room2R3Y = new Room("room2R3Y", 2, 3);
        Room room2R4Y = new Room("room2R4Y", 2, 4);
        Room room3R2Y = new Room("room3R2Y", 3, 2);
        Room room3R3Y = new Room("room3R3Y", 3, 3);
        Room room3R4Y = new Room("room3R4Y", 3, 4);
        Room room4R2Y = new Room("room4R2Y", 4, 2);
        Room room4R3Y = new Room("room4R3Y", 4, 3);
        Room room4R4Y = new Room("room4R4Y", 4, 4);

        Room roomN1R2Y = new Room("roomN1R2Y", -1, 2);
        Room roomN1R3Y = new Room("roomN1R3Y", -1, 3);
        Room roomN1R4Y = new Room("roomN1R4Y", -1, 4);
        Room roomN2R2Y = new Room("roomN2R2Y", -2, 2);
        Room roomN2R3Y = new Room("roomN2R3Y", -2, 3);
        Room roomN2R4Y = new Room("roomN2R4Y", -2, 4);
        Room roomN3R2Y = new Room("roomN3R2Y", -3, 2);
        Room roomN3R3Y = new Room("roomN3R3Y", -3, 3);
        Room roomN3R4Y = new Room("roomN3R4Y", -3, 4);
        Room roomN4R2Y = new Room("roomN4R2Y", -4, 2);
        Room roomN4R3Y = new Room("roomN4R3Y", -4, 3);
        Room roomN4R4Y = new Room("roomN4R4Y", -4, 4);

        Room currentRoom = firstRoom;
        int choices = currentRoom.getChoiceNum();
        Scanner myObj = new Scanner(System.in); // scanner

        while (choices > 0) {
            System.out.println(currentRoom.getText()); // prints page text
            System.out.println("Which Direction? "); // gets input of the choice
            String userInput = myObj.nextLine(); // reads user input

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
                }
            } else if (userInput.equals("a")) {
                if (currentRoom == firstRoom) {
                    currentRoom = room1l;
                } else if (currentRoom == room1l) {
                    currentRoom = room2l;
                } else if (currentRoom == room2l) {
                    currentRoom = room3l;
                } else if (currentRoom == room3l) {
                    currentRoom = room4l;
                }
            } else if (userInput.equals("d")) {
                if (currentRoom == firstRoom) {
                    currentRoom = room1r;
                } else if (currentRoom == room1r) {
                    currentRoom = room2r;
                } else if (currentRoom == room2r) {
                    currentRoom = room3r;
                } else if (currentRoom == room3r) {
                    currentRoom = room4r;
                }
            } else if (userInput.equals("s")) {
                // Handle south direction if needed
            } else {
                System.out.println("Not a valid choice.");
            }
        }
    }
}

// text

// which direction
// Where to go?





