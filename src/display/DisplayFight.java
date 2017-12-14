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
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Nathan
 */
public class DisplayFight extends JFrame {

    private JPanel image, buttons, textAreaLayout;
    private Fight fight;
    private Player player;
    private JLabel enemyHp, playerHp;
    private JTextArea textArea;
    private JScrollPane scroll;
    private Enemy enemy;
    
    public DisplayFight(Player p, Enemy e) {
        player=p;
        enemy=e;
    }
    
    public void displayFight(Player p, Enemy e) {
        
        DisplayFight frame = this;
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
        this.setTitle("Fight against "+ e.getName());
        
        textArea=new JTextArea();
        fight= new Fight(p,e);
        player =p;
        
        textAreaLayout=new JPanel();
        textAreaLayout.setLayout(new BoxLayout(textAreaLayout, BoxLayout.X_AXIS));
        textAreaLayout.setPreferredSize(new Dimension(800, 50));
        setTextArea(" ");
       image=new JPanel();
        buttons=new JPanel();
        //buttons.setLayout(new FlowLayout());
        buttons.setLayout(new GridLayout(1,4));
        
        JButton attack = new JButton("Attack");
        attack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                updateFrame(player, e);
                fight.attackPlayer();
                if (fight.randomPlayerAccuracy()){
                    textArea.append("You hit your enemy !\n");
                }
                else textArea.append("You missed your attack...\n");
                
                //updateFrame(player, e);
                //this.add(buttons);
                fight.attackEnemy();
                if (fight.randomEnemyAccuracy()){
                    textArea.append("Your enemy hits you...\n");
                }
                else textArea.append("Good! Your enemy failed his attack !\n");
                fight.checkHealth();
                
                //updateFrame(player, e);
            }
        });
        
        JButton takePotion = new JButton("Take Potion");
        takePotion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                DisplayPotion dp=new DisplayPotion(frame);
                fight.attackEnemy();
            }
        });
        
        enemyHp= new JLabel(e.getName()+"'s HP: "+Integer.toString(e.getHP()));
        playerHp= new JLabel("Your HP: "+Integer.toString(p.getHP()), SwingConstants.RIGHT);
        
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
        textAreaLayout.add(scroll);

        this.add(image);
        this.add(buttons);
        this.add(textAreaLayout);
        this.pack();
        this.setVisible(true);
    }
    
    public void updateFrame(Player p, Enemy e)
    {
        remove(buttons);
        remove(enemyHp);
        remove(playerHp);
        remove(image);
        remove(textAreaLayout);
        remove(textArea);
        
        displayFight(p, e);
    }
    
    public void setTextArea(String s) {
        textArea = new JTextArea(s);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(800, 40));
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    public JPanel getImage() {
        return image;
    }

    public Player getPlayer() {
        return player;
    }

    public JLabel getPlayerHp() {
        return playerHp;
    }

    public Enemy getEnemy() {
        return enemy;
    }
    
    
}