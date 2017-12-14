/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Nathan
 */
public class DisplayDrop extends JFrame {
    
    private JPanel panel;

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
