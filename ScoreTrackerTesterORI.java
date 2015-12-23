import java.util.Scanner;
/**
 * ScoreTrackerTester class implements an application that
 * asks for the users input for the two player names and
 * number of sets being played and then displays a text
 * representation of the score of the whole match. When the
 * match is done, it will display the result of the match.
 * 
 * @author Sean Ko 
 * @version June 1, 2014
 */
public class ScoreTrackerTesterORI
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the first player's name: ");
        String p1 = kb.nextLine();
        System.out.print("Enter the second player's name: ");
        String p2 = kb.nextLine();
        System.out.print("How many sets? ");
        int s = kb.nextInt();
        System.out.println("Alright. Ready? Play.");
        System.out.println("");
        
        Match m = new Match(p1, p2, s);
        do
        {
            System.out.println(m.toString());
            int answer;
                System.out.println("Who won the point? (Enter 1 for Player 1 and 2 for Player 2): ");
                answer = kb.nextInt();
            if( answer == 1)
                m.winPt1();
            else if(answer ==2)
                m.winPt2();
        }
        while(!m.isMatchDone());
        
        System.out.println("");
        System.out.println("*************************************");
        System.out.println(m.finalScore());
        System.out.println("*************************************");
    }
}
