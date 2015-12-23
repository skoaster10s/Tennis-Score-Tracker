
/**
* SetScore class represents the score of one set
*
* @author Sean Ko
*/
public class SetScore
{
    private int games1, games2;
    private boolean isDone, goToTiebreak;
    private Tiebreak tiebreak;
    private int setNumber;

    /**
     * Constructor for a SetScore
     * Initializes the score of the set to 0-0,
     * false as the boolean of whether the set is done,
     * false as the boolean of whether the set is going to a tiebreak (at 6-6),
     * a new tiebreak,
     * and the set number.
     * @param int Set number
     */
    public SetScore(int num)
    {
        games1 = 0;
        games2 = 0;
        isDone = false;
        goToTiebreak = false;
        tiebreak = new Tiebreak();
        setNumber = num;
    }
    
    /**
    * @return Number of games player 1 won in the current set
    */
    public int getGames1()
    {
        return games1;
    }
    
    /**
    * @return Number of games player 2 won in the current set
    */
    public int getGames2()
    {
        return games2;
    }
    
    /**
    * @return Tiebreak
    */
    public Tiebreak getTB()
    {
        return tiebreak;
    }
    
    /**
    * Increments the set score if player 1 wins the game
    */
    public void win1()
    {
        if(!toTB())
            games1++;
        else
        {
            tiebreak.increment1(); 
            if(tiebreak.isItDone())
            {
                games1++;
            }
        }
        isItDone();
    }
    
    /**
    * Increments the set score if player 2 wins the game
    */
    public void win2()
    {
        if(toTB() == false)
            games2++;
        else
        {
            tiebreak.increment2();
            if(tiebreak.isItDone())
            {
                games2++;
            }
        }
        isItDone();
    }
    
    /**
    * Resets the score of the set
    */
    public void reset()
    {
        games1 = 0;
        games2 = 0;
        isDone = false;
    }
    
    /**
    * Sets the set number
    */
    public void setSetNumber(int n)
    {
        setNumber = n;
    }
    
    /**
    * @return True if the set score is 6-6, false if otherwise
    */
    public boolean toTB()
    {
        if(games1 == 6 && games2 == 6)
        {
            goToTiebreak = true;
        }
        return goToTiebreak;
    }
    
    /**
    * @return True if the set is done, false if it is not done
    */
    public boolean isItDone()
    {
        if( (games1 == 6 && games2 < 5) || (games1 < 5 && games2 == 6) ||
            (games1 == 5 && games2 ==7) || (games1 ==7 && games2 == 5) ||
            (games1 == 6 && games2 ==7) || (games1 ==7 && games2 == 6))
        {
            isDone = true;
        }
        return isDone;
    }
    
    /**
    * @return Text representation of the set score
    * @see ScoreTrackerTesterGUI
    */
    public String toString()
    {
        String txt =  "   " + setNumber + "     ||  " + games1 + "       -       " + games2;
        if( games1 == 6 && games2 ==6)
        {
            txt += "\n" + tiebreak.toString();
        }
        return txt;
    }
    
}
