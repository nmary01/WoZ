/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;
import core.Game;
import java.awt.*;
import core.PNG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Nathan
 */
public class DisplaySpeak extends JFrame{
    
    private JPanel panel;
    private Display display;
   // private JButton ms_Taylor, bob_Taylor, nina_Taylor, ms_Cunningham, mr_Cunningham, ms_Wellington, mr_Wellington, chambermaid, valet, gardener;
    //private ArrayList<JButton> listOfButtons;
    
    public DisplaySpeak(Display f) throws HeadlessException {
    
        DisplaySpeak d=this;
        
        this.setTitle("Speak to");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //panel.add(ms_Taylor);
        
        //for (JButton butt:listOfButtons)
        //{
            for (PNG png:f.getG().getListOfPNG())
            {
                if ((png.getRoom().getDescription())==(f.getG().getCurrent().getDescription()))
                {
                    JButton button= new JButton(png.getName());
                    button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt)
                    {
                        System.out.println(png.getText());
                        f.getTextArea().append(png.getName()+": "+png.getText()+"\n");
                        d.dispose();
                    }
        });
                    
                    panel.add(button);
                }
            }
        //}
    
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
    
}
