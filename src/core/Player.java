package core;

import java.util.ArrayList;
/**
 * This class represent a player
 * A player has a name, a number of healthpoints, a diary and an inventory
 * He can be armed and the inventory can have 4 items max
 *
 * @author (WoZGrp4)
 * @version (14/11/2017)
 */
public class Player
{
    private String name; //name of the player
    private int healthPoints; //HP of the player : >= 0
    private ArrayList <Item> inventory; //inventory of the player : 4 items max, including only 1 weapon
    private boolean armed; // true when the player has a weapon
    private ArrayList <String> diary; // Each string is a summary of previous key-moments
    private boolean isValid; //true when all fields of the objects are correct
    private int nbItemInInventory; //
    private static int sizeInventory =4; //
    
    
    /**
     * Constructeur d'objets de classe Player
     */
    public Player(String name)
    {
        this.name=name;
        healthPoints = 10;
        armed = false;
        inventory = new ArrayList();
        diary = new ArrayList();
        isValid = testValidity();
        nbItemInInventory = 0;
    }

    /**
     * Return the number of healthpoints for the player
     *
     * A player can have 10 healthpoints max
     */
    public int getHP()
    {
        return healthPoints;
    }
    
    /**
     * Setter for healthPoints
     */
    public void setHP(int i)
    {
        if (i<0){i=0;}
        healthPoints=i;
    }
    
    /**
     * Return the name of the player
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Boolean to know if the player is armed or not
     * 
     * by default a player is not armed
     */
    public boolean getArmed()
    {
            return armed;
    }
        
    /**
     * Add a weapon in the inventory
     * @param weapon the weapon to add
     */
    /*public void addWeapon(Weapon weapon)
    {      
        if (canTakeWeapon())
        {
            armed = true;
            inventory.add(weapon);
            nbItemInInventory++;
        }
        else
        {
            System.out.println("Vous etes déjà armé");
        }                
    }*/
    
    /**
     * Add an Keys in the inventory
     * @param keys the keys to add
     */
    /*public void addKeys(Keys keys)
    {      
        if (canTakeItem())
        {
            inventory.add(keys);
            nbItemInInventory++;
        }
        else
        {
            System.out.println("Votre inventaire est plein.");
        }                
    }*/
    
    /**
     * Add a potion in the inventory
     * @param potion the potion to add
     */
    /*public void addPotion(Potion potion)
    {      
        if (canTakeItem())
        {
            inventory.add(potion);
            nbItemInInventory++;
        }
        else
        {
            System.out.println("Votre inventaire est plein.");
        }                
    }*/
    
    /**
     * Add a miscellaneous in the inventory
     * @param item the item to add
     */
    public void addItem(Item item)
    {
        if (nbItemInInventory<sizeInventory)
        {
            if (item instanceof Weapon)
            {
                if(!armed)
                {
                   inventory.add(item);
                   nbItemInInventory++; 
                   armed = true;
                }
                else
                {           
                System.out.println("Vous avez déjà une arme");
                }
            }
            else
            {
                inventory.add(item);
                nbItemInInventory++;
            }
            
        }
        else
        {
            System.out.println("Votre inventaire est plein.");
        }
    }
    
    /**
     * Print the content of the inventory in the terminal
     */
    public void showInventory()
    {
        for (Item i : inventory)
        {
            System.out.println(i);
        }
    }
    
    /**
     * Save the steps made by the players
     * It saves only important events which follow the major quest
     * 
     * @param text the string to add
     */
    public void addEntryDiary(String text)
    {
        diary.add(text);
    }
    
    /**
     * Print the diary in the terminal
     */
    public void showDiary()
    {
        for (String i : diary)
        {
            System.out.println(i);
        }
    }
    
    /**
     * Heal the player.
     * @param Potion a potion
     */
    public void heal(Potion potion)
    {
        if ((healthPoints+ potion.getHeal()) > 10)
        {
          healthPoints=10;  
        }
        else
        {
        healthPoints+=potion.getHeal();
        }
        potion.isUsed();
    }
    
    /**
     * Set the boolean isValid by checking if the object Player is correctly created
     * name : 3+ characters
     * healthpoints : >= 0
     */
    public boolean testValidity()
    {
        if(name.length()>=3 && healthPoints>=0){return true;}
        else{return false;}
    }
    
    /**
     * Return true if the player can take an item which is not a weapon (=inventory not full)
     */
    /*public boolean canTakeItem()
    {
        if (nbItemInInventory<sizeInventory && canTakeWeapon()){
                return true;
            }
            else{return false;}
    }*/
    
    /**
     * Return true if the player can take a weapon ð inventory not full and player not armed)
     */
    /*public boolean canTakeWeapon()
    {
        if (!armed){
            if (nbItemInInventory<sizeInventory){
                return true;
            }
            else{return false;}
        }
        else{return false;}       
    }*/
    
    /**
     * Return the weapon used by the player
     * if no any weapon, return the weapon nakedFist
     */
    public Weapon getWeapon()
    {
        for (Item i : inventory)
        {
            if (i instanceof Weapon)
            {
                    Weapon j = (Weapon) i; 
                    return j;
            }
        }
        Weapon nakedFist = new Weapon("Naked fist", "Natural weapon, not the best", 1, 65 );
        return nakedFist;
    }
    
    /**
     * Remove an item in the inventory
     * @param item the item to remove
     */
    public boolean removeItem(Item item)
    {
        for (Item i : inventory)
        {
            if (i==item)
            {
                inventory.remove(i);
                nbItemInInventory --;
                return true;
                
            }
        }
        return false;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    
}
