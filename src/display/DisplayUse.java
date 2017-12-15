package display;

import core.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class allow user to see his inventory and to use an object
 * all of his items usable is created in the form of button
 * then player click on the button to use the item
 *
 * @author WoZGrp4
 */
public class DisplayUse extends JFrame {

    private JPanel panel;
    //private Display display;

    /**
     * Call the main class for display to add on the frame the list of item in the inventory
     * 
     * @param display
     * @throws HeadlessException 
     */
    public DisplayUse(Display display) throws HeadlessException {
        //this.display = display;
        DisplayUse d = this;
        this.setTitle("Use Item");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // if the inventory of the player is empty a message appears
        if (!display.getG().getPlayer().getInventory().isEmpty()) {
            
            // else we loop on the inventory to get items
            for (Item i : display.getG().getPlayer().getInventory()) {
                
                // if the item is a potion or a key : he is usable
                if (i instanceof Potion || i instanceof Keys){
                    
                // create a list of button for each potion / key
                JButton button = new JButton(i.getName());
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (i instanceof Potion) {
                            display.getG().getPlayer().heal((Potion) i);
                            display.getG().getPlayer().getInventory().remove(i);
                            d.dispose();
                            display.updatePlayer(display.getG());

                        } else {
                            // if the keys is not for the good door we send a message to the player
                            Keys j = (Keys) i;
                            if (j.getKeyRoom().equals(display.getG().getCurrent().getDescription())) {
                                display.getG().getCurrent().modifyExit(j.getKeyExit().getDirection());
                                display.getG().getPlayer().getInventory().remove(i);
                                display.getG().getPlayer().setNbItemInInventory(display.getG().getPlayer().getNbItemInInventory()-1);
                                d.dispose();
                                display.updatePlayer(display.getG());
                            } else {
                                display.getTextArea().append("This key is useless here");
                            }
                        }
                    }
                });
                panel.add(button);
                }
            }
            this.add(panel);
            this.pack();
            this.setVisible(true);
        }
        else display.getTextArea().append("> Your inventory is empty\n");
        
    }
}
