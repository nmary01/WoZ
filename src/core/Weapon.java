package core;

import java.util.*;

/**
 * Class Weapon creates an item weapon with:
 * - a name (3+ characters)
 * - a description (5+ characters)
 * - damage (positive)
 * - accuracy (positive <= 100);
 * This class is a subclass of Item class
 *
 * @author (Grp4WoZ)
 * @version (14/12/2017)
 */


public class Weapon extends Item
{
    private int damage; //the number of damages when hit
    private int accuracy; // a number between 1 and 100 (100: hit everytime)
    private boolean isValid; //true when all fields of the objects are correct
    
    /**
     * Constructeur d'objets de classe Weapon
     * @param weaponName The name of the weapon
     * @param weaponDescription The description of the weapon
     * @param damage the value of the weapon damages
     * @param acc the value of the weapon accuracy
     */
    public Weapon(String weaponName, String weaponDescription, int dmg, int acc)
    {
        super(weaponName,weaponDescription);
        damage = dmg;
        accuracy = acc;
        isValid = testValidity();
    }
    
    /**
     * Getter for Weapon damages
     * @return return the damage that the weapon gives
     */
    public int getDamage()
    {
        return damage;
    }
    
    /**
     * Getter for Accuracy damages
     * @return return the accuracy of the weapon
     */
    public int getAccuracy()
    {
        return accuracy;
    }
    
    /**
     * Test the validity of the object:
     * name: 3+ characters
     * description : 5+ characters
     * damage : >0
     * accuracy : >0 and <= 100
     */
    public boolean testValidity()
    {
        if(name.length()>=3 && description.length()>=5 && damage>0 && accuracy>0 && accuracy<=100)
        {return true;}
        else{return false;}
    } 
}
