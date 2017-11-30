package test;

import core.Exit;
import core.Keys;
import core.Room;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class KeysTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KeysTest
{
    private Keys exampleKey;
    private Room room;
    private Exit exit;
    
    /**
     * Default constructor for test class KeysTest
     */
    public KeysTest()
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
        room = new Room("Library", null);
        exit= new Exit("north", room, false);
        exampleKey = new Keys("Library key","Open the library", exit);
    }

    public void testKeyRoom()
    {
        assertEquals("Library", exampleKey.getKeyRoom());
    }
    
    @Test
    public void testKeyName()
    {
        assertEquals("Nope",exampleKey.getName());
    }
    
    @Test
    public void testKeyDescription()
    {
        assertEquals("Open somewhere",exampleKey.getDescription());
    }
    
    @Test
    public void testKeyExit()
    {
        Exit exitTest = new Exit("south",room,false);
        assertEquals(exitTest, exampleKey.getKeyExit());
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
