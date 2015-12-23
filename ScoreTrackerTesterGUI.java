import java.util.Scanner;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ScoreTrackerTesterGUI class implements a GUI applet that 
 * asks for the users input for the two player names and
 * number of sets being played and then displays a text
 * representation of the score of the whole match. When the
 * match is done, it will display the result of the match.
 * 
 * @author Sean Ko 
 * @version November 1, 2015
 */
public class ScoreTrackerTesterGUI extends JFrame
{
    private Match m;
    private ArrayList<SetScore> s;
    private boolean isDone;

    public static void main(String[] args)
    {
        new ScoreTrackerTesterGUI();
    }

    public ScoreTrackerTesterGUI()
    {
        final JFrame gFrame = new JFrame("Tennis Scoreboard!");
        gFrame.setLayout(new FlowLayout());
        gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gFrame.setSize(300,200);
        gFrame.setLocationRelativeTo(null);

        final JTextField name1 = new JTextField(15);
        Label l1 = new Label("Player 1:");

        final JTextField name2 = new JTextField(15);
        Label l2 = new Label("Player 2:");

        final JSlider sets = new JSlider(1,5,2);
        sets.setMajorTickSpacing(2);
        sets.setPaintTicks(true);
        sets.setPaintLabels(true);
        sets.setSnapToTicks(true);
        sets.setLabelTable(sets.createStandardLabels(2,1));
        sets.setValue(1);
        Label l3 = new Label("Number of Sets?");

        JButton play = new JButton("Ready, Set, Play");
        play.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    m = new Match(name1.getText(), name2.getText(), sets.getValue()); //Initialize Match field
                    s = m.getSetScores();
                    isDone = m.isMatchDone();
                    gFrame.dispose();

                    final JFrame scoreFrame = new JFrame("Tennis Scoreboard!");
                    scoreFrame.setSize(250 + s.size()*75,200);
                    scoreFrame.setLayout(new FlowLayout());
                    scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    scoreFrame.setLocationRelativeTo(null);

                    final JTextField[][] textHolder = new JTextField[3][s.size()+2];    
                    Container c1= new Container();
                    c1.setLayout(new GridLayout(0, s.size()+2));
                    for(int m = 0; m < textHolder.length; m++) {
                        for(int n = 0; n < textHolder[0].length; n++) {
                            textHolder[m][n] = new JTextField();
                            textHolder[m][n].setHorizontalAlignment(JTextField.CENTER);
                            textHolder[m][n].setEditable(false);
                            c1.add(textHolder[m][n]);
                        }
                    }

                    //First Row of c1
                    textHolder[0][0].setText("Players");
                    for(int i=0; i <s.size(); i++)
                    {
                        textHolder[0][i+1].setText("Set " + (i+1));
                    }
                    textHolder[0][textHolder[0].length-1].setText("Game Score");

                    //Second Row of c1
                    textHolder[1][0].setText(m.getPlayer1().getName());

                    for(int i=0; i < s.size(); i++)
                    {
                        SetScore tempSet = s.get(i);
                        textHolder[1][i+1].setText(Integer.toString(tempSet.getGames1()));

                    }
                    textHolder[1][textHolder[1].length-1].setText(Integer.toString(m.getGameScore().getPt1()));

                    //Third Row of c1
                    textHolder[2][0].setText(m.getPlayer2().getName());
                    for(int i=0; i < s.size(); i++)
                    {
                        SetScore tempSet = s.get(i);
                        textHolder[2][i+1].setText(Integer.toString(tempSet.getGames2()));

                    }
                    textHolder[2][textHolder[2].length-1].setText(Integer.toString(m.getGameScore().getPt2()));

                    scoreFrame.add(c1);

                    Container c2 = new Container();
                    c2.setLayout(new FlowLayout());
                    c2.add(new Label("Who won the point?", JLabel.CENTER));
                    JButton player1 = new JButton(m.getPlayer1().getName());

                    JButton player2 = new JButton(m.getPlayer2().getName());

                    c2.add(player1);
                    c2.add(player2);
                    scoreFrame.add(c2);
                    scoreFrame.setVisible(true);

             
                    player1.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e1)
                            {
                                boolean atDeuce = m.getGameScore().atDeuce();
                                m.winPt1();
                                boolean atTB = ((SetScore)m.getSetScores().get(m.getCurrentSetNum()-1)).toTB();

                                for(int i=0; i < s.size(); i++)
                                {
                                    SetScore tempSet = (SetScore)m.getSetScores().get(i);
                                    textHolder[1][i+1].setText(Integer.toString(tempSet.getGames1()));

                                }

                                if(!atTB)
                                {
                                    textHolder[0][textHolder[0].length-1].setText("Game Score");
                                    textHolder[1][textHolder[1].length-1].setText(Integer.toString(m.getGameScore().getPt1()));
                                    textHolder[2][textHolder[2].length-1].setText(Integer.toString(m.getGameScore().getPt2()));
                                    if(atDeuce)
                                    {
                                        textHolder[1][textHolder[1].length-1].setText("Ad");
                                    }
                                }
                                else
                                {
                                    textHolder[0][textHolder[0].length-1].setText("Tiebreak");
                                    textHolder[1][textHolder[1].length-1].setText(Integer.toString(((SetScore)m.getSetScores().get(m.getCurrentSetNum()-1)).getTB().getPoints1()));
                                    textHolder[2][textHolder[2].length-1].setText(Integer.toString(((SetScore)m.getSetScores().get(m.getCurrentSetNum()-1)).getTB().getPoints2()));
                                }
                                isDone = m.isMatchDone();

                                if(isDone)
                                {
                                    scoreFrame.dispose();
                                    displayFinalFrame();
                                }
                            }
                        });

                    player2.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e2)
                            {
                                boolean atDeuce = m.getGameScore().atDeuce();
                                m.winPt2();
                                boolean atTB = ((SetScore)m.getSetScores().get(m.getCurrentSetNum()-1)).toTB();

                                for(int i=0; i < s.size(); i++)
                                {
                                    SetScore tempSet = (SetScore)m.getSetScores().get(i);
                                    textHolder[2][i+1].setText(Integer.toString(tempSet.getGames2()));
                                }

                                if(!atTB)
                                {
                                    textHolder[0][textHolder[0].length-1].setText("Game Score");
                                    textHolder[1][textHolder[1].length-1].setText(Integer.toString(m.getGameScore().getPt1()));
                                    textHolder[2][textHolder[2].length-1].setText(Integer.toString(m.getGameScore().getPt2()));
                                    if(atDeuce)
                                    {
                                        textHolder[2][textHolder[1].length-1].setText("Ad");
                                    }
                                }
                                else
                                {
                                    textHolder[0][textHolder[0].length-1].setText("Tiebreak");
                                    textHolder[1][textHolder[1].length-1].setText(Integer.toString(((SetScore)m.getSetScores().get(m.getCurrentSetNum()-1)).getTB().getPoints1()));
                                    textHolder[2][textHolder[2].length-1].setText(Integer.toString(((SetScore)m.getSetScores().get(m.getCurrentSetNum()-1)).getTB().getPoints2()));
                                }
                                isDone = m.isMatchDone();

                                if(isDone)
                                {
                                    scoreFrame.dispose();
                                    displayFinalFrame();
                                }
                            }
                        });

                }
            });

        gFrame.add(l1);
        gFrame.add(name1);
        gFrame.add(l2);
        gFrame.add(name2);
        gFrame.add(l3);
        gFrame.add(sets);
        gFrame.add(play);

        gFrame.setVisible(true);
    }

    private void displayFinalFrame()
    {
        JFrame finishFrame = new JFrame("Winner!");
        finishFrame.setLayout(new FlowLayout());
        finishFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finishFrame.setSize(300,200);
        finishFrame.setLocationRelativeTo(null);
        ArrayList<SetScore> sets = m.getSetScores();

        JLabel winner = new JLabel();
        winner.setHorizontalTextPosition(JLabel.LEFT);
        if(m.getPlayer1().getSet() > m.getPlayer2().getSet())
        {
            winner.setText(m.getPlayer1().getName());
        }
        else if(m.getPlayer2().getSet() > m.getPlayer1().getSet())
        {
            winner.setText(m.getPlayer2().getName());
        }
        winner.setFont(new Font("Cambria",Font.BOLD, 20));

        JLabel finalScore = new JLabel();
        finalScore.setHorizontalTextPosition(JLabel.CENTER);
        String txt = "<html>DEF. <br>";
        if(m.getPlayer1().getSet() > m.getPlayer2().getSet())
        {
            for(int i = 0; i < m.getCurrentSetNum()-1; i++)
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
        else if (m.getPlayer2().getSet() > m.getPlayer1().getSet())
        {
            for(int i = 0; i < m.getCurrentSetNum()-1; i++)
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
        txt += "</html>";
        finalScore.setFont(new Font("Cambria",Font.PLAIN, 20));
        finalScore.setText(txt);

        JLabel loser = new JLabel();
        loser.setHorizontalTextPosition(JLabel.RIGHT);
        if(m.getPlayer1().getSet() > m.getPlayer2().getSet())
        {
            loser.setText(m.getPlayer2().getName());
        }
        else if(m.getPlayer2().getSet() > m.getPlayer1().getSet())
        {
            loser.setText(m.getPlayer1().getName());
        }
        loser.setFont(new Font("Cambria",Font.BOLD, 20));

        finishFrame.add(winner);
        finishFrame.add(finalScore);
        finishFrame.add(loser);
        //finishFrame.pack();
        finishFrame.setVisible(true);
    }
}
