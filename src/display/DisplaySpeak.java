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
    private static boolean ms_Taylor, bob_Taylor, nina_Taylor, ms_Cunningham, mr_Cunningham, ms_Wellington, mr_Wellington, chambermaid, caretaker, valet;
    private Boolean[] listOfBoolean;
    
    public DisplaySpeak(Display f) throws HeadlessException {
    
        DisplaySpeak d=this;
        //this.setContentPane(new JLabel(new ImageIcon("..\\pictures\\Backgrounds\\papier.jpg")));
        //this.setSize(new Dimension(1000, 500));
        this.setTitle("Speak to");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.getContentPane().setBackground(new Color(0,0,0));

        this.setLayout(new FlowLayout());
        panel = new JPanel();
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setLayout(new FlowLayout());
        //panel.add(ms_Taylor);
        
        listOfBoolean = new Boolean[10];
        listOfBoolean[0]=ms_Taylor;
        listOfBoolean[1]=bob_Taylor;
        listOfBoolean[2]=nina_Taylor;
        listOfBoolean[3]=ms_Cunningham;
        listOfBoolean[4]=mr_Cunningham;
        listOfBoolean[5]=ms_Wellington;
        listOfBoolean[6]=mr_Wellington;
        listOfBoolean[7]=chambermaid;
        listOfBoolean[8]=valet;
        listOfBoolean[9]=caretaker;

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
                            case "Ms Taylor": ms_Taylor=true;listOfBoolean[0]=ms_Taylor; break;
                            case "Bob Taylor": bob_Taylor=true;listOfBoolean[1]=bob_Taylor; break;
                            case "Nina Taylor": nina_Taylor=true;listOfBoolean[2]=nina_Taylor; break;
                            case "Ms Cunningham": ms_Cunningham=true;listOfBoolean[3]=ms_Cunningham; break;
                            case "Mr Cunningham": mr_Cunningham=true;listOfBoolean[4]=mr_Cunningham; break;
                            case "Ms Wellington": ms_Wellington=true;listOfBoolean[5]=ms_Wellington; break;
                            case "Mr Wellington": mr_Wellington=true;listOfBoolean[6]=mr_Wellington; break;
                            case "Chambermaid": chambermaid=true;listOfBoolean[7]=chambermaid; break;
                            case "Valet": valet=true;listOfBoolean[8]=valet; break;
                            case "Caretaker": caretaker=true;listOfBoolean[9]=caretaker; break;
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

    public Boolean[] getListOfBoolean() {
        return listOfBoolean;
    }

    public boolean isMs_Taylor() {
        return ms_Taylor;
    }

    public boolean isBob_Taylor() {
        return bob_Taylor;
    }

    public boolean isNina_Taylor() {
        return nina_Taylor;
    }

    public boolean isMs_Cunningham() {
        return ms_Cunningham;
    }

    public boolean isMr_Cunningham() {
        return mr_Cunningham;
    }

    public boolean isMs_Wellington() {
        return ms_Wellington;
    }

    public boolean isMr_Wellington() {
        return mr_Wellington;
    }

    public boolean isChambermaid() {
        return chambermaid;
    }

    public boolean isCaretaker() {
        return caretaker;
    }

    public boolean isValet() {
        return valet;
    }
    
    
    
    
    
}
