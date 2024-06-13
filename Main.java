import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    //Variables
    public static int score = 0;
    public static boolean createdPlayer = false;
    public static boolean monsterEncounter = false;
    public static boolean playerTurn = false;
    public static Character character;
    public int charhealth = character.getHealth();
    public static int x = 0;
    public static int y = 0;
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
        //stats();
        room();
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

    public static void runGame() {
        room();
    }

        public static void room() {



            Room firstRoom = new Room("firstRoom", 0, 0);
            Room room1 = new Room("room1 ", 0, 1);
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

            while (character.isDead()) {
                System.out.println(currentRoom.getText()); // prints page text
                System.out.println("Which Direction? "); // gets input of the choice
                String direction = myObj.nextLine(); // reads user input

                if (direction.equals("w")) {
                    y += 1;
                } else if (direction.equals("d")) {
                    x += 1;
                } else if (direction.equals("a")) {
                    x -= 1;
                } else if (direction.equals("s") && !(currentRoom == firstRoom)) {
                    y -= 1;
                }
                if ((x == 0) && (y == 1)) {
                    currentRoom = room1;
                }if ((x == 0) && (y == 2)) {
                    currentRoom = room2;
                }if ((x == 0) && (y == 3)) {
                    currentRoom = room3;
                }if ((x == 0) && (y == 4)) {
                    currentRoom = room4;
                }if ((x == 0) && (y == 5)) {
                    currentRoom = room5;

                }if ((x == -1) && (y == 1)) {
                    currentRoom = room1l;
                }if ((x == -2) && (y == 1)) {
                    currentRoom = room2l;
                }if ((x == -3) && (y == 1)) {
                    currentRoom = room3l;
                }if ((x == -3) && (y == 1)) {
                currentRoom = room4l;
                }

                if ((x == 1) && (y == 1)) {
                    currentRoom = room1r;
                } else if ((x == 2) && (y == 1)) {
                    currentRoom = room2r;
                } else if ((x == 3) && (y == 1)) {
                    currentRoom = room3r;
                } else if ((x == 4) && (y == 1)) {
                    currentRoom = room4r;
                }

                if ((x == 1) && (y == 2)) {
                    currentRoom = room1R2Y;
                } else if ((x == 1) && (y == 3)) {
                    currentRoom = room1R3Y;
                } else if ((x == 1) && (y == 4)) {
                    currentRoom = room1R4Y;
                } else if ((x == 2) && (y == 2)) {
                    currentRoom = room2R2Y;
                } else if ((x == 2) && (y == 3)) {
                    currentRoom = room2R3Y;
                } else if ((x == 2) && (y == 4)) {
                    currentRoom = room2R4Y;
                } else if ((x == 3) && (y == 2)) {
                    currentRoom = room3R2Y;
                } else if ((x == 3) && (y == 3)) {
                    currentRoom = room3R3Y;
                } else if ((x == 3) && (y == 4)) {
                    currentRoom = room3R4Y;
                } else if ((x == 4) && (y == 2)) {
                    currentRoom = room4R2Y;
                } else if ((x == 4) && (y == 3)) {
                    currentRoom = room4R3Y;
                } else if ((x == 4) && (y == 4)) {
                    currentRoom = room4R4Y;

                }

                if ((x == -1) && (y == 2)) {
                    currentRoom = roomN1R2Y;
                } else if ((x == -1) && (y == 3)) {
                    currentRoom = roomN1R3Y;
                } else if ((x == -1) && (y == 4)) {
                    currentRoom = roomN1R4Y;
                } else if ((x == -2) && (y == 2)) {
                    currentRoom = roomN2R2Y;
                } else if ((x == -2) && (y == 3)) {
                    currentRoom = roomN2R3Y;
                } else if ((x == -2) && (y == 4)) {
                    currentRoom = roomN2R4Y;
                } else if ((x == -3) && (y == 2)) {
                    currentRoom = roomN3R2Y;
                } else if ((x == -3) && (y == 3)) {
                    currentRoom = roomN3R3Y;
                } else if ((x == -3) && (y == 4)) {
                    currentRoom = roomN3R4Y;
                } else if ((x == -4) && (y == 2)) {
                    currentRoom = roomN4R2Y;
                } else if ((x == -4) && (y == 3)) {
                    currentRoom = roomN4R3Y;
                } else if ((x == -4) && (y == 4)) {
                    currentRoom = roomN4R4Y;
                }



                System.out.println("X value: " + x + "\n" + "Y Value: " + y);

            }

    }
}
