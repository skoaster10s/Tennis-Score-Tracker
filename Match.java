import java.util.ArrayList;
/**
 * Match class represents one match played between two players
 * 
 * @author Sean Ko
 */
public class Match
{
    private Player p1, p2;
    private ArrayList<SetScore> sets; 
    private GameScore game;
    private int currentSetNum;

    /**
    * Constructor for a Match.
    * Initializes a match played between two players with the given names, 
    * number of sets being played, 
    * and one as the current set being played.
    * @param String Name of player 1
    * @param String Name of player 2
    * @param int Number of sets the match is out of
    */
    public Match(String name1, String name2, int numOfSets)
    {
        p1 = new Player(name1);
        p2 = new Player(name2);
        sets = new ArrayList<SetScore>();
        for(int i = 0; i < numOfSets; i++)
        {
            sets.add(new SetScore(i+1));
        }
        game = new GameScore();
        currentSetNum = 1;
    }
    
    /**
    * Increments the points of Player 1
    */
    public void winPt1()
    {
        if(!sets.get(currentSetNum-1).toTB())
        {
            game.win1();
            if(game.isItDone())
            {
                sets.get(currentSetNum-1).win1();
                game.reset();
            }
        }
        else
        {
            sets.get(currentSetNum-1).win1();
        }
        if(sets.get(currentSetNum-1).isItDone())
        {
            currentSetNum++;
            p1.winSet();
        }
    }
    
    /**
    * Increments the points of Player 2
    */
    public void winPt2()
    {
        if(!sets.get(currentSetNum-1).toTB())
        {
            game.win2();
            if(game.isItDone())
            {
                sets.get(currentSetNum-1).win2();
                game.reset();
            }
        }
        else
        {
            sets.get(currentSetNum-1).win2();
        }
        if(sets.get(currentSetNum-1).isItDone())
        {
            currentSetNum++;
            p2.winSet();
        }
    }

    /**
    * @return True if the match is done, false if the match is not done
    */
    public boolean isMatchDone()
    {
        if(sets.size()%2 == 1)
        {
            if(p1.getSet() == sets.size()/2 + 1 || p2.getSet() == sets.size()/2 + 1)
                return true;
        }
        else
        {
            if(p1.getSet() == sets.size()/2 || p2.getSet() == sets.size()/2)
                return true;
        }
        return false;
    }
    
    /**
    * @return Text representation of the match score
    * @see ScoreTrackerTesterORI
    */
    public String toString()
    {
        String border = "----------------------------------------------";
        String line1 = "  Set #  ||  " + p1.getName() + "   ||   " + p2.getName();
        String line2 = "";
        for(SetScore s : sets)
        {
            line2 += s.toString() + "\n";
        }
        String line3 = game.toString();
        return border + "\n" + line1 + "\n" + line2 + "\n" + line3 + "\n" + border;
    }
    
    /**
    * @return Text representation of the final score
    * @see ScoreTrackerTesterORI
    */
    public String finalScore()
    {
        String txt = "Winner: ";
        if(p1.getSet() > p2.getSet())
        {
            txt += p1.getName() + "\n";
        }
        else if(p2.getSet() > p1.getSet())
        {
            txt += p2.getName() + "\n";
        }
        txt += "Score: ";
        
        if(p1.getSet() > p2.getSet())
        {
            for(int i = 0; i < currentSetNum-1; i++)
            {
                txt += sets.get(i).getGames1() + "-" + sets.get(i).getGames2();
                if(sets.get(i).toTB())
                {
                    Tiebreak tb = sets.get(i).getTB();
                    txt += "(" + tb.getPoints1() + "-" + tb.getPoints2() + ")";
                }
                txt += "  ";
            }
        }
        else if (p2.getSet() > p1.getSet())
        {
            for(int i = 0; i < currentSetNum-1; i++)
            {
                txt += sets.get(i).getGames2() + "-" + sets.get(i).getGames1();
                if(sets.get(i).toTB())
                {
                    Tiebreak tb = sets.get(i).getTB();
                    txt += "(" + tb.getPoints2() + "-" + tb.getPoints1() + ")";
                }
                txt += "  ";
            }
        }
        return txt;
        
    }
    
    /**
    * @return ArrayList of current SetScore
    * @see SetScore
    */
    public ArrayList getSetScores()
    {
        return sets;
    }
    
    /**
    * @return current GameScore
    * @see GameScore
    */
    public GameScore getGameScore()
    {
        return game;
    }
    
    /**
    * @return Player 1
    * @see Player
    */
    public Player getPlayer1()
    {
        return p1;
    }
    
    /**
    * @return Player 2
    * @see Player
    */
    public Player getPlayer2()
    {
        return p2;
    }
    
    /**
    * @return Current set number being played
    */
    public int getCurrentSetNum()
    {
        return currentSetNum;
    }
}
