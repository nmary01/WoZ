package core;

import java.util.*;
/**
 * Class Fight creates a fight with:
 * - a valid player
 * - a valid enemy
 *
 * @author (WoZGrp4)
 * @version (20/11/2017)
 */
public class Fight
{
    private Player player;
    private Enemy enemy;

    /**
     * Constructeur d'objets de classe Fight
     */
    public Fight(Player player, Enemy enemy)
    {
        this.player = player;
        this.enemy = enemy;
    }

    /**
     * This function calculate if the player attack will work or not
     * If the randomNumber is inferior than accuracy then the attack work
     * Else the attack does not work
     * 
     * @return boolean true if the attack work or false if the attack does not work
     */ 
    public boolean randomPlayerAccuracy()    
    {
        int randomNumber;
   
        Random rand = new Random(); 
        randomNumber = rand.nextInt(player.getWeapon().getAccuracy() - 0 + 1) + 0;
        if (randomNumber < player.getWeapon().getAccuracy())
        {
            return true;
        }
        else
        {
            return false;
        }  
    }
    
    /**
     * This function calculate if the enemy attack will work or not
     * If the randomNumber is inferior than accuracy then the attack work
     * Else the attack does not work
     * 
     * @return boolean true if the attack work or false if the attack does not work
     */ 
    public boolean randomEnemyAccuracy()    
    {
        int randomNumber;
   
        Random rand = new Random(); 
        randomNumber = rand.nextInt(enemy.getAccuracy() - 0 + 1) + 0;
        if (randomNumber < enemy.getAccuracy())
        {
            return true;
        }
        else
        {
            return false;
        }  
    }
    
    /**
     * Method attackPlayer
     * The player attacks the enemy. There is a test to know if the player hit the enemy
     */
    public void attackPlayer()
    {
        if (randomPlayerAccuracy())
        {
            enemy.setHP(enemy.getHP()-player.getWeapon().getDamage());
        } 
        else
        {
            System.out.println("Sorry. Your attack failed. Nothing happens.");
        }
    }
    
    /**
     * Method attackEnemy
     * The enemy attacks the player. There is a test to know if the enemy hit the player
     */
    public void attackEnemy()
    {
        if (randomPlayerAccuracy())
        {
            player.setHP(player.getHP()-enemy.getDamage());
        } 
        else
        {
            System.out.println("Good ! Your enemy failed");
        }
    }
    
    /**
     * Method checkHealth
     * Check the health of player and enemy to know if someone is dead.
     */
    public void checkHealth()
    {
        if(enemy.getHP() <=0)
        {
            System.out.println(player.getName()+" wins !");
        }
        else if(player.getHP()<=0)
        {
            System.out.println(enemy.getName()+" failed. Enemy wins !");
        }
    }
    
    /**
     * Method testValidity
     * Check if the player and the enemy are valids
     * @return boolean (true if the fight is valid)
     */
    public boolean testValidity()
    {
        if(player.testValidity() && enemy.testValidity())
        {   
            return true;
        }
        else
        {
            return false;
        }
    }
        
}
