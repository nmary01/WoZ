package display;

import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 * This class is used when the player loose the game
 * The main frame is closed and leave the place to another one with a game over message
 * 
 * @author WoZGrp4
 */
public class DisplayGO extends JFrame {

        /**
         * Main method of this class
         * manage the new frame with the picture
         */
	public DisplayGO(){
		
        //JFrame frame = new JFrame("Among Us");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Icon go = new ImageIcon(getClass().getResource("../pictures/Rooms/game_over.png"));
        //Image go2 = go.getImage();
        //Image newGo = go2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        //go = new ImageIcon(newGo);
        
        JLabel image=new JLabel(go);
        this.add(image);
        this.pack();
        this.setVisible(true);
        this.setTitle("YOU DIE, YOU PIECE OF SHIT");
        
        try
        {
        TimeUnit.SECONDS.sleep(5);
        System.exit(0);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
	}
	
}
