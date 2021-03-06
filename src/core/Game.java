package core;

import java.util.ArrayList;

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
    private Room anteroom,ritualroom,cellar;
    private Room hall,banquetinghall,dancingroom,poolroom,kitchen,garden,well,gardenerhut; 
    private Room livingroom,library,laboratory,corridor,bedroom,guestbedroom,bathroom;
    private Room attic;
    private Neutral mr_Taylor, ms_Taylor, ms_Cunningham;
    private Ally chambermaid, bob_Taylor, mr_Cunningham, ms_Wellington;
    private Enemy valet, caretaker, mr_Wellington, nina_Taylor, ghost,skeleton; 
    private Player player;
    private Item necklace_red, gramophone, candelar;
    private Potion potion2HP, potion6HP;
    private Weapon halberd, set_of_forks_and_knives;
    private Keys bedroomkey;
    private ArrayList<PNG> listOfPNG;
    /** 
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    public void createRooms()
    {  
        // create the rooms
            //RDC//
        hall = new Room("Hall", "..\\pictures\\Rooms\\hall.png");
        banquetinghall = new Room ("Banqueting hall", "..\\pictures\\Rooms\\banquet.png");
        poolroom = new Room ("PoolRoom", "..\\pictures\\Rooms\\billard.png");
        dancingroom = new Room ("Dancing Room", "..\\pictures\\Rooms\\bal.png");
        kitchen = new Room("Kitchen", null);
        garden = new Room("Garden", null);
        well = new Room("Well", null);
        gardenerhut = new Room("Gardener hut", null);
            //Fin RDN //
            
            //-1//
        anteroom = new Room("Anteroom", null);
        ritualroom = new Room("Ritual Room", null);
        cellar = new Room("Cellar", null);
            // FIN -1//
            // +1 //
        livingroom = new Room("Living Room", null); 
        library = new Room ("Library", null);
        laboratory = new Room("Laboratory", null);
        corridor= new Room("Corridor", null);
        bathroom = new Room("Bathroom", null);
        bedroom = new Room("Bedroom", null);
        guestbedroom = new Room("Guest Bedroom", null); 
            //FIN +1 //
            //+2//
        attic = new Room("Attic", null);
            //Fin +2//
        //Fin create room //    
            
        // initialise room exits
        //RDC
        hall.setExits("north",garden, false, "> You must explore the mansion before");
        hall.setExits("south",banquetinghall, true, null);  
        banquetinghall.setExits("north",hall, true, null);
        banquetinghall.setExits("south",dancingroom, false, "> The door is blocked by Bob's toys");
        banquetinghall.setExits("east",kitchen, true, null);
        banquetinghall.setExits("west",poolroom, true, null);
        //poolroom.setExits("east",banquetinghall, false, "> You have not finished examining the crime scene");
        poolroom.setExits("east",banquetinghall, true, "> You have not finished examining the crime scene");
        dancingroom.setExits("north",banquetinghall, true, null);
        dancingroom.setExits("up",livingroom, true, null);
        kitchen.setExits("west",banquetinghall, true, null);
        kitchen.setExits("down",cellar, true, null);
        garden.setExits("south",hall, true, null);
        garden.setExits("north",well, true, null);
        garden.setExits("east",gardenerhut, true, null);
        well.setExits("south",garden, true, null);
        gardenerhut.setExits("west",garden, true, null);
        //gardenerhut.setExits("down",anteroom, false, null);
        //-1// 
        anteroom.setExits("south",ritualroom, true, null);
        anteroom.setExits("up",gardenerhut, false, "> The door is locked. You cannot go backward");
        anteroom.setExits("west",cellar, true, null);
        ritualroom.setExits("north",anteroom, true, null);
        cellar.setExits("up",kitchen, true, null);
        //cellar.setExits("east", anteroom, false); To unlock
        //+1//
        livingroom.setExits("down",dancingroom, true, null);
        livingroom.setExits("north",library, true, null);
        livingroom.setExits("west",corridor, true, null);
        library.setExits("south",livingroom, true, null);
        //library.setExits("north",laboratory, false); To unlock
        laboratory.setExits("south",library, true, null);
        corridor.setExits("north",bathroom, true, null);
        corridor.setExits("south",bedroom, false, "> The door is locked. A key may be mandatory");
        corridor.setExits("east",livingroom, true, null);
        corridor.setExits("west",guestbedroom, true, null);
        corridor.setExits("up",attic, false, "> You see a weird lock in the ceiling");
        bathroom.setExits("south",corridor, true, null);
        bedroom.setExits("north",corridor, true, null);
        guestbedroom.setExits("east",corridor, true, null);
        attic.setExits("down",corridor, true, null);
        
        //currentRoom = poolroom;  // start game outside
        currentRoom = poolroom;
    }

    public void createCharacters()
    {
        
        
        //Room poolroom = new Room ("PoolRoom", null);
        Item item_chambermaid = new Item("Broom","The brush that she uses");
        Item item_bob_taylor = new Item("Toys","Bob Taylor toys");
        Item item_mr_Cunningham = new Item("Black hat","The nice hat of Mr Cunningham");
        Item item_ms_Wellington = new Item("Ring", "This is the wedding ring");
        
        // Neutral characters creation //
        mr_Taylor = new Neutral("Mr Taylor"," ", poolroom, "..\\pictures\\Characters\\MrTaylor2.png");
        ms_Taylor = new Neutral("Ms Taylor","Oh no ! My poor husband is dead ! What am I going to do now ?!", poolroom, "..\\pictures\\Characters\\MsTaylor2.png");
        ms_Cunningham = new Neutral("Ms Cunningham","My husband was the best old friend of Mr Taylor", poolroom, "..\\pictures\\Characters\\MsCunningham2.png");
        
        // Ally characters creation //
        chambermaid = new Ally("Chambermaid","I was in the dancing room to serve the guests.I was not with the master", poolroom, item_chambermaid, "..\\pictures\\Characters\\Chambermaid.png");
        bob_Taylor = new Ally("Bob Taylor","What happened to my father ? ", poolroom, item_bob_taylor, "..\\pictures\\Characters\\BobTaylor2.png");
        mr_Cunningham = new Ally("Mr Cunningham", "I was in my bedroom when I heard someone screaming. So I went down stairs quickly", poolroom, item_mr_Cunningham, "..\\pictures\\Characters\\MrCunningham2.png");
        ms_Wellington = new Ally("Ms Wellington", "I was in the dancing room with my husband. The chambermaid served us.", poolroom, item_ms_Wellington, "..\\pictures\\Characters\\MsWellington2.png");
        
        // Enemy characters ceration //
        valet = new Enemy("Valet","I was in the kitchen. I checked the wine delivery", poolroom,4,80,12,"..\\pictures\\Characters\\Valet2.png"); // damage =4 accuraccy = 80, HP=12
        caretaker = new Enemy("Caretaker","I was in my hut to repair the fork",poolroom, 2,20,5, "..\\pictures\\Characters\\Caretaker2.png"); // damage =2 accuraccy = 20, HP=5
        mr_Wellington = new Enemy("Mr Wellington","I was in the dancing room with my wife", poolroom, 1,10,7, "..\\pictures\\Characters\\MrWellington2.png"); // damage =1 accuraccy = 10, HP=7
        nina_Taylor = new Enemy("Nina Taylor", "I was in the library and I read a good book", poolroom, 2, 30, 8,"..\\pictures\\Characters\\NinaTaylor2.png"); // damage =2 accuraccy = 30, HP=8
        skeleton = new Enemy("Oscar the skeleton","A human skeleton", laboratory, 2, 80, 5,"..\\pictures\\Characters\\skeleton.png");
        ghost = new Enemy("Casper the Ghost", "A little green ghost", livingroom, 1, 50, 4, "..\\pictures\\Characters\\ghost.png");
        
        listOfPNG = new ArrayList();
        listOfPNG.add(ms_Taylor);
        listOfPNG.add(ms_Cunningham);
        listOfPNG.add(chambermaid);
        listOfPNG.add(bob_Taylor);
        listOfPNG.add(mr_Cunningham);
        listOfPNG.add(ms_Wellington);
        //listOfPNG.add(valet);
        //listOfPNG.add(caretaker);
        listOfPNG.add(mr_Wellington);
        listOfPNG.add(nina_Taylor);
        
        
    }
     public void createItem()
    {
        // items in poolroom //
        
       necklace_red = new Item ("Red Necklace","This is a strange red necklace");
       poolroom.addItem(necklace_red);
        
        // items in dancing room // 
        gramophone = new Item ("Gramophone","This is a nice gramophone but without disk");
        candelar = new Item("Candelar","This candelar gives light and is really beautiful");
        dancingroom.addItem(gramophone);
        dancingroom.addItem(candelar);
         
        //items in hall //
        potion2HP = new Potion("Potion 2 HP","This potion gives 2 HP to the player",2);
        hall.addItem(potion2HP);
        
        //items in corridor //
        halberd = new Weapon("Halberd","This the statut halberd. It was not a really good idea to take it",4,60);
        corridor.addItem(halberd);
        
        // items in bathroom //
        potion6HP = new Potion("Potion6HP","This potions gives 6 HP to the player",6);
        bathroom.addItem(potion6HP);
        
        // items in guestbedroom //
        Exit exit_from_corridor_to_bedroom = new Exit("south",corridor,false, null);
        bedroomkey = new Keys("Bedroom key","This key opens the master bedroom door",exit_from_corridor_to_bedroom);
        guestbedroom.addItem(bedroomkey);
        
        // items in kitchen // 
        set_of_forks_and_knives = new Weapon("Set of forks and knives","This weapon is a set of silver forks and silver knives",2,40);
        kitchen.addItem(set_of_forks_and_knives);
        
        // items in bedroom //
        Item disk = new Item("Disk","This disk can be used with the gramophone");
        bedroom.addItem(disk);
        
        Potion potion3HP = new Potion ("Potion3HP","This potions gives 3 HP to the player",3);
        bedroom.addItem(potion3HP);
        
        Item money = new Item("Money","You find 60 pounds");
        bedroom.addItem(money);
        
        // items in the library //
        Item book = new Item("Book","The title book is 'The best human friend : the cat'");
        library.addItem(book);
        
        // items in laboratory //
        Exit exit_from_corridor_to_attic = new Exit("up",corridor,false, null);
        Keys attickey = new Keys("Attic key","This key is a shaped bone from a squeletor", exit_from_corridor_to_attic); 
        laboratory.addItem(attickey);
        
        Item construction_drawing = new Item("Construction drawing","You find construction drawings. Mr Taylor planed to dig really deeply to the east of the gardener hut");
        laboratory.addItem(construction_drawing);
        
        //items in garden //
        Weapon fork = new Weapon("Fork","This fork is green and brown",3,50);
        garden.addItem(fork);
        
        Potion apple = new Potion("Apple","This apples gives you 2 HP",2);
        garden.addItem(apple);
        
        // items in gardenerhut //
        
        Item pliers = new Item("Pliers","You can cut a chain with this object");
        gardenerhut.addItem(pliers);
        
        Item ritual_cape = new Item("Ritual cape","You find a black ritual cape. It is very strange !");
        gardenerhut.addItem(ritual_cape);
        
        Item necklace_black_1 = new Item("Necklace","You find a very strange necklace ! It is a black rond necklace with the same symbol than in the ritual cape");
        gardenerhut.addItem(necklace_black_1);
        
       //items in anteroom //
       
       Potion potion4HP = new Potion("Potion4HP","This potion gives 4 HP to the player",4);
       anteroom.addItem(potion4HP);
       
       Weapon sword = new Weapon("Sword","A really sharp sword",6,70);
       anteroom.addItem(sword);
       // items in ritual room //
       
       Item red_ritual_cape = new Item("Red ritual cape", "This is a ritual cape such as in the gardener hut but this one is red. There are some blond curly hairs");
       ritualroom.addItem(red_ritual_cape);
       
       Item black_ritual_cape_1 = new Item("Black ritual cape","This is a black ritual cape");
       ritualroom.addItem(black_ritual_cape_1);
       
       Item black_ritual_cape_2 = new Item ("Black ritual cape","Another black ritual cape");
       ritualroom.addItem(black_ritual_cape_2);
       
    }
    
        
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
       
        createRooms();
        createCharacters();
        createItem();
        printWelcome();
        player = new Player("player");
        Boolean exam;
        exam = false;
       /* player.addItem(necklace_red);
        player.addItem(halberd);
        player.addItem(set_of_forks_and_knives);
        player.addItem(candelar);
        player.addItem(potion6HP);
        player.addItem(bedroomkey);*/
       
        // Step 1 : start in the poolroom //
        Boolean step1Finish;
        Boolean step2Finish;
        Boolean step3Finish;
        Boolean step4Finish;
        Boolean step5Finish;
        Boolean step6Finish;
        Boolean step7Finish;
        Boolean step8Finish;
        Boolean step9Finish;
        Boolean step10Finish;
        Boolean step11Finish;
        step1Finish = false;
        step2Finish = false;
        step3Finish = false;
        step4Finish = false;
        step5Finish = false;
        step6Finish = false;
        step7Finish = false;
        step8Finish = false;
        step9Finish = false;
        step10Finish = false;
        step11Finish = false;
        
        // All the characters are in the poolroom and the exit opens only after speak with all the characters //
        Boolean canSpeak; // player can speak with PNG
        Boolean speak_with_mr_Taylor, speak_with_ms_Taylor, speak_with_ms_Cunningham, speak_with_chambermaid, speak_with_bob_Taylor, speak_with_mr_Cunningham;
        Boolean speak_with_ms_Wellington, speak_with_valet, speak_with_caretaker, speak_with_mr_Wellington, speak_with_nina_Taylor;
        Boolean find_bob_Taylor;
        Boolean toys_not_front_of_door = null;
        Boolean firstEnter;
        firstEnter = true;
        
        canSpeak = false;
        speak_with_mr_Taylor = false;
        speak_with_ms_Taylor = false;
        speak_with_ms_Cunningham = false;
        speak_with_chambermaid = false;
        speak_with_bob_Taylor = false;
        speak_with_mr_Cunningham = false;
        speak_with_ms_Wellington = false;
        speak_with_valet = false;
        speak_with_caretaker = false;
        speak_with_mr_Wellington = false;
        speak_with_nina_Taylor = false;

        Boolean can_exam_canvas;
        can_exam_canvas = false;
        Boolean find_bedroom_key;
        find_bedroom_key = false;
        
        int safe_code, essai_code;
        safe_code = 9515;
        
        if (exam)
        {
            System.out.println("You are in the poolroom. \n"
            + "Mr Taylor was founded by the Chambermaid this morning when she came to clean the poolroom. Her scream attracted everyone. \n"
            + "You notice that it is missing a pool cue and you find a strange red necklace nearby the pool. \n"
            + "You examine the dead body and you notice a circular wound with the same diameter of a pool cue and some splinters of wood at the bottom of the neck. \n"
            + "Take advantage that everyone is here to question them.");
            canSpeak = true;
            exam = false;
            System.out.println("There are a lot of people in this room. \n" 
            +" Nina Taylor the master daughter has long brown hair. Sha has a beautiful blue dress. \n"
            +" Bob Taylor is the little son of Mr Taylor. He seems to be really nice and kind. But he is really sad. \n"
            +" Emma the Chambermaid is an old woman. She has been working for the family for a very long time. She has a black dress and a white pinny.\n" 
            +" Mr Cunningham is a grey-haired man with a beige square suit and a lie. \n"
            +" Mr Taylor had dark blond hair and a mustache. He had nice black tuxedo. \n"
            +" Mr Wellinghton is a brown-haired man with a brown square suit and a lie. \n"
            +" Ms Cunnigham is a grey-blond-haired woman with a pink dress. \n"
            +" Ms Taylor seems to be really sad. Sha has dark-brown hair and a long claret dress. \n"
            +" Ms  Wellinghton is a redhead-haired woman with a long light green dress. \n "
            +" Alfred the Valet has curly blond hair. He seems to be bother. \n"
            +" Sam the caretaker is a black-haired black man. ");
        }
        if (speak_with_mr_Taylor && speak_with_ms_Taylor && speak_with_ms_Cunningham && speak_with_chambermaid && speak_with_bob_Taylor && speak_with_mr_Cunningham
                && speak_with_ms_Wellington && speak_with_valet && speak_with_caretaker && speak_with_mr_Wellington && speak_with_nina_Taylor && exam)
        {
            canSpeak = false;
            step1Finish = true;
            poolroom.modifyExit("east");
            speak_with_mr_Taylor = false;
            speak_with_ms_Taylor = false;
            speak_with_ms_Cunningham = false;
            speak_with_chambermaid = false;
            speak_with_bob_Taylor = false;
            speak_with_mr_Cunningham = false;
            speak_with_ms_Wellington = false;
            speak_with_valet = false;
            speak_with_caretaker = false;
            speak_with_mr_Wellington = false;
            speak_with_nina_Taylor = false;
        }

        // Step 2 : banqueting hall //
        if (step1Finish)
        {
         bob_Taylor.setRoom(cellar);
         nina_Taylor.setRoom(banquetinghall);
         ms_Cunningham.setRoom(dancingroom);
            if (currentRoom == banquetinghall)
            {
             if (firstEnter)
             { 
                toys_not_front_of_door = false; //false = toys front of the door // true = toys not front of the door
                find_bob_Taylor = false;
                System.out.println(" When you opened the poolroom door, you shut on a toy so you lose one HealthPoint");
                player.setHP(player.getHP() - 1);
                firstEnter = false;
             }
                if (exam)
                {
                System.out.println("You cannot open the dancing room door now because there are a lot of toys. \n"
                                 + "Nina Taylor is next to the toys and you can speak with her. ");
                canSpeak = true;
                exam = false;
                }
                if (speak_with_nina_Taylor)
                {
                nina_Taylor.setText("These are my brother toys. Find him to tidy his toys");
                speak_with_nina_Taylor = false;
                canSpeak = false;
                }
            }
            else if (currentRoom == hall)
            {
            // Step 2 bis : Hall //
                if (exam)
                {
                System.out.println(" You are in the hall but there is nobody here. ");
                exam = false;
                }
            }
            else if (currentRoom == poolroom)
            {
                if (exam)
                {
                System.out.println("You are in the poolroom. Mr Taylor's body was removed. All the peopple are gone. \n"
                + "You do not want to stay in this room. The atmosphere has become bad. You want to leave.");
                exam = false;
                }
            }
            else if (currentRoom == kitchen)
            {
                if (exam)
                {
                    System.out.println("This is the kitchen, Bob Taylor is not here. \n"
                            + "A set of forks and knives is in one of the cupboards of the kitchen.");
                    exam = false;
                    // Recupère arme
                }
            }
            else if (currentRoom == cellar)
            {
                if (exam)
                {
                 System.out.println("You found Bob Taylor in the back of the cellar");
                 find_bob_Taylor = true;
                 exam = false;
                 canSpeak = true;
                }
                if (speak_with_bob_Taylor)
                {
                    System.out.println("You convince Bob to tidy up his toys.");
                    toys_not_front_of_door = true;
                    canSpeak = false;
                    speak_with_bob_Taylor = false;
                }
                if (toys_not_front_of_door) 
                {
                    banquetinghall.modifyExit("south");
                    step2Finish = true;
                }
            }
        if (step2Finish)
        {
        if (currentRoom == dancingroom)
        {
            if (firstEnter)
            {
            if (exam)
            {
                System.out.println("You are in an extraordinary dancing room. You perceive a gramophone on a commode. You see a beautiful candlestick and a gramophone. \n"
                + "Strangely here is no disk on the gramophone. You see Ms Cunningham beside it. She seems to want to talk with you.");
                exam = false;
                canSpeak = true;
            }
            if (speak_with_ms_Cunningham)
            {
               ms_Cunningham.setText("Oh, good morning ! I am happy to see you. Unlike the dark atmosphere of the mansion it is a beautiful weather outside. \n"
                + "I hope your investigation is progressing well. I am scared that the murderer is still at liberty. I cannot sleep properly since the night of the murder. Ah ! I know, you are going to dance with me. It will make me think of something other than this dark situation. \n"
                + "Sorry I will walk on your feet. Do I hurt you not too much ? I can be very clumsy.Oh, good morning ! I am happy to see you. Unlike the dark atmosphere of the mansion it is a beautiful weather outside. \n"
                + "I hope your investigation is progressing well. I am scared that the murderer is still at liberty. I cannot sleep properly since the night of the murder. Ah ! I know, you are going to dance with me. It will make me think of something other than this dark situation. \n"
                + "Sorry I will walk on your feet. Do I hurt you not too much ? I can be very clumsy.");
               System.out.println("You spoke and danced a lot of time with Ms Cunningham. Then you are very tired so you lose one healthpoint");
               player.setHP(player.getHP() - 1);
               canSpeak = false;
               speak_with_ms_Cunningham = false;
            }
            firstEnter = false;
            }   
          if (exam)
          {
            {
                System.out.println("You are in an extraordinary dancing room. You perceive a gramophone on a commode. You see a beautiful candlestick and a gramophone. \n"
                + "Strangely here is no disk on the gramophone. You see Ms Cunningham beside it.");
                exam = false;
                canSpeak = true;  
            }
            if (speak_with_ms_Cunningham)
            {
               ms_Cunningham.setText("Thank you. I feel better thanks to you.");
               canSpeak = false;
               speak_with_ms_Cunningham = false;
            }
          }
        }
        else if (currentRoom == livingroom)
        {
            exam = false;
            System.out.println("You ride the last step and arrive in the living room. A little green ghost appears in the room. He seems not to be kind. ");
                if (ghost.getHP() <=0) 
                {
                livingroom.modifyExit("north");
                livingroom.modifyExit("west");
                exam = true;
                if (exam)
                {
                  System.out.println("There is no useful object and there is nobody here. "); 
                  step3Finish = true;
                }
                }
        }
        
        if (step3Finish)
        {
            if (currentRoom == library)
            {
                if (exam)
                {
                    System.out.println(" A library with a lot of books is behind the door you just pushed. \n"
                    + "You see a big painting which depicts the same library where you are. There is just a difference between them. \n"
                    + "On the painting, a gramophone is pictured on a sideboard. The gramophone on the painting curiously looks like the gramophone in the dancing room. \n"
                    + "When you inspect the sideboard on the real library you see some wear marks as if an object was previously placed on it. \n"
                    + "You meet the chambermaid wanting to leave the library. She seems to want to tell you something but do not dare to approach you.");
                    canSpeak = true;
                    exam = false;
                }
                if (speak_with_chambermaid)
                {
                    chambermaid.setText("I saw Nina Taylor go to the gardener hut some nights. I do not know what she is doing there. ");
                    canSpeak = false;
                    speak_with_chambermaid = false;
                    
                }
            }
        
        else if (currentRoom == corridor)
        {
        System.out.println("There is a statut with a weapon in this corridor. You can take it weapon if you want. ");
        // recupere arme
        Boolean fight; // this variable will be initialize with the fight
            if (fight)
            {
                if (exam)
                {
                    System.out.println(" You are in a corridor. You see four doors. Only two are opened.");
                    exam = false;
                    step4Finish = true;
                }
            }
        }
        if (step4Finish)
        {
            if (currentRoom == bathroom)
            {
                if (exam)
                {
                    System.out.println(" You enter in the bathroom and you see the chambermaid treating the valet's arm. \n"
                    + " The wound looks like a rodent bite but it is much bigger than a rat. It is strange because Mr Taylor was allergic to animals. \n"
                    + "You notice that there is a potion on the furniture next to the chambermaid. She notices that you are injured. \n"
                    + "She signals to you that you can take it. "); 
                    //permet de prendre la potion
                    exam = false;
                }
                //ajout potion possible pour le joueur

            }
            if (currentRoom == guestbedroom)
            {
                if (exam)
                {
                   System.out.println(" You are in the guest bedroom. Today this bedroom is Mr&Ms Cunnigham's bedroom. Mr Cunnigham is in his bedrrom.");
                   mr_Cunningham.setRoom(guestbedroom);
                   ms_Cunningham.setText("It is strange, last time this canvas was not here.");
                   can_exam_canvas = true;
                   if (exam && can_exam_canvas)
                   {
                       System.out.println(" You find a key behind the canvas and you take it.");
                       find_bedroom_key = true;
                       player.addItem(bedroomkey);
                   } 
                   exam = false;
                }
            }
        
        if (step5Finish)
        {
            if (find_bedroom_key)
            {
                corridor.modifyExit("south");
            }
            if (currentRoom == bedroom)
            {
                if (exam)
                {
                    System.out.println("You are in the host bedroom. You see a big safe with a four number code. Ms Taylor is in her room.");
                    ms_Taylor.setText("Oh no ! I am forgetting the number code ! Please, ask to my daughter, my guests and my employees. I gave to several of them a piece of this code. ");
                    
                    if (speak_with_ms_Taylor)
                    {
                       nina_Taylor.setRoom(dancingroom);
                       nina_Taylor.setText("Bob Taylor has fallen into a 10-meter deep well and is trying to pull it up. \n " +
                                           "Each day it rises 3 meters and slides 2 meters during the night.\n" +
                                           "How many days will it take to get to the surface?");
                       ms_Wellington.setRoom(library);
                       ms_Wellington.setText("In a girl group\n" +
                                             " 70% wear a blue sweater\n" +
                                             " 75% wear blue pants\n" +
                                             " 85% wear a blue hat\n" +
                                             " 85% wear a blue coat\n" +
                                             "What is the minimum percentage of girls wearing only blue clothes?");
                       
                       bob_Taylor.setRoom(library);
                       bob_Taylor.setText("I saw my sister and my father arguing before his death.");
                    
                        mr_Cunningham.setRoom(poolroom);
                        mr_Cunningham.setText("David is 10 years old and his younger brother is half his age. \n" +
                                              "When David will be 10 times older, how old will Franck be?");
                    
                    
                    }
                }
            }
            if (step6Finish)
            {
                if (currentRoom == bedroom)
                {
                    System.out.println("Did you find the safe code? ");
                    // enter the safe code -- creation int essai_code
                    if (essai_code == safe_code)
                    {
                        System.out.println("You find the good number code, the safe door is opened. \n " +
                                "The safe contains a disk, a lot of money and a biscuits box.");
                    }
                }
                if (currentRoom == dancingroom
                        // && il doit avoir le dique dans son inventaire
                        )
                {
                    ms_Taylor.setRoom(dancingroom);
                    ms_Taylor.setText("What does this object do here, it should be in the library");
                    // player has to take the gramophone in his inventory
                }
                if (currentRoom == library 
                        // && il doit avoir le disque et le gramophone dans son inventaire
                        )
                {
                    System.out.println("You put the gramophone at its place and you insert the disk on it. \n"+
                                        " You are hearing a loud noise and a door is appearing.");  
                    library.modifyExit("north");   
                }
            if (step7Finish)
            {
                if (currentRoom == laboratory)
                {
                System.out.println("When you opened the door, a little green ghost appears and attacked you.");
                if(fight_win)
                {
                 System.out.println("The skeleton is dead. You see that one of its bone is strange. This bone seems to be carved as a key");
                // joueur doit ramasser la clef
                
                    if (exam)
                    {
                    System.out.println(" You look and the desk and you find some construction plans. It seems that Mr Taylor wanted to dig very deeply at east from the garden. It is the same place than the gardener hut. ");
                    }
                corridor.modifyExit("up");
                System.out.println("You unblock a new room. A trapdoor appears in the corridor");
                }
                }
                  if (currentRoom == attic)
                {
                    if (exam)
                    {
                        System.out.println(" You finally discover the attic. It is dark because there is only one window lighting the room. \n"
                        + " You decide to look out the window and discover a huge garden hidden by the trees when guests arrive by the entrance. ");
                        hall.modifyExit("north");
                    }
                }
            if (step8Finish)
            {
                if (currentRoom == garden)
                {
                    if (exam)
                    {
                        System.out.println(" You see a well at the north but there is a steel grid locked by a padlock.\n"
                        + "There is an apple tree next to it with only one apple on the tree. You can maybe pick up the apple and eat it now or later.\n"
                        + "");
                    }
                }
            }
                
                
            }
       
       
        
        
        /*player.addItem(necklace_red);
        player.addItem(necklace_red);
        player.addItem(necklace_red);*/
        /*     
         
         
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
        */
        }
        }
        }
        }
        }
        }
  
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
    public void printHelp() 
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
     public void goRoom(Command command) 
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
    public boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    public Room getCurrent()
    {
        return currentRoom;
    }
    
    public Player getPlayer()
    {
        return player;
    }

    public ArrayList<PNG> getListOfPNG() {
        return listOfPNG;
    }
    
    
}
