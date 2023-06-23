package Test;

import Main.Snail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnailTest {


    @Test
    public void testFallInHole() {
        Snail snail = new Snail();
        int expectedAltitude = -10; // Assuming Tier.getValue() returns -10

        assertEquals(expectedAltitude, snail.getAltitude(), "Snail should fall in a hole with altitude -10");
    }

    @Test
    public void testRise() {
        Snail snail = new Snail();
        snail.setAltitude(0); // Start at altitude 0
        int expectedUp = 3; // Assuming Tier.getValue() returns 5

        snail.rise();

        assertEquals(expectedUp, snail.getAltitude(), "Snail should rise 3");
    }
}