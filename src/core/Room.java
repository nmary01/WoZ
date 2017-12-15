package core;

import java.util.*;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west, upstairs, downstairs.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  (WoZGrp4)
 * @version (20/11/2017)
 */



public class Room 
{
    //Description of the room and room's picture
    private String description, image;
    //The map of exits of the room.
    private List<Exit> mapRoom;
    //List of items of the room
    private List<Item> listOfItems;
    //Boolean examined : if the room is examined by the player
    //Boolean isValid : 
    private boolean isValid, examined;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     * @param image the room's picture.
     */
    public Room(String description, String image) 
    {
        mapRoom  = new ArrayList<Exit>();
        listOfItems = new ArrayList<Item>();
        this.description = description;
        isValid=testValidity();
        this.image = image;
        this.examined=false;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param direction direction of the exit
     * @param room room that the player can go inside
     * @param boolean opened if the exit is locked or not
     * @param textBlock text which informs the player if the exit is locked
     */
    public void setExits(String direction, Room room, boolean opened, String textBlock) 
    {
       mapRoom.add(new Exit(direction, room, opened, textBlock));
    }

    /**
     * Accessor for the description
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    
    /**
     * Method getListExits
     *
     * @return the list of exits for the room
     */
    public List<Exit> getListExits(){
        return mapRoom;
    }
    
    
    /**
     * Method addItem
     * Add an item in the room
     * @param i an item to add in the room
     */
    public void addItem(Item i){
        listOfItems.add(i);
    }
    
    
    /**
     * Method getListOfItems
     *
     * @return the list of items in the room
     */
    public List<Item> getListOfItems(){
        return listOfItems;
    }
    
    /**
     * Method modifyExit
     * @param direction The direction we want to modify
     */
    public void modifyExit(String direction)
    {
        for (Exit i : mapRoom){
            if (i.getDirection()==direction){
                i.changeExitState();}
        }
    }

    /**
     * Method testValidity
     * The description must be 5+ characters
     * @return a boolean (true if the room is valid)
     */
    public boolean testValidity()
    {
        if (description.length() >=5){return true;}
        else{return false;}
    }
    
    /**
     * Accessor for the room's image
     * @return room's picture
     */
    public String getImage()
    {
        return image;
    }

    /**
     * 
     * @return the boolean examined
     */
    public boolean isExamined() {
        return examined;
    }

    /**
     * 
     * @param examined 
     */
    public void setExamined(boolean examined) {
        this.examined = examined;
    }
    
    
}

