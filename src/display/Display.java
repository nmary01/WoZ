package display;

import core.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class represent the display of the game
 *
 * @author (WOZGrp4)
 * @version (21/11/2017)
 *
 *Game:
 *  instantiations rooms à modifier (remplacer null par chemin vers image)
 *  ajout getCurrent() !
 *  ajout attribut PLAYER
 *  instantiation du joueur au debut de play()
 *  getPlayer()
 *  IL FAUT MODIFIER TOUS LES ITEMS POUR QU'ILS SOIENT DES ATTRIBUTS !!!!
 * 
 *Player:
 *  Suppression des méthodes addWeapon(), addKeys(), addPotion(), canTakeWeapon(), canTakeItem()
 *  Généralisation de addItem() pour que tout fonctionne bien (ajout de une seule arme possible)
 * 
 *Display:
 *  Pleeeeeein de modif
 *  Ajustement des différents panels
 *  Création de l'inventaire (avec la méthode getItems())
 *  Ajout d'infobulles au survol sur les items
 */
public class Display extends JFrame {

    private JMenuBar menuBar;
    private JMenu menu1, menu2, menu3, menu4, menu5;
    private JButton examiner, prendre, oui, non, parler, journal, haut, bas, nord, sud, est, ouest;
    private JPanel beginning, display, interaction, action, inventory, moves, direction, floor, diary_hp, item, player, textAreaLayout, image, northPanel, southPanel, westPanel, eastPanel, upPanel, downPanel, journalPanel;
    private JLabel hp, inventaire;
    private JTextArea textArea;
    private String text;
    private JLayeredPane stackImages;
    private BufferedImage background;
    //private Image img;

