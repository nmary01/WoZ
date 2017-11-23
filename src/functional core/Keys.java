
/**
 * Class represent a keys
 * a keys is represented by a name, a description and a room
 *
 * @author (WOZGrp4)
 * @version (20/11/2017)
 */
public class Keys extends Item
{
    private Exit keyExit;

    /**
     * Constructor for objects of class Keys
     */
    public Keys(String consoName, String consoDescription, Exit exit)
    {
        super(consoName, consoDescription); 
        keyExit = exit ;
    }
    
    /**
     * Accessor to know where the keys is used
     * 
     * @return the room which can be opened
     * @return the direction
     */
    public Exit getKeyExit()
    {
        return keyExit;
    }
    
    /**
     * Accessor to know the description of the room where the keys is linked 
     * 
     * @return the keyRoom description
     */
    public String getKeyRoom()
    {
        return keyExit.getRoom().getDescription();
    }
}
