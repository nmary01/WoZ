

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test EnnemyTest.
 *
 * @author  (Grp4WoZ)
 * @version (9/11/2017)
 *
 * Les classes-test sont documentées ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basées sur le document Š 2002 Robert A. Ballance intitulé
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associés aux classes à tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le męme paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque méthode Test à exécuter.  Il peut y avoir
 * plus d'une méthode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ découvrira automatiquement (par introspection) les méthodes
 * Test de votre classe Test et générera la TestSuite conséquente.
 * Chaque appel d'une méthode Test sera précédé d'un appel de setUp(),
 * qui réalise les engagements, et suivi d'un appel à tearDown(), qui les
 * détruit.
 */
public class EnemyTest
{
    private Enemy goodEn; // Ennemy with fields well filled
    private Room room;
    
    /**
     * Constructeur de la classe-test EnnemyTest
     */
    public EnemyTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {
        room = new Room ("La seule pièce du jeu");
        goodEn = new Enemy("Good", "Premier boss", room,1,1,100);
    }

    /**
     * Test the getter of healthPoints
     */
    @Test
    public void testgetHP()
    {
        Enemy enemy = new Enemy("Captain", "blabla", room,1,1,1);
        assertEquals(10, enemy.getHP());
    }
    
    /**
     * Test the getter of the name
     */
    @Test
    public void testgetName()
    {
       Enemy enemy = new Enemy("Captain", "blabla", room,1,1,20);
       assertEquals("bibi", enemy.getName());
    }
    
    /**
     * Test the getter of the text
     */
    @Test
    public void testgetText()
    {
        Enemy enemy = new Enemy("Captain", "blabla", room,3,3,30);
        assertEquals("bla", enemy.getText());
    }
    
    /**
     * Test the getter of the room
     */
    @Test
    public void testgetRoom()
    {
        Enemy enemy = new Enemy("Captain", "blabla", room,2,2,40);
        assertEquals("room", enemy.getRoom());
    }
    
    /**
     * Test if the name has 3+ characters
     */
    @Test
    public void testName()
    {
        assertEquals(true,goodEn.testValidity());
        Enemy badEn1= new Enemy("Jo", "Premier boss", room,1,1,10);
        assertEquals(false, badEn1.testValidity());
    }
    
    /**
     * Test if the test has 5+ characters
     */
    @Test
    public void testText()
    {
        assertEquals(true, goodEn.testValidity());
        Enemy badEn2= new Enemy("Good", "boss", room,2,2,30);
        assertEquals(false, badEn2.testValidity());
    }
    
    /**
     * Test if the room in which the ennemy is is valid
     */
    @Test
    public void testRoom()
    {
        assertEquals(true, goodEn.testValidity());
        Room badRoom = new Room (" ");
        Enemy badEn3 = new Enemy("Good","Premier boss", badRoom,3,3,10);
        assertEquals(false, badEn3.testValidity());
    }
    
    /**
     * Test the healthPoints of the ennemy: >= 0 
     */
    @Test
    public void testHP()
    {
        assertEquals(true, goodEn.testValidity());
        Enemy badEn4 = new Enemy("Bad Ennemy", "Premier boss", room,4,4,20);
        badEn4.setHP(-3);
        assertEquals(false, badEn4.testValidity());
    }
    
    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
    }
}
