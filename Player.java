
/** Player class represents one player who has a name and number of sets won
 * @author Sean Ko 
 */
public class Player
{
    private int sets;
    private String name;

    /**
     * Constructor for a Player.
     * Initializes a player to the given name 
     * and zero as the number of sets won.
     * @param String Name of the player
     */
    public Player(String str)
    {
        sets = 0;
        name = str;
    }
    
    /**
    * @return Number of sets won
    */
    public int getSet()
    {
        return sets;
    }

    /**
    * @return Name of the player
    */
    public String getName()
    {
        return name;
    }
    
    /**
    * Increments the number of sets won by 1
    */
    public void winSet()
    {
        sets++;
    }
}
