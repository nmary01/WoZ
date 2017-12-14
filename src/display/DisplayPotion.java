/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import core.Item;
import core.Keys;
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
 *
 * @author Nathan
 */
public class DisplayPotion extends JFrame {
    
    private JPanel panel;

    public DisplayPotion(DisplayFight display) throws HeadlessException {
        
        DisplayPotion d = this;
        this.setTitle("Use potion");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        if (!display.getPlayer().getInventory().isEmpty())
        {
            for (Item i : display.getPlayer().getInventory()) {
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