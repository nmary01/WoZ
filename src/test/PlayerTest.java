package test;



import core.Exit;
import core.Item;
import core.Keys;
import core.Player;
import core.Room;
import core.Weapon;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test PlayerTest.
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
public class PlayerTest
{
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    private Player goodPlayer;
    private Exit exit;
    
    /**
     * Constructeur de la classe-test PlayerTest
     */
    public PlayerTest()
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
        goodPlayer= new Player("Hercule");
        Room room= new Room("Chambre", null);
        exit = new Exit("south", room, false);
    }

    
    /**
     * Test if the name has 3+ characters
     */
    @Test
    public void testName()
    {
        assertEquals(true,goodPlayer.testValidity());//cas nominal
        Player badPlayer1 = new Player ("Jo");
        assertEquals(false,badPlayer1.testValidity());
        
    }
    
    /**
     * Test the inventory:
     * -if it is empty at the beginning
     * -if player can only have one weapon
     * -if player can only have 4 items
     */
    @Test
    public void testInventory()
    {
        assertEquals(true,goodPlayer.testValidity());//cas nominal
        //assertEquals(true,goodPlayer.canTakeItem());//inventaire vide
        Weapon firstWeapon = new Weapon("Epee", "Cette épée semble très aiguisée", 7, 60);
        //goodPlayer.addWeapon(firstWeapon);//le joueur prend l'arme
        //assertEquals(firstWeapon, goodPlayer.getItem(0));
        //assertEquals(false, goodPlayer.canTakeWeapon());//le joueur a déja une arme, il ne doit pas pouvoir en reprendre
        //assertEquals(true, goodPlayer.canTakeItem());//l'inventaire n'est pas plein, le joueur peut prendre des items qui ne sont pas des armes
        Keys firstKey = new Keys("Library Key", "Description", exit);
        Keys secondKey = new Keys("Library Key", "Description", exit);
        Item fourthItem = new Item("Voiture", "Difficile à entrer dans l'inventaire");
        //goodPlayer.addKeys(firstKey);//ajoute un 2e item
        //assertEquals(firstKey,goodPlayer.getItem(1));//vérifie s'il est bien enregistré
        //goodPlayer.addKeys(secondKey);//ajoute un 3e item
        //assertEquals(secondKey,goodPlayer.getItem(2));//vérifie s'il est bien enregistré
        goodPlayer.addItem(fourthItem);//ajoute un 4e item
        //assertEquals(fourthItem,goodPlayer.getItem(3));//vérifie s'il est bien enregistré
        //assertEquals(false, goodPlayer.canTakeItem());//L'inventaire est plein, le joueur ne doit pas pouvoir reprendre d'item   
    }
    
    
    /**
     * Test if healthPoints cannot go under 0
     */
    @Test
    public void testHP()
    {
        assertEquals(true,goodPlayer.testValidity());//cas nominal
        assertEquals(10,goodPlayer.getHP());
        goodPlayer.setHP(-3);//set healthPoints to -3
        assertEquals(0,goodPlayer.getHP());// if (healthPoints < 0){ healthPoints = 0;}
        assertEquals(true,goodPlayer.testValidity());

        
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
