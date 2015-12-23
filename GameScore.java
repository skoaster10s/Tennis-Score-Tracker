
/**
 * This class represents one game in tennis.
 * 
 * @author Sean Ko
 */
public class GameScore
{
    private int pt1, pt2;
    private boolean isDone, atDeuce;

    /**
    * Constructor for a Game Score
    * Initializes the score of the game to "Love all" (0-0), 
    * false as the boolean of whether the game is done, 
    * and false as the boolean of whether the game is at deuce.
    */
    public GameScore()
    {
        pt1 = 0;
        pt2 = 0;
        isDone = false;
        atDeuce = false;
    }

    /**
    * Increments the game score if player 1 wins the point
    */
    public void win1() 
    {
        if(!atDeuce)
        {
            if(pt1 == 0)
                pt1 = 15;
            else if(pt1 == 15)
                pt1 = 30;
            else if (pt1 == 30)
                pt1 = 40;
            else if (pt1 == 40 && pt2 == 99)
                pt2 = 40;
            else if (pt1 == 40 && pt2 < 40)
                pt1 = 100; // Designate 100 as win game
            else if (pt1 == 99)
                pt1 = 100; // Designate 100 as win game
            atDeuce();
        }
        else
        {
            pt1 = 99; //Designate 99 as AD
            atDeuce();
        }
        isItDone();
    }
    
    /**
    * Increments the game score if player 2 wins the point
    */
    public void win2()
    {
        if(!atDeuce)
        {
            if(pt2 == 0)
                pt2 = 15;
            else if(pt2 == 15)
                pt2 = 30;
            else if (pt2 == 30)
                pt2 = 40;
            else if (pt2 == 40 && pt1 == 99)
                pt1 = 40;
            else if (pt2 == 40 && pt1 < 40)
                pt2 = 100; // Designate 100 as win game
            else if (pt2 == 99)
                pt2 = 100; // Designate 100 as win game
            atDeuce();
        }
        else
        {
            pt2 = 99; //Designate 99 as AD
            atDeuce();
        }
        isItDone();
    }
    
    /**
    * @return True if the game is at deuce, false if the game is not at deuce
    */
    public boolean atDeuce()
    {
        if( pt1 == 40 && pt2 == 40)
        {
            atDeuce = true;
        }
        else
        {
            atDeuce = false;
        }
        return atDeuce;
    }
    
    /**
    * @return True if the game is done, false if the game is not done
    */
    public boolean isItDone()
    {
        if (pt1 == 100 || pt2 == 100)
        {
            isDone = true;
        }
        return isDone;
    }
    
    /**
    * @return 1 if player 1 won the game, 2 if player 2 won the game
    */
    public int whoWon()
    {
        int i = 0;
        if (pt1 == 100)
            i = 1;
        else
            i = 2;
        reset();
        return i;
    }
    
    /**
    * Resets the game score back to "Love all" (0-0)
    */
    public void reset()
    {
        pt1 = 0;
        pt2 = 0;
        isDone = false;
    }
    
    /**
    * @return Text representation of the game score
    * @see ScoreTrackerTesterGUI
    */
    public String toString()
    {
        String txt = "  Game   ||  ";
        if(pt1 == 99)
        {
            txt += "AD     -     ";
        }
        else
        {
            txt += pt1 + "     -    ";
        }
        if(pt2 == 99)
        {
            txt += "AD";
        }
        else
        {
            txt += pt2;
        }
        return txt;
    }
    
    /**
    * @return Points for player 1 in the current game
    */
    public int getPt1()
    {
        return pt1;
    }
    
    /**
    * @return Points for player 2 in the current game
    */
    public int getPt2()
    {
        return pt2;
    }
}
