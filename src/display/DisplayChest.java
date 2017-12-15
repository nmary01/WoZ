package display;

import core.Item;
import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class allows user to enter the code to open a chest
 * A window is opened and the code entered by the player is compared to the real code 
 * 
 * @author WoZGrp4
 */
public class DisplayChest extends JFrame {
    
    /**
     * The displayChest call the main class Display
     * A little window appears to enter the code
     * You have to put your code into the textarea and to validate it
     * 
     * @param d Display
     * @throws HeadlessException 
     */
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
