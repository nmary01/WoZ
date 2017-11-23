
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MiscellaneousTest.
 *
 * @author (Gp4 WoZ)
 * @version (09/11/2017)
 */
public class ItemTest
{
    private Item item;
        
    /**
     * Default constructor for test class MiscellaneousTest
     */
    public ItemTest()
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
        item = new Item("div","object");
    }

    /**
     * Tests if the name is correct or not. 
     * Name should be > 3 characters
     */
    @Test
    public void testItemName()
    {
        assertEquals(true, item.testValidity()); // cas nominal
        Item badItem = new Item("di","object"); // nom trop court
        assertEquals(false, badItem.testValidity()); 
        Item badItem2 = new Item("di","obje"); // nom et description trop courts
        assertEquals(false, badItem2.testValidity()); 
    }
    
    /**
     * Tests if the description is correct or not. 
     * Description should be > 5 characters
    */
    @Test
    public void testItemDes()
    {
        assertEquals(true, item.testValidity()); // cas nominal
        Item badItem3 = new Item("divers","obje"); // description trop courte
        assertEquals(false, badItem3.testValidity()); 
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
