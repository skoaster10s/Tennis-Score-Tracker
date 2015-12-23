
/**
 * Write a description of class GameScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tiebreak
{
    // instance variables - replace the example below with your own
    private int points1, points2;
    private boolean isDone;

    /**
     * Constructor for objects of class GameScore
     */
    public Tiebreak()
    {
        points1 = 0;
        points2 = 0;
        isDone = false;
    }
    
    public int getPoints1()
    {
        return points1;
    }
    
    public int getPoints2()
    {
        return points2;
    }
    
    public void increment1()
    {
        points1++;
    }
    
    public void increment2()
    {
        points2++;
    }
    
    public boolean isItDone()
    {
        if( (points1 == 7 && points2 < 6) || (points2 == 7 && points1 < 6) 
            || (points1 + points2 >= 12 && Math.abs(points1 - points2) == 2))
            {
                isDone = true;
            }
        return isDone;
    }
    
    public String toString()
    {
        return "  *TB*   ||  " + points1 + "     -     " + points2 + " ||  *TB*";
    }
}
