public class Room {

    private String text;
    private int x;
    private int y;
    private int z;
    private int choiceNum;

    // 0 choices page | Ending
    public Room(String theRoomText) {
        text = theRoomText;
        choiceNum = 0;
    }

    //Only 1 Choice Page
    public Room(String theRoomText, int xLocation, int yLocation) {
        text = theRoomText;
        x = xLocation;
        y = yLocation;

    }


    //Getter Methods
    public String getText() {
        return text;
    }
    public int getX() {return x;}
    public int getY() {return y;}

    public int getChoiceNum() {
        return choiceNum;
    }

}
