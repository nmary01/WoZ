
/**
 * Décrivez votre classe Ennemy ici.
 *
 * @author (Grp4WoZ)
 * @version (9/11/2017)
 */
public class Enemy extends PNG
{
    private int healthPoints; //healthPoints of the Ennemy
    private boolean isValid; //true when all fields of the objects are correct
    private int damage;
    private int accuracy;
    private int pdv; //

    /**
     * Constructeur d'objets de classe Ennemy
     * The name should be >= 3 characters.
     * The text should be >= 5 characters 
     * Test if the room is valid and exist
     * healthpoints should be positive
     * damage should be > 0
     * accuracy should be positive and less than 100
     */
    public Enemy(String n, String t, Room r, int dmg, int acc, int pdv)
    {   
        super(n, t, r);
        healthPoints = pdv;
        damage = dmg;
        accuracy = acc;
    }

    /**
     * Accessor for healthPoints of the ennemy
     * 
     * @return healthpoints the number of healthpoints for the enemy
     */
    public int getHP()
    {
        return healthPoints;
    }
    
    /**
     * Method getDamage : damage made by the enemy
     * must be positive
     *
     * @return damage the damage made by the enemy
     */
    public int getDamage()
    {
        return damage;
    }
    
    /**
     * Method getAccuracy : accuracy of the enemy
     * must be positive and less than 100
     *
     * @return accuracy the acuracy of the enemy
     */
    public int getAccuracy()
    {
        return accuracy;
    }
    
    /**
     * Setter for healthPoints of the ennemy
     */
    public void setHP(int pdv)
    {
        healthPoints=pdv;
    }
    
    /**
     * Set the boolean isValid by checking if the object Ennemy is correctly created
     * name : +3 characters
     * text : +5 characters
     * healthpoints > 0
     * damage > 0
     * 100 < accuracy > 0
     * room : must exist
     * damage
     */
    public boolean testValidity()
    {
       if((getName().length() >= 3) && getText().length()>=5 && getRoom().testValidity() && damage>0 && 100>=accuracy && accuracy>0 && healthPoints>0)
       {
           return true;
       }
       else
       {
           return false;
       }    
    }
}
