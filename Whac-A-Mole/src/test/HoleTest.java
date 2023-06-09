package test;

import org.junit.Assert;
import org.junit.Test;
import main.SmackableCharacter;
import main.Hole;

public class HoleTest {

    @Test
    public void testGetAspect() {
        Hole hole = new Hole();
        hole.setAspect("Round");
        String aspect = hole.getAspect();
        Assert.assertEquals("Round", aspect);
    }

    @Test
    public void testSetAspect() {
        Hole hole = new Hole();
        hole.setAspect("Square");
        String aspect = hole.getAspect();
        Assert.assertEquals("Square", aspect);
    }

    @Test
    public void testShowMoleInside() {
        Hole hole = new Hole();
        String message = hole.showMoleInside();
        Assert.assertEquals("Mole is inside the hole.", message);
    }

    @Test
    public void testIsMoleInside() {
        Hole hole = new Hole();
        boolean isMoleInside = hole.isMoleInside();
        // Implement test logic based on your requirements
        // and assert the expected result
    }
}