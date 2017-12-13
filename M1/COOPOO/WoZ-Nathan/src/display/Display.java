package display;

import core.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

/**
 * This class represent the display of the game
 *
 * @author (WOZGrp4)
 * @version (30/11/2017)
 */
public class Display extends JFrame {

    private JMenuBar menuBar;
    private JMenu menu1, menu2, menu3, menu4, menu5;
    private JButton examiner, prendre, drop, use, parler, journal, haut, bas, nord, sud, est, ouest;
    private JPanel display, interaction, action, inventory, moves, direction, floor, diary_hp, item, player, textAreaLayout, image, northPanel, southPanel, westPanel, eastPanel, upPanel, downPanel, journalPanel;
    private JLabel hp, inventaire, screen;
    private JTextArea textArea;
    private String text;
    private BufferedImage background;
    private DisplaySpeak displaySpeak;
    private DisplayTake displayTake;
    private DisplayDrop displayDrop;
    private DisplayUse displayUse;
    private JScrollPane scroll;
    private Game g;
    private static boolean step2_done= false, step1_done = false, step3_done=false;
    private static boolean /*exam_step1,*/ exam = false;
    private static boolean exam_step1;
    //private JScrollPane textAreaLayout;
    //private Image img;

    /**
     * Constructeur d'objets de classe Display
     */
    public Display(Game g) {
        this.g = g;
        //text = "Welcome to the WOLOLO World. J'ai décidé de parler français parce que c'est plus simple pour tout le monde. Alors la, comme tu peux le voir, l'interface est pas terminée mais ca avance peu à peu. Peut-être qu'un jour elle sera focntionnelle";
    }

