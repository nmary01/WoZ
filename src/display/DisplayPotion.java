package display;

import core.Item;
import core.Potion;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is used for a fight
 * during a fight the player can choose to use a potion
 * if he click on the button a list with all of potion in his inventory are created 
 * the player click on the potion that he want to use
 * 
 * @author WoZGrp4
 */
public class DisplayPotion extends JFrame {
    
    private JPanel panel;

    /**
     * Call the class displayFight instead of the main class Display
     * This class is only called for fight
     * 
     * @param display
     * @throws HeadlessException 
     */
    public DisplayPotion(DisplayFight display) throws HeadlessException {
        
        DisplayPotion d = this;
        this.setTitle("Use potion");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        //we get all the item in the inventory of the player
        // if the player has no item nothing happens
        if (!display.getPlayer().getInventory().isEmpty())
        {
            // we display all item in a list of button
            for (Item i : display.getPlayer().getInventory()) {
                
                // if the item is a potion we display it
                if (i instanceof Potion){
                    JButton button = new JButton(i.getName());
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            display.getPlayer().heal((Potion) i);
                            display.getPlayer().getInventory().remove(i);
                            display.getPlayer().setNbItemInInventory(display.getPlayer().getNbItemInInventory()-1);
                            d.dispose();
                            display.updateFrame(display.getPlayer(), display.getEnemy());
                        }
                    });
                    panel.add(button);
                }
            }
            this.add(panel);
            this.pack();
            this.setVisible(true);
        }
        //else {
        //    display.getTextArea().append("> Your inventory is empty\n");
        //}
    }
    
    
    
}