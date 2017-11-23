

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WeaponTest.
 *
 * @author  (Grp4)
 * @version (9/11/2017)
 */
public class WeaponTest
{
    private Weapon exampleWeapon;
    
    /**
     * Default constructor for test class WeaponTest
     */
    public WeaponTest()
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
        exampleWeapon = new Weapon("bombe","arme de destruction massive",5,100);
    }

    /**
     * Test the Weapon name: its length must be >= 3 characters
     */
    @Test
    public void testWeaponName()
    {
        assertEquals(true, exampleWeapon.testValidity());//cas nominal
        Weapon badWeapon = new Weapon("bo","arme de destruction massive",5,100);
        assertEquals(false, badWeapon.testValidity());
    }
    
    /**
     * Test the Weapon damages: its value must be > 0
     */
    @Test
    public void testWeaponDmg()
    {
        assertEquals(true, exampleWeapon.testValidity());//cas nominal
        Weapon badWeapon2 = new Weapon("bombe","arme de destruction massive",-2,100);
        assertEquals(false, badWeapon2.testValidity());
    }
    
    /**
     * Test the Weapon description : its length must be >= 5 characters
     */
    @Test
    public void testWeaponDescription()
    {
        assertEquals(true,exampleWeapon.testValidity());//cas nominal
        Weapon badWeapon3 = new Weapon("bombe","arm",5,100);
        assertEquals(false, badWeapon3.testValidity());
    }
    
    /**
     * Test the Weapon accuracy : its length must be > 0 and <= 100
     */
    @Test
    public void testWeaponAcc()
    {
        assertEquals(true, exampleWeapon.testValidity());
        Weapon badWeapon4 = new Weapon("bombe","arme de destruction massive",5,-10);
        Weapon badWeapon5 = new Weapon("bombe","arme de destruction massive",5,120);
        assertEquals(false, badWeapon4.testValidity());
        assertEquals(false, badWeapon5.testValidity());
    }
    /** 
     * Test the getters 
     */
    @Test
    public void testWeaponGetters()
    {
        assertEquals(5, exampleWeapon.getDamage());
        assertEquals(100, exampleWeapon.getAccuracy());
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
