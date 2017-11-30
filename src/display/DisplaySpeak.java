/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;
import core.Game;
import java.awt.*;
import core.PNG;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Nathan
 */
public class DisplaySpeak extends JFrame{
    
    private JPanel panel;
   // private JButton ms_Taylor, bob_Taylor, nina_Taylor, ms_Cunningham, mr_Cunningham, ms_Wellington, mr_Wellington, chambermaid, valet, gardener;
    //private ArrayList<JButton> listOfButtons;
    
    public DisplaySpeak(Game g) throws HeadlessException {
    
    
        //ms_Taylor = new JButton();
        //ms_Taylor.setName("Miss Taylor");
        //ms_Taylor.setEnabled(false);
        
        //listOfButtons= new ArrayList<JButton>();
        //listOfButtons.add(ms_Taylor);
        //System.out.println(ms_Taylor.getName());
        this.setTitle("Speak to");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //panel.add(ms_Taylor);
        
        //for (JButton butt:listOfButtons)
        //{
            for (PNG png:g.getListOfPNG())
            {
                if ((png.getRoom().getDescription())==(g.getCurrent().getDescription()))
                //if (butt.getName()==png.getName())
                {
                    //butt.setEnabled(true);
                    JButton button= new JButton(png.getName());
                    
                    panel.add(button);
                }
            }
        //}
    
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
    
}
