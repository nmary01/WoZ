
/**
 * Abstract Class PNG creates PNG with :
 * - a name
 * - a text
 * - a room
 * @author (Grp4WoZ)
 * @version (20/11/2017)
 */
 abstract class PNG
{
    private String name; //The name of the PNG
    private String text; //The text said by the PNG
    protected Room room; //The room where is the PNG


    /**
     * Constructeur d'objets de classe PNG
     */
    public PNG(String name, String text, Room room)
    {     
        this.name = name;
        this.text = text;
        this.room = room;
    }

    /**
     * Return the name of the PNG
     */
    protected String getName()
    {
        return name;
    }
    
    /**
     * Return the room where the PNG is located
     */
    protected Room getRoom()
    {
        return room;
    }
    
    /**
     * Return the PNG's text
     */
    protected String getText()
    {
        return text;
    }
    
    
    /**
     * Method setText
     *
     * @param text the new text of the PNG
     */
    public void setText(String text)
    {
        this.text = text;
    }
    
    /**
     * Method setRoom
     *
     * @param text the new text of the PNG
     */
    public void setRoom(Room room)
    {
        this.room = room;
    }
}
