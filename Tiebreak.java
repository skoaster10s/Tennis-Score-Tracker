
/**
 * Tiebreak class represents one tiebreak
 *
 * @author Sean Ko 
 */
public class Tiebreak
{
    private int points1, points2;
    private boolean isDone;

    /**
     * Constructor for a Tiebreak.
     * Initializes the score of the tiebreak to 0-0,
     * and false as the boolean of whether the tiebreak is done.
     */
    public Tiebreak()
    {
        points1 = 0;
        points2 = 0;
        isDone = false;
    }
    
    /**
    * @return Number of points player 1 has in the current tiebreak
    */
    public int getPoints1()
    {
        return points1;
    }
    
    /**
    * @return Number of points player 2 has in the current tiebreak
    */
    public int getPoints2()
    {
        return points2;
    }
    
    /**
    * Increments the score of the tiebreak if player 1 wins the point
    */
    public void increment1()
    {
        points1++;
    }
    
    /**
    * Increments the score of the tiebreak if player 2 wins the point
    */
    public void increment2()
    {
        points2++;
    }
    
    /**
    * @return True if tiebreak is done, false if the tiebreak is not done
    */
    public boolean isItDone()
    {
        if( (points1 == 7 && points2 < 6) || (points2 == 7 && points1 < 6) 
            || (points1 + points2 >= 12 && Math.abs(points1 - points2) == 2))
            {
                isDone = true;
            }
        return isDone;
    }
    
    /**
    * @return Text representation of the tiebreak score
    * @see ScoreTrackerTesterGUI
    */
    public String toString()
    {
        return "  *TB*   ||  " + points1 + "     -     " + points2 + " ||  *TB*";
    }
}
