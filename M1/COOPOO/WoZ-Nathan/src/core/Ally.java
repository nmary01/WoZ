package core;


/**
 * Ally can help the player to solve the investigation. 
 * An ally can give clues by a text or an object.
 * An ally can hold an item 
 *
 * @author (WOZGrp4)
 * @version (09/11/2017)
 */
public class Ally extends PNG
{
    private Item item;
    
    /**
     * Constructeur d'objets de classe Ally
     * allyName   name of the ally
     * allyText   words he can express
     * allyRoom   place where he is
     * allyItem   item he holds
     */
    public Ally(String name, String text, Room room, Item item, String picture)
    {
        super(name, text, room, picture);   
        this.item = item;
    }

    /**
     * Return the item holded by the ally.
     */
    public Item getItem()
    {
        return item;
    }
    
    /**
     * Test if the name of the ally, the words he express, the room where he is and the item he holds are valid.
     * The name should be >= 3 characters.
     * The text should be >= 5 characters
     * Test if the room is valid and exist.
     * Test if the item is valid and exist.
     */
    public boolean testValidity()
    {
        if((getName().length() >= 3) && getRoom().testValidity() && item.testValidity() && getText().length()>=5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
