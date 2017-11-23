

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NeutralTest.
 *
 * @author  (Gp4 WoZ)
 * @version (09/11/2017)
 */
public class NeutralTest
{
    private Neutral neutre;
    private Room room;

    /**
     * Default constructor for test class NeutralTest
     */
    public NeutralTest()
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
        room = new Room("Library");
        neutre = new Neutral("Henry","I think a saw some kind of bear rat in the backyard",room);
    }
    /**
     * Tests if the name is correct or not. 
     * Name should be > 3 characters
     */
    @Test
    public void testNeutralName()
    {
        assertEquals(true, neutre.testValidity()); // cas nominal
        Neutral badNeutre = new Neutral("Ru","aaaaaaa",room); // nom trop court
        assertEquals(false, badNeutre.testValidity()); 

    }
    
    /**
     * Tests if the text is correct or not. 
     * Name should be > 5 characters
     */
    @Test
    public void testNeutralText()
    {
        assertEquals(true, neutre.testValidity()); // cas nominal
        Neutral badNeutre2 = new Neutral("Henry","aaa",room); // nom trop court
        assertEquals(false, badNeutre2.testValidity()); 
    }
    
    /**
     * Tests if the room is correct or not. 
     */
    @Test
    public void testNeutralRoom()
    {
        assertEquals(true, neutre.testValidity()); // cas nominal
        Room badRoom = new Room("kit");
        Neutral badNeutre3 = new Neutral("","aaaaaaa", badRoom); // nom trop court
        assertEquals(false, badNeutre3.testValidity()); 
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
