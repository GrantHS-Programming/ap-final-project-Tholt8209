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
import java.util.Scanner;

public class Main {

    public static int score = 0;
    public static Character character;
    public static boolean monsterEncounter = false;

    //Main Method
    public static void main(String[] args) {
        //Instructions
        System.out.println("Enter A to go left, enter D to go right, enter W to go forward, enter S to go back. ");
        System.out.println(" ");
        stats();
    }
//    public static String monstertype() {
//        if ()
//
//
//
//
//
//    }





    public static int level() {
        int level = 1;

        if (score == 10) {
             level = 2;
        }
        else if (score == 20) {
            level = 3;
        }
        else if (score == 30) {
            level = 4;
        }
        else if (score == 40) {
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

    public static void fightScene() {
        if (monsterEncounter) {

            System.out.println("You encountered a" + monstertype + );


        }


    }


























}