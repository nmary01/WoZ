package core;

import java.util.*;
/**
 * Class Potion creates potions with:
 * - a name (3+ characters)
 * - a description (5+ characters)
 * - heal (the number of HP it gives back)
 * - used (if the potion is empty or not)
 * 
 * This class is a subclass of Item class
 * @author (WoZGrp4)
 * @version (14/12/2017)
 */
public class Potion extends Item
{
    private String description;
    private String name;
    private int heal;
    private boolean isValid;
    private boolean used;

    /**
     * Constructor for objects of class Potion
     * @param potionName. The name of the potion
     * @param potionDescription. The description of the potion
     * @param heal. The number of HP that the potion gives
     */
    public Potion(String potionName,String potionDescription, int heal)
    {
        super(potionName, potionDescription);
        this.heal = heal;
        used = false;
        isValid = testValidity();
    }
    
    /**
     * @Return the number of HP that the potion gives.
     */
    public int getHeal()
    {
        return heal;
    }
    
    /**
     * @Use a potion.
     */
    public void isUsed()
    {
        used=true;
    }
    
    /**
     * Test if the name of the potion, the description of the potion and the number of HP that the potion gives are valid.
     * Test if the name is correct or not. The name should be >= 3 characters.
     * Test if the description is correct or not. The description should be >= 5 characters.
     * Test if the number of HP that the potion gives is > 0.
     */
    public boolean testValidity()
    {
        if((getName().length() >= 3) && (getDescription().length() >= 5) && (heal > 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
