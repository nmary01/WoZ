package core;


/**
 * Class Exit represent directions that can take the player
 * Exit is represented by
 * - a direction (north....)
 * - a room that we want to go inside
 * - a door opened or not
 * - a text which informs the player if the exit is locked
 *
 * @author (WoZGrp4)
 * @version (14/11/2017)
 */
public class Exit
{
    private String direction; //direction that can take the player
    private Room room; //room that the player can go inside
    private boolean opened; //if the exit is locked or not
    private String textBlock; //text which informs the player if the exit is locked
    
    /**
     * Objects constructor of the class Exit
     * @param String direction   direction that can take the player 
     * @param Room room     room that the player can go inside
     * @param boolean opened     if the exit is locked or not
     * @param String textBlock     text which informs the player if the exit is locked
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
     * @return the exit is locked or not
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

    /**
     * Accessor for textBlock
     * @return the text block
     */
    public String getTextBlock() {
        return textBlock;
    }

    /**
     * Method setTextBlock
     * @param textBlock the new text block of the exit
     */
    public void setTextBlock(String textBlock) {
        this.textBlock = textBlock;
    }
    
    
}
