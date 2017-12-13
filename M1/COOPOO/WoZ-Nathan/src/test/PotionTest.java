package test;

import core.Potion;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PotionTest.
 *
 * @author  group 4
 * @version 09/11/2017
 */
public class PotionTest
{
    private Potion examplePotion;
    
    /**
     * Default constructor for test class PotionTest
     */
    public PotionTest()
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
        examplePotion = new Potion("Super Potion","Récupère 50 HP",50);
    }
    
    /**
     * test if the potion name is uncorrect. 
     */
    @Test
    public void testBadPotionName()
    {
        assertEquals("Poison", examplePotion.getName());
    }
    
    /**
     * test if the potion name is correct.
     */
    @Test
    public void testGoodPotionName()
    {
        assertEquals("Super Potion", examplePotion.getName());
    }
    
    /**
     * Test if the name is correct or not. The name should be > 3 characters.
     * Test if the description is correct or not. The description should be > 5 characters.
     * Test if the number of HP that the potion gives is > 0.
     */
    @Test
    public void testPotionValidity()
    {
        //PotionName test
        Potion badPotion1 = new Potion("Po", "Récupère 50 HP", 50);
        assertEquals(false, badPotion1.testValidity());
        
        //PotionDescription test
        Potion badPotion2 = new Potion("Super Potion", "50HP", 50);
        assertEquals(false, badPotion2.testValidity());
        
        //PotionHint test
        Potion badPotion3 = new Potion("Super Potion", "Récupère 50 HP", 0);
        assertEquals(false, badPotion3.testValidity());
        
        
        Potion goodPotion1 = new Potion("Super Potion", "Récupère 50 HP", 50);
        assertEquals(true, goodPotion1.testValidity());
    }
    
    /**
     * Test if the potion description is uncorrect.
     */
    @Test
    public void testBadPotionDescription()
    {
        assertEquals("enlève 50 HP", examplePotion.getDescription());
    }
    
    /**
     * test if the potion description is correct.
     */
    @Test
    public void testGoodPotionDescription()
    {
        assertEquals("Récupère 50 HP", examplePotion.getDescription());
    }
    
    /**
     * Test if the number of HP that the potion gives is uncorrect.
     */
    @Test
    public void testBadPotionGetHeal()
    {
        assertEquals(12, examplePotion.getHeal());
    }
    
    /**
     * TTest if the number of HP that the potion gives is correct.
     */
    @Test
    public void testGoodPotionGetHeal()
    {
        assertEquals(50, examplePotion.getHeal());
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
