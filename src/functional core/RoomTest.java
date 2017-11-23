

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RoomTest.
 *
 * @author  Cécile Iaegi
 * @version 09-11-2017
 */
public class RoomTest
{
    private Room room;
    /**
     * Default constructor for test class RoomTest
     */
    public RoomTest()
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
        room = new Room("Description of Laboratory");
    }
  

    @Test
    public void testRoomDescription()
    {
        //cas nominal
        assertEquals("Description of Laboratory",room.getDescription());
    }
    
    @Test
    public void testRoomDescriptionBad()
    {
        //cas nominal
        assertEquals("Description of Cellar",room.getDescription());
    }

    @Test
    public void testRoomValidity()
    {
     // RoomDescription test
     Room badRoom= new Room("abcd");
     assertEquals(false,badRoom.testValidity());
   
     Room goodRoom= new Room("abcde");
     assertEquals(true,goodRoom.testValidity());
     
    }

}
