
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by wscown on 1/24/16.
 */
public class TournamentSpec {

    @Test
    public void testplay() {

        UserPlayer up = new UserPlayer();
        ComputerPlayer cp = new ComputerPlayer();

        //With
        Tournament tournament = new Tournament(1);

        //When
        up.setUserChoice(RPS.ROCK);
        cp.setChoice(RPS.ROCK);

        tournament.play(cp, up);

        up.setUserChoice(RPS.PAPER);
        cp.setChoice(RPS.PAPER);

        tournament.play(cp, up);

        up.setUserChoice(RPS.SCISSORS);
        cp.setChoice(RPS.SCISSORS);

        tournament.play(cp, up);

        //then

        assertEquals("Three games were played where the Rock, Paper, Scissor choices were equal. The score should remain 0 - 0 but didnt", tournament.getCompScore(), tournament.getUserScore());

        //With
        up.setUserChoice(RPS.ROCK);
        cp.setChoice(RPS.PAPER);

        tournament.play(cp, up);

        //then

        assertEquals("A game was played where user picked rock and computer picked paper. The score should be user 0 - 1 computer but wasn't", tournament.getUserScore(), tournament.getCompScore() - 1);

        //With
        up.setUserChoice(RPS.ROCK);
        cp.setChoice(RPS.SCISSORS);

        tournament.play(cp, up);

        //then

        assertEquals("A game was palyed where user picked rock and computer picked scissors. The score should be user 1 - 1 computer but wasn't", tournament.getUserScore(), tournament.getCompScore());

        //With
        up.setUserChoice(RPS.PAPER);
        cp.setChoice(RPS.ROCK);

        tournament.play(cp, up);

        //then

        assertEquals("A game was played where user picked paper and computer picked rock. The score should be user 2 - 1 computer but wasn't", tournament.getUserScore(), tournament.getCompScore() + 1);

        //With
        up.setUserChoice(RPS.PAPER);
        cp.setChoice(RPS.SCISSORS);

        tournament.play(cp, up);

        //then

        assertEquals("A game was palyed where user picked paper and computer picked scissors. The score should be user 2 - 2 computer but wasn't", tournament.getUserScore(), tournament.getCompScore());

        //With
        up.setUserChoice(RPS.SCISSORS);
        cp.setChoice(RPS.ROCK);

        tournament.play(cp, up);

        //then

        assertEquals("A game was played where user picked paper and computer picked rock. The score should be user 2 - 3 computer but wasn't", tournament.getUserScore() + 1, tournament.getCompScore());

        //With
        up.setUserChoice(RPS.SCISSORS);
        cp.setChoice(RPS.PAPER);

        tournament.play(cp, up);

        //then

        assertEquals("A game was palyed where user picked paper and computer picked scissors. The score should be user 3 - 3 computer but wasn't", tournament.getUserScore(), tournament.getCompScore());
    }
}