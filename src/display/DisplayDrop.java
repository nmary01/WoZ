package display;

import core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class allows to drop an item in the current room
 * The player choose the item to drop in his inventory in the form of a list of button
 * The item is take off in the inventory
 * Later, the player will have the choice to get back the item in the same place that it drop it
 * 
 * @author WoZGrp4
 */
public class DisplayDrop extends JFrame {
    
    private JPanel panel;

    /**
     * Call the main class display to add on the frame the list of item dropable 
     * 
     * @param display
     * @throws HeadlessException 
     */
    public DisplayDrop(Display display) throws HeadlessException {
        
        DisplayDrop d = this;
        this.setTitle("Drop Item");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        if (!display.getG().getPlayer().getInventory().isEmpty())
        {
            for (Item i : display.getG().getPlayer().getInventory()) {
                JButton button = new JButton(i.getName());
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        display.getG().getCurrent().addItem(i);
                        display.getG().getPlayer().getInventory().remove(i);
                        display.getG().getPlayer().setNbItemInInventory(display.getG().getPlayer().getNbItemInInventory()-1);
                        if (i instanceof Weapon){display.getG().getPlayer().setArmed(false);}
                        d.dispose();
                        display.updatePlayer(display.getG());
                    }
                });
                panel.add(button);
            }
            this.add(panel);
            this.pack();
            this.setVisible(true);
        }
        else {
            display.getTextArea().append("> Your inventory is empty\n");
        }
    }
    
    
    
}
