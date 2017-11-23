package Interface;

import java.awt.event.*;

/**
 * ExternalListener allows user to implement actionListener in few project
 * represent the link between a button and an action
 *
 * @author (WOZGrp4)
 * @version (21/11/2017)
 */
public class ExternalListener implements ActionListener
{
    private Interface game;

    /**
     * Constructor for objects of class ExternalListener
     * @param g
     */
    public ExternalListener(Interface g)
    {
        game = g;
    }

    /**
     * method to select the actionPerformed for button or menu
     * @param e
     */
    public void actionPerformed(ActionEvent e)
    {
        game.actionPerformedButton(e);
        game.actionPerformedMenu(e);
    }
}
