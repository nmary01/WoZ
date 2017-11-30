/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nathan
 */
public class PNGButton extends JButton {

    public PNGButton() {
        ImageIcon icon = new ImageIcon(getClass().getResource("..\\pictures\\Characters\\BobTaylor.png"));
        this.setIcon(icon);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
    }    
}
