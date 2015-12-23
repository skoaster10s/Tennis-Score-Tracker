
/**
 * Write a description of class ScoreCalculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private int sets;
    private String name;

    /**
     * Constructor for objects of class ScoreCalculator
     */
    public Player(String str)
    {
        sets = 0;
        name = str;
    }
    
    public int getSet()
    {
        return sets;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void winSet()
    {
        sets++;
    }
}
