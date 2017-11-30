package test;

import core.Ally;
import core.Item;
import core.Room;
import core.Weapon;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AllyTest.
 *
 * @author  group 4
 * @version 09-11-2017
 */
public class AllyTest
{
   private Ally exampleAlly;
   private Weapon weapon;
   private Room room;
   
   /**
    * Default constructor for test class AllyTest
    */
   public AllyTest()
   {
   }

   /**
    * Sets up the test fixture.
    *
    * Called before every test case method.
    */
   @Before
   public void setUp()
   {
       weapon = new Weapon("Knife","sharp blade", 3, 85);
       room = new Room("Kitchen", null);
       exampleAlly = new Ally("Chambermaid","I saw the master in the living room at 8 pm.",room , weapon, null);
   }
    
   @Test
    /**
     * Test if the item is uncorrect.
     */
    public void testBadGetItem()
    {
       Item badItem = new Item ("Cutter", "Qui ne s'émousse jamais");
       assertEquals(badItem, exampleAlly.getItem());
    }
    
    @Test
    /**
     * Test if the item is correct.
     */
    public void testGoodGetItem()
    {
       assertEquals(weapon, exampleAlly.getItem());
    }
    
     @Test
    /**
     * Test if the item is uncorrect.
     */
    public void testBadGetName()
    {
       assertEquals("Toto", exampleAlly.getName());
    }
    
     @Test
    /**
     * Test if the item is correct.
     */
    public void testGoodGetName()
    {
       assertEquals("Chambermaid", exampleAlly.getName()); 
    }
   
    
     @Test
    /**
     * Test if the room is uncorrect.
     */
    public void testBadGetRoom()
    {
       Room badRoom = new Room ("laboratory", null);
       assertEquals(badRoom, exampleAlly.getRoom());
    }

    @Test
    /**
     * Test if the room is correct.
     */
    public void testGoodGetRoom()
    {
       assertEquals(room, exampleAlly.getRoom());
    }
    
    /**
     * Test if the name is correct or not. The name should be > 3 characters.
     * Test if the text is correct or not. The text should be > 5 characters.
     * Test if the room exists.
     * Test if the item exists.
     */
    @Test
    public void testAllyValidity()
    {
        Weapon weapon = new Weapon("Knife","sharp blade", 3, 85);
        Room room = new Room("Kitchen", null);
        
        Ally goodAlly1 = new Ally("Chambermaid", "I saw the master in the living room at 8 pm.", room, weapon, null);
        assertEquals(true, goodAlly1.testValidity());
        
        //AllyName test
        Ally badAlly1 = new Ally("Ch", "I saw the master in the living room at 8 pm.", room, weapon, null);
        assertEquals(false, badAlly1.testValidity());
        
        //AllyText test
        Ally badAlly2 = new Ally("Chambermaid", "I.", room, weapon, null);
        assertEquals(false, badAlly2.testValidity());
        
        //AllyRoom test
        Room badRoom = new Room("bad", null);
        Ally badAlly3 = new Ally("Chambermaid", "I saw the master in the living room at 8 pm.", badRoom, weapon, null);
        assertEquals(false,badAlly3.testValidity());
        
        //AllyItem test
        Weapon badWeapon = new Weapon("scisors","cut",1,5);
        Ally badAlly4 = new Ally("Chambermaid", "I saw the master in the living room at 8 pm.", room, badWeapon, null);
        assertEquals(false,badAlly4.testValidity());
    }
}