    /**
     * Constructeur d'objets de classe Interface
     */
    public Display(Game g) {

        this.setTitle("AMONG US");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Set the background and add the PNG's images presents in the room 
        background = displayRoom(g);



        //Menu
        menuBar = new JMenuBar();

        menu1 = new JMenu("Game");
        menuBar.add(menu1);
        menu2 = new JMenu("Last action");
        menuBar.add(menu2);
        menu3 = new JMenu("Inventory");
        menuBar.add(menu3);
        menu4 = new JMenu(g.getCurrent().getDescription());
        menuBar.add(menu4);
        menu5 = new JMenu("Map");
        menuBar.add(menu5);

        // JPanel

        //Partie de Gauche
        display = new JPanel(); // Partie Image et Interaction
        display.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));
        display.setSize(500, 900);

        //stackImages = new JLayeredPane();
        //stackImages.setBounds(0,0,0,0);
        
        image = new JPanel();
        image.setLayout(new BoxLayout(image, BoxLayout.X_AXIS));
        //image.setOpaque(true);
        //image.setBounds(0,0,0,0);

        textAreaLayout = new JPanel();
        textAreaLayout.setLayout(new BoxLayout(textAreaLayout, BoxLayout.X_AXIS));     

        interaction = new JPanel(); // partie de gauche : comprend l'image et l'interaction
        interaction.setLayout(new BoxLayout(interaction, BoxLayout.X_AXIS));


        action = new JPanel(); // comprend tous les boutons suivant : examiner, prendre, oui, non, parler
        action.setLayout(new BoxLayout(action, BoxLayout.Y_AXIS));


        //Partie de Droite
        player = new JPanel(); // Partie inventaire, moves et diary_hp
        player.setLayout(new GridLayout(3,1));
        //player.setLayout(new BoxLayout(player, BoxLayout.Y_AXIS));

        inventory = new JPanel(); // comprend le bouton inventaire et les 4 images des objets
        inventory.setLayout(new BoxLayout(inventory, BoxLayout.Y_AXIS));

        item = new JPanel(); // contient les images d'objets
        item.setLayout(new GridLayout(2, 2));

        moves = new JPanel(); // comprend toutes les flèches de déplacement (direction et étage)
        moves.setLayout(new BoxLayout(moves, BoxLayout.Y_AXIS));
        moves.setBorder(BorderFactory.createTitledBorder("Move"));

        floor = new JPanel(); // comprend les flèches haut et bas pour les étages
        floor.setLayout(new GridLayout(1, 2));

        direction = new JPanel(); // comprend les 4 flèches de direction : N/S/E/W
        direction.setLayout(new BorderLayout());

        diary_hp = new JPanel(); // comprend le bouton journal et affiche l'image des HP
        diary_hp.setLayout(new GridLayout(2, 1));
        diary_hp.setBorder(BorderFactory.createTitledBorder("Information"));

        // boutons
        // interactions
        examiner = new JButton("Examine");
        prendre = new JButton("Take");
        parler = new JButton("Speak to");
        oui = new JButton("Yes");
        non = new JButton("No");

        // journal
        journal = new JButton("Diary");
        journalPanel = new JPanel();
        journalPanel.setLayout(new BoxLayout(journalPanel, BoxLayout.X_AXIS));
        journalPanel.setSize(100,100);
        journalPanel.add(journal);

        // déplacement
        ImageIcon north = new ImageIcon(getClass().getResource("..\\pictures\\Directions\\north.png"));
        Image north2 = north.getImage();
        Image newNorth = north2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        north = new ImageIcon(newNorth);

        ImageIcon south = new ImageIcon(getClass().getResource("..\\pictures\\Directions\\south.png"));
        Image south2 = south.getImage();
        Image newSouth = south2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        south = new ImageIcon(newSouth);

        ImageIcon east = new ImageIcon(getClass().getResource("..\\pictures\\Directions\\east.png"));
        Image east2 = east.getImage();
        Image newEast = east2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        east = new ImageIcon(newEast);

        ImageIcon west = new ImageIcon(getClass().getResource("..\\pictures\\Directions\\west.png"));
        Image west2 = west.getImage();
        Image newWest = west2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        west = new ImageIcon(newWest);

        ImageIcon upstairs = new ImageIcon(getClass().getResource("..\\pictures\\Directions\\upstairs.png"));
        Image upstairs2 = upstairs.getImage();
        Image newUpstairs = upstairs2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        upstairs = new ImageIcon(newUpstairs);

        ImageIcon downstairs = new ImageIcon(getClass().getResource("..\\pictures\\Directions\\downstairs.png"));
        Image downstairs2 = downstairs.getImage();
        Image newdownstairs = downstairs2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        downstairs = new ImageIcon(newdownstairs);

        northPanel = new JPanel();
        northPanel.setMaximumSize(new Dimension(50, 50));
        southPanel = new JPanel();
        southPanel.setMaximumSize(new Dimension(50, 50));
        westPanel = new JPanel();
        westPanel.setMaximumSize(new Dimension(50, 50));
        eastPanel = new JPanel();
        eastPanel.setMaximumSize(new Dimension(50, 50));

        
        upPanel = new JPanel();
        upPanel.setPreferredSize(new Dimension(100, 100));
        
        downPanel = new JPanel();
        downPanel.setPreferredSize(new Dimension(100, 100));

        nord = new JButton(north);
        sud = new JButton(south);
        est = new JButton(east);
        ouest = new JButton(west);
        

        // étage
        haut = new JButton(upstairs);
        bas = new JButton(downstairs);


        // inventaire
        inventaire = new JLabel("Inventory", SwingConstants.LEFT);
        inventaire.setFont(new Font("SansSerif", Font.PLAIN, 30));

        // labels
        text = "Welcome to the WOLOLO World. J'ai décidé de parler français parce que c'est plus simple pour tout le monde. Alors la, comme tu peux le voir, l'interface est pas terminée mais ca avance peu à peu. Peut-être qu'un jour elle sera focntionnelle";
        textArea = new JTextArea(text);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setMaximumSize(new Dimension(900,150));

        hp = new JLabel("HP: "+Integer.toString(g.getPlayer().getHP()));
        hp.setFont(new Font("SansSerif", Font.PLAIN, 40));

        // ajout bouton/Panel dans Panel
        action.add(examiner);
        action.add(prendre);
        action.add(oui);
        action.add(parler);
        action.add(non);

        //inventory.add(inventaire);
        inventory.setBorder(BorderFactory.createTitledBorder("Inventory"));
        
        JPanel items = new JPanel();
        items = getItems(g);


        diary_hp.add(journalPanel);
        diary_hp.add(hp);

        upPanel.add(haut);
        downPanel.add(bas);
        floor.add(upPanel);
        floor.add(downPanel);

        northPanel.add(nord);
        southPanel.add(sud);
        westPanel.add(ouest);
        eastPanel.add(est);

        direction.add(northPanel, BorderLayout.NORTH);
        direction.add(southPanel, BorderLayout.CENTER);
        direction.add(eastPanel, BorderLayout.EAST);
        direction.add(westPanel, BorderLayout.WEST);
        
        
                
        

        // griser les boutons
        setMoveButtons(g);

        //gestion Panel
        //ImageIcon ij = new ImageIcon(background);
        JLabel screen = new JLabel(new ImageIcon(background));
        image.add(screen);
        //image.add(image_manoir);
        //stackImages.add(image);
        //display.add(stackImages);
        display.add(image);
        display.add(interaction);
        interaction.add(textAreaLayout);
        interaction.add(action);
        textAreaLayout.add(textArea);
        player.add(inventory);
        player.add(moves);
        player.add(diary_hp);
        inventory.add(items);
        moves.add(direction);
        moves.add(floor);
        this.add(menuBar, BorderLayout.NORTH);
        this.add(display, BorderLayout.WEST);
        this.add(player, BorderLayout.CENTER);

        //this.setSize(1600, 900);
        this.pack();
        this.setVisible(true);
    }

    public void setMoveButtons(Game g) {
        nord.setEnabled(false);
        sud.setEnabled(false);
        est.setEnabled(false);
        ouest.setEnabled(false);
        haut.setEnabled(false);
        bas.setEnabled(false);
        for (Exit exits : g.getCurrent().getListExits()) {
            if (exits.getDirection() == "north") {
                nord.setEnabled(true);
            }

            if (exits.getDirection() == "south") {
                sud.setEnabled(true);
            }

            if (exits.getDirection() == "west") {
                ouest.setEnabled(true);
            }

            if (exits.getDirection() == "east") {
                est.setEnabled(true);
            }
            
            if (exits.getDirection() == "up") {
                haut.setEnabled(true);
            }
            
            if (exits.getDirection() == "down") {
                bas.setEnabled(true);
            }
            

        }
    }
    
    public void setTextArea(String s)
    {
        text=s;
    }

    public JPanel getItems (Game g)
    {
        JPanel items = new JPanel();
        items.setLayout(new GridLayout(2, 2));
        
        for (Item i : g.getPlayer().getInventory())
        {
            JLabel item = new JLabel(i.getName());
            if (i instanceof Weapon){
                item.setToolTipText("<html>"+i.getDescription()+"<br>Damage: "+((Weapon) i).getDamage()+"<br>Accuracy: "+((Weapon) i).getAccuracy()+"</html>");
            }
            else if (i instanceof Potion){
                item.setToolTipText("<html>"+i.getDescription()+"<br>Heal: "+((Potion) i).getHeal()+"</html>");
            }
            else if (i instanceof Keys){
                item.setToolTipText("<html>"+i.getDescription()+"<br>Room: "+((Keys) i).getKeyRoom()+"<br>Exit: "+((Keys) i).getKeyExit().getDirection()+"</html>");
            }
            else{item.setToolTipText(i.getDescription());}
            items.add(item);
        }
        
        return items;
    }
    
    public BufferedImage displayRoom(Game g)
    {
        
        ImageIcon icon = new ImageIcon(getClass().getResource(g.getCurrent().getImage()));
        Image i = icon.getImage();
        Image newing = i.getScaledInstance(1142, 643, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newing);
        //JLabel image_manoir = new JLabel(icon);
        BufferedImage background = new BufferedImage(newing.getWidth(null), newing.getHeight(null),BufferedImage.TYPE_INT_RGB);
        background.getGraphics().drawImage(newing, 0, 0, null);
        
        int x= 50;
        int y=300;
        
        for (PNG png: g.getListOfPNG())
        {
            if (png.getRoom().getDescription()==(g.getCurrent().getDescription()))
            {
                ImageIcon imgI = new ImageIcon(getClass().getResource(png.getPicture()));
                Image img = imgI.getImage();
                background.getGraphics().drawImage(img, x,y, img.getWidth(null)/2, img.getHeight(null)/2, null);
                x+=50;
            }
        }
        return background;
    }
    
}