    public void generateDisplay(Game g) {

        //step1_done = false;
        //exam =false;
        Display frame = this;
        this.setTitle("AMONG US");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //this.getContentPane().setBackground(new Color(0,0,0));

        displaySpeak = new DisplaySpeak(frame);
        displaySpeak.setVisible(false);

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

        image = new JPanel();
        image.setLayout(new BoxLayout(image, BoxLayout.X_AXIS));
        //image.setOpaque(true);
        //image.setBounds(0,0,0,0);

        textAreaLayout = new JPanel();
        //textAreaLayout = new JScrollPane(textArea);
        //textAreaLayout.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textAreaLayout.setLayout(new BoxLayout(textAreaLayout, BoxLayout.X_AXIS));
        textAreaLayout.setSize(new Dimension(800, 125));

        interaction = new JPanel(); // partie de gauche : comprend l'interaction
        interaction.setLayout(new BoxLayout(interaction, BoxLayout.X_AXIS));
        interaction.setPreferredSize(new Dimension(1142, 125));
        //interaction.setMaximumSize(new Dimension(1142,100));
        //interaction.setBounds(0,0, 50, 50);

        action = new JPanel(); // comprend tous les boutons suivant : examiner, prendre, oui, use, parler
        action.setLayout(new BoxLayout(action, BoxLayout.Y_AXIS));

        //Partie de Droite
        player = new JPanel(); // Partie inventaire, moves et diary_hp
        player.setLayout(new GridLayout(3, 1));

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
        examiner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                step1();
                if (!step1_done) {
                    exam_step1 = true;
                    textArea.append(">You are in the poolroom.\n>Mr Taylor was founded by the Chambermaid this morning when she came to clean the poolroom. Her scream attracted everyone.\n>You notice that it is missing a pool cue and you find a strange red necklace nearby the pool.\n>You examine the dead body and you notice a circular wound with the same diameter of a pool cue and some splinters of wood at the bottom of the neck.\n"
                        + ">Take advantage that everyone is here to question them.\n");
                }
                else textArea.append("> You are looking for something interesting in this room");
                if (!g.getCurrent().isExamined()){
                    g.getCurrent().setExamined(true);
                    //remove(prendre);
                    remove(action);
                    prendre.setEnabled(g.getCurrent().isExamined());
                    interaction.add(action);
                }

                updatePlayer(g);


            }
        });

        prendre = new JButton("Take");
        //prendre.setEnabled(g.getCurrent().isExamined());
        prendre.setEnabled(false);
        prendre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                displayTake = new DisplayTake(frame);
            }
        });

        parler = new JButton("Speak to");
        parler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                displaySpeak = new DisplaySpeak(frame);
                if (step1_done && g.getCurrent().getDescription().equals("Cellar")){
                    step2_done=true;
                    g.getBanquetinghall().modifyExit("south");
                }
                if(step2_done && g.getCurrent().getDescription().equals("Dancing Room")){
                    step3_done=true;
                    g.getPlayer().setHP(g.getPlayer().getHP() - 1);
                    updatePlayer(g);
                    
                }
            }
        });

        drop = new JButton("Drop");

        drop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                displayDrop = new DisplayDrop(frame);
            }
        });

        use = new JButton("Use");
        use.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                displayUse = new DisplayUse(frame);
            }
        });

        // journal
        journal = new JButton("Diary");
        journal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            }
        });

        journalPanel = new JPanel();
        journalPanel.setLayout(new BoxLayout(journalPanel, BoxLayout.X_AXIS));
        journalPanel.setSize(100, 100);
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
        nord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (Exit i : g.getCurrent().getListExits()) {
                    if (i.getDirection().equals("north")) {
                        if (i.getOpened()) {
                            Command co = new Command("go", "north");
                            g.goRoom(co);
                            deplacement(g);
                            textArea.append("> You are in the " + g.getCurrent().getDescription() + "\n");
                            break;
                        } else {
                            textArea.append(i.getTextBlock() + "\n");
                            break;
                        }
                    }
                }

            }
        });

        sud = new JButton(south);
        sud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (Exit i : g.getCurrent().getListExits()) {
                    if (i.getDirection().equals("south")) {
                        if (i.getOpened()) {
                            Command co = new Command("go", "south");
                            g.goRoom(co);
                            deplacement(g);
                            textArea.append("> You are in the " + g.getCurrent().getDescription() + "\n");
                            break;
                        } else {
                            textArea.append(i.getTextBlock() + "\n");
                            break;
                        }
                    }
                }
            }
        });

        est = new JButton(east);
        est.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (Exit i : g.getCurrent().getListExits()) {
                    if (i.getDirection().equals("east")) {
                        if (!step1_done) {
                            step1();
                        }
                        if (step1_done) {
                            if (i.getOpened()) {
                                for (PNG png:g.getListOfPNG())
                                {
                                    if(png.getName().equals("Bob Taylor")){
                                        png.setRoom(g.getCellar());
                                        png.setText("Ok, I go to tidy my toys");
                                    }
                                    if(png.getName().equals("Nina Taylor")){
                                        png.setRoom(g.getBanquetinghall());
                                        png.setText("These are my brother toys. Find him to tidy his toys");
                                    }
                                    if(png.getName().equals("Ms Cunningham")){
                                        png.setRoom(g.getDancingroom());
                                        png.setText("Oh, good morning ! I am happy to see you. Unlike the dark atmosphere of the mansion it is a beautiful weather outside. \n"
                                    + "I hope your investigation is progressing well. I am scared that the murderer is still at liberty. I cannot sleep properly since the night of the murder. Ah ! I know, you are going to dance with me. It will make me think of something other than this dark situation. \n"
                                    + "Sorry I walked on your feet. Do I hurt you not too much ? I can be very clumsy.");
                                    }
                                    
                                }
                                Command co = new Command("go", "east");
                                g.goRoom(co);
                                deplacement(g);
                                textArea.append("> You are in the " + g.getCurrent().getDescription() + "\n");
                                if(g.getCurrent().getDescription().equals("Banqueting hall"))
                                {
                                    textArea.append("> When you opened the poolroom door, you shut on a toy so you lose one HealthPoint");
                                    g.getPlayer().setHP(g.getPlayer().getHP() - 1);
                                    updatePlayer(g);
                                }
                                break;
                            } else {
                                textArea.append(i.getTextBlock() + "\n");
                                break;
                            }
                        } else {
                            textArea.append(i.getTextBlock() + "\n");
                        }

                    }
                }

            }

        }
        );

        ouest = new JButton(west);

        ouest.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                for (Exit i : g.getCurrent().getListExits()) {
                    if (i.getDirection().equals("west")) {
                        if (i.getOpened()) {
                            Command co = new Command("go", "west");
                            g.goRoom(co);
                            deplacement(g);
                            textArea.append("> You are in the " + g.getCurrent().getDescription() + "\n");
                            break;
                        } else {
                            textArea.append(i.getTextBlock() + "\n");
                            break;
                        }
                    }
                }
            }
        }
        );

        // étage
        haut = new JButton(upstairs);
        haut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (Exit i : g.getCurrent().getListExits()) {
                    if (i.getDirection().equals("up")) {
                        if (i.getOpened()) {
                            Command co = new Command("go", "up");
                            g.goRoom(co);
                            deplacement(g);
                            textArea.append("> You are in the " + g.getCurrent().getDescription() + "\n");
                            break;
                        } else {
                            textArea.append(i.getTextBlock() + "\n");
                            break;
                        }
                    }
                }
            }
        });

        bas = new JButton(downstairs);
        bas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (Exit i : g.getCurrent().getListExits()) {
                    if (i.getDirection().equals("down")) {
                        if (i.getOpened()) {
                            Command co = new Command("go", "down");
                            g.goRoom(co);
                            deplacement(g);
                            textArea.append("> You are in the " + g.getCurrent().getDescription() + "\n");
                            break;
                        } else {
                            textArea.append(i.getTextBlock() + "\n");
                            break;
                        }
                    }
                }
            }
        });

        // inventaire
        inventaire = new JLabel("Inventory", SwingConstants.LEFT);
        inventaire.setFont(new Font("SansSerif", Font.PLAIN, 30));

        // labels
        setTextArea(text);

        //scroll = new JScrollPane(textArea);
        //scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        hp = new JLabel("HP: " + Integer.toString(g.getPlayer().getHP()));
        hp.setFont(new Font("SansSerif", Font.PLAIN, 40));

        // ajout bouton/Panel dans Panel
        action.add(examiner);
        action.add(prendre);
        action.add(drop);
        action.add(parler);
        action.add(use);

        //inventory.add(inventaire);
        inventory.setBorder(BorderFactory.createTitledBorder("Inventory"));

        JPanel items = new JPanel();
        items = getItems(g);
        //items.setBackground(new Color(63,52,43));

        //player.setBackground(new Color(71,58,48));
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
        screen = new JLabel(new ImageIcon(background));
        image.add(screen);
        //image.add(image_manoir);
        //stackImages.add(image);
        //display.add(stackImages);
        display.add(image);
        display.add(interaction);
        interaction.add(textAreaLayout);
        interaction.add(action);
        textAreaLayout.add(scroll);
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

    public void setTextArea(String s) {
        textArea = new JTextArea(s);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    public JPanel getItems(Game g) {
        JPanel items = new JPanel();
        items.setLayout(new GridLayout(2, 2));

        for (Item i : g.getPlayer().getInventory()) {
            JLabel item = new JLabel(i.getName());
            if (i instanceof Weapon) {
                item.setToolTipText("<html>" + i.getDescription() + "<br>Damage: " + ((Weapon) i).getDamage() + "<br>Accuracy: " + ((Weapon) i).getAccuracy() + "</html>");
            } else if (i instanceof Potion) {
                item.setToolTipText("<html>" + i.getDescription() + "<br>Heal: " + ((Potion) i).getHeal() + "</html>");
            } else if (i instanceof Keys) {
                item.setToolTipText("<html>" + i.getDescription() + "<br>Room: " + ((Keys) i).getKeyRoom() + "<br>Exit: " + ((Keys) i).getKeyExit().getDirection() + "</html>");
            } else {
                item.setToolTipText(i.getDescription());
            }
            items.add(item);
        }

        return items;
    }

    public BufferedImage displayRoom(Game g) {

        ImageIcon icon = new ImageIcon(getClass().getResource(g.getCurrent().getImage()));
        Image i = icon.getImage();
        Image newing = i.getScaledInstance(1142, 643, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newing);
        //JLabel image_manoir = new JLabel(icon);
        BufferedImage background = new BufferedImage(newing.getWidth(null), newing.getHeight(null), BufferedImage.TYPE_INT_RGB);
        background.getGraphics().drawImage(newing, 0, 0, null);

        int x = 20;
        int y = 200;

        for (PNG png : g.getListOfPNG()) {
            if (png.getRoom().getDescription() == (g.getCurrent().getDescription())) {
                if (png.getName().equals("Bob Taylor")) {
                    ImageIcon imgI = new ImageIcon(getClass().getResource(png.getPicture()));
                    Image img = imgI.getImage();
                    background.getGraphics().drawImage(img, x, y + 110, img.getWidth(null) / 2, img.getHeight(null) / 2, null);
                    x += 100;
                } else if (png.getName().equals("Nina Taylor")) {
                    ImageIcon imgI = new ImageIcon(getClass().getResource(png.getPicture()));
                    Image img = imgI.getImage();
                    background.getGraphics().drawImage(img, x - 20, y + 75, img.getWidth(null) / 2, img.getHeight(null) / 2, null);
                    x += 100;
                } else {
                    ImageIcon imgI = new ImageIcon(getClass().getResource(png.getPicture()));
                    Image img = imgI.getImage();
                    background.getGraphics().drawImage(img, x, y, img.getWidth(null) / 2, img.getHeight(null) / 2, null);
                    x += 100;
                }

            }
        }
        return background;
    }

    public void deplacement(Game g) {
        
        remove(image);
        remove(action);
        //remove(interaction);
        remove(display);
        remove(moves);
        remove(direction);
        remove(floor);
        remove(menuBar);
        remove(player);
        remove(this);
        remove (prendre);
        //exam = false;
        background = displayRoom(g);
        generateDisplay(g);
        System.out.println(g.getCurrent().isExamined());
    }

    public void updatePlayer(Game g) {
        remove(moves);
        remove(direction);
        remove(floor);
        remove(player);

        background = displayRoom(g);
        generateDisplay(g);
    }

    public Game getG() {
        return g;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public DisplaySpeak getDisplaySpeak() {
        return displaySpeak;
    }

    public void step1() {
        boolean speakToAll = true;
        for (boolean b : displaySpeak.getListOfBoolean()) {
            System.out.println(b);
            if (!b) {
                speakToAll = false;
            }
        }
        System.out.println("-----------------------------------------");
        if (speakToAll && exam_step1) {
            g.getCurrent().modifyExit("east");
            step1_done = true;
        }
    }

}
