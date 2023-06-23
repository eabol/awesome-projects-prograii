package test;

import main.Turn;
import org.junit.Assert;
import org.junit.Test;

public class TurnTest {

    @Test
    public void testGetTotal() {
        Turn turn = new Turn();
        int expectedTotal = 0;
        int actualTotal = turn.getTotal();
        Assert.assertEquals(expectedTotal, actualTotal);
    }

    @Test
    public void testGetSuccesses() {
        Turn turn = new Turn();
        int expectedSuccesses = 0;
        int actualSuccesses = turn.getSuccesses();
        Assert.assertEquals(expectedSuccesses, actualSuccesses);
    }

    @Test
    public void testGetFailures() {
        Turn turn = new Turn();
        int expectedFailures = 0;
        int actualFailures = turn.getFailures();
        Assert.assertEquals(expectedFailures, actualFailures);
    }

    @Test
    public void testPlayDoneWithSuccess() {
        Turn turn = new Turn();
        turn.playDone(true);
        int expectedTotal = 1;
        int expectedSuccesses = 1;
        int expectedFailures = 0;
        Assert.assertEquals(expectedTotal, turn.getTotal());
        Assert.assertEquals(expectedSuccesses, turn.getSuccesses());
        Assert.assertEquals(expectedFailures, turn.getFailures());
    }

    @Test
    public void testPlayDoneWithFailure() {
        Turn turn = new Turn();
        turn.playDone(false);
        int expectedTotal = 1;
        int expectedSuccesses = 0;
        int expectedFailures = 1;
        Assert.assertEquals(expectedTotal, turn.getTotal());
        Assert.assertEquals(expectedSuccesses, turn.getSuccesses());
        Assert.assertEquals(expectedFailures, turn.getFailures());
    }
}
