/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import core.Item;
import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Nathan
 */
public class DisplayChest extends JFrame {
    
    
    public DisplayChest(Display d) throws HeadlessException {
        
        DisplayChest dc = this;
        this.setTitle("Safe-Chest");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        JTextField answer= new JTextField("Enter your code");
        
        JButton valid= new JButton("Validate");
        valid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            int x=Integer.parseInt(answer.getText());
            if (x==89515){d.setStep7_done(true);d.getTextArea().append("The chest is opened ! You see a disk in it\n");
                Item disk = new Item("Disk", "This disk can be used with the gramophone");
                d.getG().getCurrent().addItem(disk);}
            else{d.getTextArea().append("Wrong code...\n");}
            dispose();
            }
            
        });
        
        //String text= answer.getText();
        //System.out.println(text);
        
        this.add(answer);
        this.add(valid);
        this.pack();
        this.setVisible(true);
    }
    
    
}
