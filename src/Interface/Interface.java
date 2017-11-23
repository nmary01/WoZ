package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * This class represent the display of the game
 *
 * @author (WOZGrp4)
 * @version (21/11/2017)
 */

public class Interface extends JFrame
{
    private JMenu menu1, menu2, menu3, menu4, menu5;
    private JButton examiner, prendre, oui, non, parler, inventaire, journal, haut, bas, nord, sud, est, ouest; 
    private JFrame myFrame;
    
    /**
     * Constructeur d'objets de classe Interface
     * @param args
     */
    public static void main(String[] args) {
        
        myFrame = new JFrame("Among us");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(false);
        
        //Call the external listener
        ExternalListener el = new ExternalListener(this);
        
        //Menu
        JMenuBar menuBar = new JMenuBar();
        this.setJMenubar(menuBar);
        
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
        
        // action Listener menu
        
        
        // JPanel
        JPanel screen = new JPanel();
        screen.setLayout(new GridLayout(2,1));
        
        JPanel display = new JPanel();
        display.setLayout(new GridLayout(1,2));
        
        JPanel player = new JPanel();
        player.setLayout(new GridLayout(1,3));
        
        JPanel stuff = new JPanel();
        stuff.setLayout(new GridLayout(2,1));
        
        JPanel select = new JPanel();
        select.setLayout(new GridLayout(2,1));
        
        JPanel move = new JPanel();
        move.setLayout(new BorderLayout());
        
        // boutons
            // interactions
        examiner = new JButton("Examine");
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
        
        // action listener boutons
        examiner.addActionListener;
        prendre.addActionListener;
        parler.addActionListener;
        oui.addActionListener;
        non.addActionListener;
        journal.addActionListener;
        nord.addActionListener;
        sud.addActionListener;
        est.addActionListener;
        ouest.addActionListener;
        haut.addActionListener;
        bas.addActionListener;
        inventaire.addActionListener;
        
        // griser les boutons
        nord.setEnabled(false);
        sud.setEnabled(false);
        est.setEnabled(false);
        ouest.setEnabled(false);
        haut.setEnabled(false);
        bas.setEnabled(false);
        
        
    }

    void actionPerformedButton(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void actionPerformedMenu(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
