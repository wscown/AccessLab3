
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by wscown on 1/24/16.
 */
public class UserPlayerSpec {

    @Test
    public void testgetsetUserChoice() {

        String testinput = "paper";
        RPS testoutput;

        ByteArrayInputStream in = new ByteArrayInputStream(testinput.getBytes());
        System.setIn(in);

        //With
        UserPlayer up = new UserPlayer();

        //When
        up.setUserChoice();

        testoutput = up.getUserChoice();

        //Then

        assertEquals("RPS field variable in UserPlayer object set to paper but this was not returned", RPS.PAPER, testoutput);
    }
}