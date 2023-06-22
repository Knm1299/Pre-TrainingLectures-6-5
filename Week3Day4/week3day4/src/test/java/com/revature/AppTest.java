package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue( true );
    }

    @Test
    public void isTwoPlusTwoFour(){
        //If the test doesn't fail an assert, it passes
        int expected = 4;
        int actual = 2+1;
        assertEquals(expected , actual);
        //the order is hard to keep track of, and differs from framework to framework
        //even if you mix this up, all that changes is the message that's sent if the test fails

    }

    @Test
    public void testSky(){
        boolean skyBlue = App.isSkyBlue();
        assertEquals(true, skyBlue);
    }
}
