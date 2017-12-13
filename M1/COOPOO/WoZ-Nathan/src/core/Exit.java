package core;


/**
 * Class Exit represent directions that can take the player
 * Exit is represented by
 * - a direction (north....)
 * - a room that we want to go inside
 * - a door opened or not
 *
 * @author (WoZGrp4)
 * @version (14/11/2017)
 */
public class Exit
{
    private String direction;
    private Room room;
    private boolean opened;
    private String textBlock;
    
    /**
     * Constructeur d'objets de classe Exit
     */
    public Exit(String direction, Room room, boolean opened, String textBlock)
    {
        this.direction = direction;
        this.room = room;
        this.opened = opened;
        this.textBlock=textBlock;
    }

    /**
     * Accessor for direction
     * 
     * @return direction that can take the player
     */
    public String getDirection()
    {
        return direction;
    }
    
    /**
     * Accessor for room
     * 
     * @return the room that you can go inside
     */
    public Room getRoom()
    {
        return room;
    }
    
    /**
     * Accessor for boolean opened
     */
    public boolean getOpened()
    {
        return opened;
    }
    
    /**
     * Modifier for boolean opened
     * If exit was opened, it is closed, and upside down.
     */
    public void changeExitState()
    {
        if (opened){opened=false;}
        else{opened=true;}
    }

    public String getTextBlock() {
        return textBlock;
    }

    public void setTextBlock(String textBlock) {
        this.textBlock = textBlock;
    }
    
    
}
