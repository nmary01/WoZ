import java.util.*;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes modified by group3
 * @version 2006.03.30
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        // -1
        Room anteroom,ritualroom,cellar;
        // RDC
        Room hall,banquetinghall,dancingroom,poolroom,kitchen,garden,well,gardenerhut; 
        // +1 
        Room livingroom,library,laboratory,corridor,bedroom,guestbedroom,bathroom;
        // +2
        Room attic;
        
        // create the rooms
            //RDC//
        hall = new Room("Hall");
        banquetinghall = new Room ("Banqueting hall");
        poolroom = new Room ("PoolRoom");
        dancingroom = new Room ("Dancing Room");
        kitchen = new Room("Kitchen");
        garden = new Room("Garden");
        well = new Room("Well");
        gardenerhut = new Room("Gardener hut");
            //Fin RDN //
            
            //-1//
        anteroom = new Room("Anteroom");
        ritualroom = new Room("Ritual Room");
        cellar = new Room("Cellar");
            // FIN -1//
            // +1 //
        livingroom = new Room("Living Room"); 
        library = new Room ("Library");
        laboratory = new Room("Laboratory");
        corridor= new Room("Corridor");
        bathroom = new Room("Bathroom");
        bedroom = new Room("Bedroom");
        guestbedroom = new Room("Guest Bedroom"); 
            //FIN +1 //
            //+2//
        attic = new Room("Attic");
            //Fin +2//
        //Fin create room //    
            
        // initialise room exits
        //RDC
        hall.setExits("north",garden, false);
        hall.setExits("south",banquetinghall, true);  
        banquetinghall.setExits("north",hall, true);
        banquetinghall.setExits("south",dancingroom, false);
        banquetinghall.setExits("east",kitchen, true);
        banquetinghall.setExits("west",poolroom, true);
        poolroom.setExits("east",banquetinghall, false);
        dancingroom.setExits("north",banquetinghall, true);
        dancingroom.setExits("up",livingroom, true);
        kitchen.setExits("west",banquetinghall, true);
        kitchen.setExits("down",cellar, true);
        garden.setExits("south",hall, true);
        garden.setExits("north",well, true);
        garden.setExits("east",gardenerhut, true);
        well.setExits("south",garden, true);
        gardenerhut.setExits("west",garden, true);
        gardenerhut.setExits("down",anteroom, false);
        //-1//
        anteroom.setExits("south",ritualroom, true);
        anteroom.setExits("up",gardenerhut, false);
        anteroom.setExits("west",cellar, true);
        ritualroom.setExits("north",anteroom, true);
        cellar.setExits("up",kitchen, true);
        //cellar.setExits("east", anteroom, false); To unlock
        //+1//
        livingroom.setExits("down",dancingroom, true);
        livingroom.setExits("north",library, true);
        livingroom.setExits("west",corridor, true);
        library.setExits("south",livingroom, true);
        //library.setExits("north",laboratory, false); To unlock
        laboratory.setExits("south",library, true);
        corridor.setExits("north",bathroom, true);
        corridor.setExits("south",bedroom, false);
        corridor.setExits("east",livingroom, true);
        corridor.setExits("west",guestbedroom, true);
        corridor.setExits("up",attic, false);
        bathroom.setExits("south",corridor, true);
        bedroom.setExits("north",corridor, true);
        guestbedroom.setExits("east",corridor, true);
        attic.setExits("down",corridor, true);
        
        currentRoom = poolroom;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }


    
    /**
     * Print all the exists of the room.
     *
     */
    private void printExits ()
    {
        System.out.println("You are in the " + currentRoom.getDescription());
        System.out.print("Exits: ");
        for(Exit e : currentRoom.getListExits()) {
            System.out.println(e.getDirection());
        }   
    }
    
     /**
     * Print out the opening message for the player.
     */
    
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("You are invited to a reception at the Taylor’s mansion.");
        System.out.println("However, during the evening the dead body of Mr Taylor is found in the poolroom.");
        System.out.println("You have to solve this investigation.");
        System.out.println("But be careful the case is not simple as it seems to be.");
        System.out.println();
        System.out.println("You are currently in the " + currentRoom.getDescription());
        System.out.print("Let's start your investigation !");
        printExits();
        
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit"))
            wantToQuit = quit(command);

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
     private void goRoom(Command command) 
     {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        
        for(Exit e : currentRoom.getListExits()) {
            String key = e.getDirection();
            Room exit = e.getRoom();
        
        if(direction.equals(key)){
            nextRoom = exit;
            break;
        }
    }
    
    if (nextRoom == null) {
        
    }
    else {
        currentRoom = nextRoom;
        printExits ();
    }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
