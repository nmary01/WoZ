package display;
import core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.DefaultCaret;

/**
 * This class allows user to make a fight against an enemy 
 * When a fight begin, a new frame is created with two possible action for the player : attack or take a potion
 * We can see the player's HP and them for the enemy
 * A little textArea is at the bottom of the frame to indicate if the player touch his enemy 
 * 
 * @author WoZGrp4
 */
public class DisplayFight extends JFrame {

    private JPanel image, buttons, textAreaLayout;
    private Fight fight;
    private Player player;
    private JLabel enemyHp, playerHp;
    private JTextArea textArea;
    private JScrollPane scroll;
    private Enemy enemy;
    private boolean win;
    private Display d;
    
    /**
     * Constructor of the class displayFight
     * 
     * @param p player
     * @param e enemy
     */
    public DisplayFight(Player p, Enemy e) {
        player=p;
        enemy=e;
    }
    
    /**
     * Major class of the displayFight
     * Manage the frame and all associated elements
     * 
     * @param d display
     */
    public void displayFight(Display d) {
        
        this.d=d;
        
        DisplayFight frame = this;
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
        //this.setTitle("Fight against "+ enemy.getName());
        
        textArea=new JTextArea();
        fight= new Fight(player,enemy);        
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
                updateFrame(player, enemy);
                fight.attackPlayer();
                if (fight.randomPlayerAccuracy()){
                    textArea.append("You hit your enemy !\n");
                    if(fight.endFight()){
                        dispose();
                        //d.getG().setCurrentRoom(d.getG().getLivingroom());
                        //d.setVisible(true);
                        //d.deplacement(d.getG());
                        //d.updatePlayer(d.getG());
                        //d.generateDisplay(d.getG());
                        d.getTextArea().append("> Congrats, you won the fight !\n");
                    }
                }
                else textArea.append("You missed your attack...\n");
                
                //updateFrame(player, e);
                //this.add(buttons);
                fight.attackEnemy();
                if (fight.randomEnemyAccuracy()){
                    textArea.append("Your enemy hits you...\n");
                    if(fight.endFight()){
                        dispose();
                        //DisplayGO go= new DisplayGO();
                        fight.loose();
                    }
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
        
        enemyHp= new JLabel(enemy.getName()+"'s HP: "+Integer.toString(enemy.getHP()));
        playerHp= new JLabel("Your HP: "+Integer.toString(player.getHP()), SwingConstants.RIGHT);
        
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
        this.toFront();
    }
    
    /**
     * This method is used to refresh the frame for the fight
     * 
     * @param p player
     * @param e enemy
     */
    public void updateFrame(Player p, Enemy e)
    {
        remove(buttons);
        remove(enemyHp);
        remove(playerHp);
        remove(image);
        remove(textAreaLayout);
        remove(textArea);
        
        displayFight(d);
    }
    
    /**
     * 
     * @param s 
     */
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

    /**
     * Getter to know the background 
     * 
     * @return 
     */
    public JPanel getImage() {
        return image;
    }

    /**
     * Getter to know the player and his caracteristics
     * 
     * @return 
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Getter to know the number of HP for the player
     * 
     * @return 
     */
    public JLabel getPlayerHp() {
        return playerHp;
    }

    /**
     * Getter to know the enemy
     * 
     * @return 
     */
    public Enemy getEnemy() {
        return enemy;
    }

    /**
     * Function to know if the player win the fight
     * 
     * @return win  
     */
    public boolean isWin() {
        return win;
    }
    
    
}