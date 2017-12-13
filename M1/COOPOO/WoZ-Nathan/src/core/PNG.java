package core;


/**
 * Abstract Class PNG creates PNG with :
 * - a name
 * - a text
 * - a room
 * @author (Grp4WoZ)
 * @version (20/11/2017)
 */
 public abstract class PNG
{
    private String name; //The name of the PNG
    private String text; //The text said by the PNG
    protected Room room; //The room where is the PNG
    private String picture;


    /**
     * Constructeur d'objets de classe PNG
     */
    public PNG(String name, String text, Room room, String picture)
    {     
        this.name = name;
        this.text = text;
        this.room = room;
        this.picture = picture;
    }

    /**
     * Return the name of the PNG
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return the room where the PNG is located
     */
    public Room getRoom()
    {
        return room;
    }
    
    /**
     * Return the PNG's text
     */
    public String getText()
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

    public String getPicture() {
        return picture;
    }
    
    
}
