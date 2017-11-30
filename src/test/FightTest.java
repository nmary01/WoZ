package test;

import core.Enemy;
import core.Fight;
import core.Player;
import core.Room;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test FightTest.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
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
public class FightTest
{
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).

    private Fight fight, fight1, fight2;
    private Player player;
    private Enemy enemy;
    private Room room;
    
    /**
     * Constructeur de la classe-test FightTest
     */
    public FightTest()
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
        // Initialisez ici vos engagements

        room = new Room("Good Room", null);
        player = new Player("Toto");
        enemy = new Enemy("Bowser","Because i'm happy", room, 2, 65, 100, null);
        fight = new Fight(player, enemy);
    }

    @Test
    public void testLooseHp()
    {
        // Player player = new Player("Nathan");
        // Enemy enemy = new Enemy("Clement","Bad people","Library");
        // Fight fight = new Fight(player, enemy);
        //assertEquals();
    }
    
    /**
     * Test a fight with a name for the player and the enemy valid
     * 
     * return true if both names are correct
     */
    @Test
    public void TestPlayerEnemyOk()
    {
        assertEquals(true, enemy.testValidity());
        // assertEquals(true, fight.testValidity()); //cas nominal
    }
    
    /**
     * Test a fight 
     * with name of player correct 
     * and with name of enemy not correct
     * 
     * return false - if the name of enemy is not correct
     */
    @Test
    public void TestPlayerOk()
    {
        
        Enemy badEnemy = new Enemy("ok","ok",room, 5, 75, 10, null);
        fight1 = new Fight(player,badEnemy);
        assertEquals(false, fight1.testValidity());
    }
    
    /**
     * Test a fight
     * with name of player not correct
     * and with name of enemy correct
     * 
     * return false - if the name of player is not correct
     */
    @Test
    public void TestEnemyOk()
    {
        Player badPlayer= new Player("ok");
        fight2 = new Fight(badPlayer,enemy);
        assertEquals(false, fight2.testValidity());
    }
    
    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
   
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
}
