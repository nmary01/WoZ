/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import core.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Nathan
 */
public class DisplayUse extends JFrame {

    private JPanel panel;
    //private Display display;

    public DisplayUse(Display display) throws HeadlessException {
        //this.display = display;
        DisplayUse d = this;
        this.setTitle("Use Item");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        if (!display.getG().getPlayer().getInventory().isEmpty()) {
            for (Item i : display.getG().getPlayer().getInventory()) {
                //if((i instanceof Potion) || (i instanceof Keys)){
                if (i instanceof Potion || i instanceof Keys){
                JButton button = new JButton(i.getName());
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (i instanceof Potion) {
                            display.getG().getPlayer().heal((Potion) i);
                            display.getG().getPlayer().getInventory().remove(i);
                            d.dispose();
                            display.updatePlayer(display.getG());

                        } else {
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
