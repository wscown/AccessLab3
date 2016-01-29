import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerSpec {

    @Test
    public void testgetsetUserChoice() {

        int i;
        RPS testoutput;
        boolean passtest = true;

        //With
        ComputerPlayer cp = new ComputerPlayer();


        for(i = 0; i <50; i++){

            //When
            cp.setRandomChoice();
            testoutput = cp.getCompChoice();

            if(testoutput != RPS.ROCK && testoutput != RPS.PAPER && testoutput != RPS.SCISSORS){
                passtest = false;
                break;
            }
        }
        //Then
        assertEquals("RPS field variable in ComputerPlayer object was requested to set a random RPS choice (50 unique tests) but a valid enum group was not returned on test number " + (1+i), true,passtest);
    }
}