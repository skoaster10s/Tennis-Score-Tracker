
/**
 * This class represents 1 game in tennis.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameScore
{
    private int pt1, pt2;
    private boolean isDone, atDeuce;

    public GameScore()
    {
        pt1 = 0;
        pt2 = 0;
        isDone = false;
        atDeuce = false;
    }

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
    
    public boolean isItDone()
    {
        if (pt1 == 100 || pt2 == 100)
        {
            isDone = true;
        }
        return isDone;
    }
    
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
    
    public void reset()
    {
        pt1 = 0;
        pt2 = 0;
        isDone = false;
    }
    
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
    
    public int getPt1()
    {
        return pt1;
    }
    
    public int getPt2()
    {
        return pt2;
    }
}
