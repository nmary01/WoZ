package core;


/**
 * Class represents a keys
 * A keys is represented by a name, a description and an exit
 * This class is a subclass of Item class
 *
 * @author (WOZGrp4)
 * @version (14/12/2017)
 */
public class Keys extends Item
{
    private Exit keyExit;

    /**
     * Constructor for objects of class Keys
     * @param consoName is the name of the key;
     * @param consoDescription is the descritpion of the key object;
     * @param exit is the exit which is opened with this key ;
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
