package display;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class represent the display of the game
 *
 * @author (WOZGrp4)
 * @version (21/11/2017)
 */

public class Display extends JFrame
{
    private JMenuBar menuBar;
    private JMenu menu1, menu2, menu3, menu4, menu5;
    private JButton examiner, prendre, oui, non, parler, inventaire, journal, haut, bas, nord, sud, est, ouest; 
    private JPanel beginning,display,interaction,action,inventory,moves,direction,floor,diary_hp,item,player;
    private JLabel textArea;

    /**
     * Constructeur d'objets de classe Interface
     */
    public Display() {
       
    	//chargement des images
        //Icon i = new ImageIcon(".\\pictures\\bal.png");
    	
        //Image i = new ImageIcon(this.getClass().getResource("/pictures/bal.png")).getImage();
        ImageIcon icon = new ImageIcon(getClass().getResource("..\\pictures\\bal.png"));
        Image i = icon.getImage();
        Image newing = i.getScaledInstance(1000, 500, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon (newing);
        JLabel image_manoir = new JLabel(icon);
        //image_manoir.setSize(200, 100);
        //JButton image_manoir = new JButton(new ImageIcon("\\pictures\\bal.png"));
  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //Menu
        menuBar = new JMenuBar();
       
        menu1 = new JMenu("Game");
        menuBar.add(menu1);
        menu2 = new JMenu("Last action");
        menuBar.add(menu2);
        menu3 = new JMenu("Inventory");
        menuBar.add(menu3);
        menu4 = new JMenu("Name of the room");
        menuBar.add(menu4);
        menu5 = new JMenu("Map");
        menuBar.add(menu5);
        
        
        // JPanel
        	//début de jeu
        beginning = new JPanel();
        beginning.setLayout(new BorderLayout());
        
            //Partie de Gauche
        display = new JPanel(); // Partie Image et Interaction
        //display.setLayout(new GridLayout(2,1));
        
        interaction = new JPanel(); // partie de gauche : comprend l'image et l'interaction
        interaction.setLayout(new GridLayout(2,1));
        
             
        action = new JPanel(); // comprend tous les boutons suivant : examiner, prendre, oui, non, parler
        //action.setLayout(new GridLayout(1,5));
        action.setLayout(new BoxLayout(action,BoxLayout.X_AXIS));
        
            //Partie de Droite
        player = new JPanel(); // Partie inventaire, moves et diary_hp
        player.setLayout(new GridLayout(3,1));
            
        inventory = new JPanel(); // comprend le bouton inventaire et les 4 images des objets
        inventory.setLayout(new GridLayout(2,1));
        
        item = new JPanel(); // contient les images d'objets
        item.setLayout(new GridLayout(2,2));
        
        moves = new JPanel(); // comprend toutes les flèches de déplacement (direction et étage)
        moves.setLayout(new GridLayout(1,2));
        
        floor = new JPanel(); // comprend les flèches haut et bas pour les étages
        floor.setLayout(new GridLayout(2,1));
        
        direction = new JPanel(); // comprend les 4 flèches de direction : N/S/E/W
        direction.setLayout(new BorderLayout());
        
        diary_hp = new JPanel(); // comprend le bouton journal et affiche l'image des HP
        diary_hp.setLayout(new GridLayout(2,1));
              
        // boutons
            // interactions
        examiner = new JButton("Examine");
        examiner.setPreferredSize(new Dimension (40,40));
        prendre = new JButton("Take");
        parler = new JButton("Speak to");
        oui  = new JButton("Yes");
        non = new JButton("No");
            
            // journal
        journal = new JButton("Diary");
            
            // déplacement
        nord = new JButton("North");
        sud = new JButton("South");
        est = new JButton("East");
        ouest = new JButton("West");
            
            // étage
        haut = new JButton("Go upstairs");
        bas = new JButton("Go downstairs");
            
            // inventaire
        inventaire = new JButton("Inventory");
        
        // labels
        textArea = new JLabel("Text Area");
        
        // ajout bouton/Panel dans Panel
        action.add(examiner);
        action.add(prendre);
        action.add(oui);
        action.add(parler);
        action.add(non);
     
        inventory.add(inventaire);
        
        diary_hp.add(journal);
        
        floor.add(haut);
        floor.add(bas);
        
        direction.add(nord);
        direction.add(sud);
        direction.add(est);
        direction.add(ouest);
        
        // griser les boutons
        nord.setEnabled(false);
        sud.setEnabled(false);
        est.setEnabled(false);
        ouest.setEnabled(false);
        haut.setEnabled(false);
        bas.setEnabled(false);
                 
        //gestion Panel
        //beginning.add(image_manoir, BorderLayout.CENTER);
        display.add(image_manoir);
        display.add(interaction);
        interaction.add(textArea);
        interaction.add(action);
        player.add(inventory);
        player.add(moves);
        player.add(diary_hp);
        inventory.add(item);
        moves.add(floor);
        moves.add(direction);
        this.add(menuBar, BorderLayout.NORTH);
        this.add(display, BorderLayout.WEST);
        this.add(player, BorderLayout.EAST);
        this.add(beginning, BorderLayout.NORTH);

        
        this.setSize(1600,900);
        this.setVisible(true);        
    }  
   
}
