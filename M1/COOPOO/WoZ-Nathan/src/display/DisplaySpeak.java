/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;
import java.awt.*;
import core.PNG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private boolean ms_Taylor, bob_Taylor, nina_Taylor, ms_Cunningham, mr_Cunningham, ms_Wellington, mr_Wellington, chambermaid, gardener, valet;
    private ArrayList<Boolean> listOfBoolean;
    
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
                        switch(png.getName())
                        {
                            case "Ms Taylor": ms_Taylor =true; break;
                            case "Bob Taylor": bob_Taylor =true; break;
                            case "Nina Taylor": nina_Taylor =true; break;
                            case "Ms Cunningham": ms_Cunningham =true;break;
                            case "Mr Cunningham": mr_Cunningham =true;break;
                            case "Ms Wellington": ms_Wellington =true;break;
                            case "Mr Wellington": mr_Wellington =true; break;
                            case "Chambermaid": chambermaid=true;break;
                            case "Gardener": gardener=true; break;
                            case "Valet": valet=true;break;
                            default: f.getTextArea().append("Error PNG boolean \n"); break;
                        }
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

    public ArrayList<Boolean> getListOfBoolean() {
        return listOfBoolean;
    }
    
    
    
}
