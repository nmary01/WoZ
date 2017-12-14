/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import core.Item;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Nathan
 */
public class DisplayTake extends JFrame {

    private JPanel panel;
    //private Display display;

    public DisplayTake(Display display) throws HeadlessException {
        //this.display = display;
        DisplayTake d = this;
        this.setTitle("Take Item");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        if (!display.getG().getCurrent().getListOfItems().isEmpty()) {
            for (Item i : display.getG().getCurrent().getListOfItems()) {
                JButton button = new JButton(i.getName());
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (display.getG().getPlayer().canTakeItem(i)) {
                            display.getG().getPlayer().addItem(i);
                            display.getG().getCurrent().getListOfItems().remove(i);
                        } else {
                            display.getTextArea().append("> You cannot do that because:\n-You already have a weapon\n-Your inventory is full\n");
                        }
                        d.dispose();
                        display.updatePlayer(display.getG());
                    }
                });
                panel.add(button);
            }
            this.add(panel);
            this.pack();
            this.setVisible(true);
        } else {
            display.getTextArea().append("> There is nothing interesting in this room\n");
        }

    }

}
