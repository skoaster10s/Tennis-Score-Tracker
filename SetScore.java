
public class SetScore
{
    private int games1, games2;
    private boolean isDone, goToTiebreak;
    private Tiebreak tiebreak;
    private int setNumber;

    /**
     * Constructor for objects of class SetScore
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
    
    public int getGames1()
    {
        return games1;
    }
    
    public int getGames2()
    {
        return games2;
    }
    
    public Tiebreak getTB()
    {
        return tiebreak;
    }
    
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
    
    public void reset()
    {
        games1 = 0;
        games2 = 0;
        isDone = false;
    }
    
    public void setSetNumber(int n)
    {
        setNumber = n;
    }
    
    public boolean toTB()
    {
        if(games1 == 6 && games2 == 6)
        {
            goToTiebreak = true;
        }
        return goToTiebreak;
    }
    
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
