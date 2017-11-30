package core;


/**
 * Neutral do nothing, they give useless information
 *
 * @author (Gp4 WoZ)
 * @version (09/11/2017)
 */
public class Neutral extends PNG
{
    private boolean isValid;
    
    /**
     * Constructeur d'objets de classe Neutral
     * name   name of the neutral
     * text   words he can express
     * room   place where he is 
     */
    public Neutral(String name, String text, Room room, String picture)
    {   
        super(name, text, room, picture);
    }
    
    /**
     * Test if the name of the neutral, the words he express, the room where he is are valid.
     * The name should be >= 3 characters.
     * The text should be >= 5 characters
     * Test if the room is valid and exist.
     */
    public boolean testValidity()
    {
        if((getName().length() >= 3) && getText().length()>=5 && getRoom().testValidity())
        {
            return true;
        }
        else
        {
            return false;
        }    
    }
}
