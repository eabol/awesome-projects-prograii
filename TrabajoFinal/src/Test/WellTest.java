package Test;

import Main.Death;
import Main.Snail;
import Main.Well;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WellTest {

    @Test
    public void testDepth() {
        Well well = new Well();
        int expectedDepth = -20;

        int result = well.depth();

        assertEquals(expectedDepth, result, "Depth should be -20");
    }


    @Test
    public void testGetWaterDepth() {
        Well well = new Well();
        well.setWaterDepth(-15);

        int result = well.getWaterDepth();

        assertEquals(-15, result, "Water depth should be -15");
    }

}