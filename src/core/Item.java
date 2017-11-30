package core;


/**
 * Class Item creates items with a name (3+ characters) and a description (5+ characters)
 *
 * @author (WoZGrp4)
 * @version (20/11/2017)
 */
public class Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    protected String name; // name of the Item
    protected String description; // description of the Item
    private boolean isValid;

    /**
     * Constructeur d'objets de classe Item
     */
    public Item(String n, String d)
    {
        name = n;
        description = d;
        isValid = testValidity();
    }
    
    
    /**
     * Method getName : accessor of name
     *
     * @return name the name of the item
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method getDescription : accessor of description
     *
     * @return description the description of the item
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Method testValidity
     * An item is valid if its name is 3+ characters and its description is 5+ characters
     * @return boolean : true = item valid
     */
    public boolean testValidity()
    {
        if(name.length()>=3 && description.length()>=5){return true;}
        else{return false;}
 
    }
    
}
