
package display;
import java.awt.*;
import core.PNG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * During the game we have to speak with some characters to have some clues and unlock some steps
 * to speak with these characters we have to know which are in the current room
 * a boolean is associated to a character to know if the player has spoken to a character
 * 
 * @author WoZGrp4
 */
public class DisplaySpeak extends JFrame{
    
    private JPanel panel;
    private Display display;
   // private JButton ms_Taylor, bob_Taylor, nina_Taylor, ms_Cunningham, mr_Cunningham, ms_Wellington, mr_Wellington, chambermaid, valet, gardener;
    //private ArrayList<JButton> listOfButtons;
    private static boolean ms_Taylor, bob_Taylor, nina_Taylor, ms_Cunningham, mr_Cunningham, ms_Wellington, mr_Wellington, chambermaid, caretaker, valet;
    private Boolean[] listOfBoolean;
    
    /**
     * Call the main class for display to add on the frame the list of all characters in the room
     * 
     * @param f
     * @throws HeadlessException 
     */
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
        
        // list of characters with a boolean to know if the player speak with the character
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
            // creation of the list of character 
            for (PNG png:f.getG().getListOfPNG())
            {
                // display only character in the room : the description of the room and the character must be the same
                if ((png.getRoom().getDescription())==(f.getG().getCurrent().getDescription()))
                {
                    JButton button= new JButton(png.getName());
                    button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt)
                    {
                        // display the text of the character
                        System.out.println(png.getText());
                        f.getTextArea().append(png.getName()+": "+png.getText()+"\n");
                        d.dispose();
                        // switch the boolean when we spoke with the character
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

    // This section is only boolean function to know if the player spoke with a character
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
