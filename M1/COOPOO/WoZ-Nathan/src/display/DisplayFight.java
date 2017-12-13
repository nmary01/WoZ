/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;
import core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Nathan
 */
public class DisplayFight extends JFrame {

    private JPanel image, buttons;
    private Fight fight;
    private Player player;
    
    public DisplayFight(Player p, Enemy e) throws HeadlessException {
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
        this.setTitle("Fight against "+ e.getName());
        
        image=new JPanel();
        buttons=new JPanel();
        //buttons.setLayout(new FlowLayout());
        buttons.setLayout(new GridLayout(1,4));
        
        JButton attack = new JButton("Attack");
        attack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                fight.attackPlayer();
            }
        });
        
        JButton takePotion = new JButton("Take Potion");
        takePotion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                //player.heal();               
            }
        });
        
        JLabel enemyHp= new JLabel(e.getName()+"'s HP: "+Integer.toString(e.getHP()));
        JLabel playerHp= new JLabel("Your HP: "+Integer.toString(p.getHP()), SwingConstants.RIGHT);
        
        ImageIcon iBackground = new ImageIcon(getClass().getResource("..\\pictures\\Rooms\\bgFight.jpg"));
        Image i= iBackground.getImage();
        Image newing = i.getScaledInstance(800, 450, java.awt.Image.SCALE_SMOOTH);
        iBackground = new ImageIcon(newing);
        JLabel background = new JLabel(iBackground);
        
        buttons.add(enemyHp);
        buttons.add(attack);
        buttons.add(takePotion);
        buttons.add(playerHp);
        image.add(background);

        this.add(image);
        this.add(buttons);
        this.pack();
        this.setVisible(true);
    }
    
    
    
}
