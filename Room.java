public class Room {

    private String text;
    private int direction;
    private int west;
    private int east;
    private int north;
    private int south;
    private int choiceNum;

    // 0 choices page | Ending
    public Room(String theRoomText) {
        text = theRoomText;
        choiceNum = 0;
    }

    //Only 1 Choice Page
    public Room(String theRoomText, String direction) {
        text = theRoomText;
        if (direction.equals("s")) {
            north = 1;
        }
        else if (direction.equals("w")) {

        }
        else if (direction.equals("a")) {}
        else if (direction.equals("d")) {}
        else {}

    }


    //Getter Methods
    public String getText() {
        return text;
    }

    public int getChoice1() {
        return choice1;
    }

    public int getChoice2() {
        return choice2;
    }

    public int getChoiceNum() {
        return choiceNum;
    }

}
