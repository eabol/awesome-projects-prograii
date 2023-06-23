package Test;

import Main.Alive;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AliveTest {
    @Test
    public void testAliveWithMessage() {
        String expectedMessage = "The snail is alive and well.";
        Alive alive = new Alive(expectedMessage);
        String actualMessage = alive.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testAliveWithDefaultMessage() {
        String expectedMessage = "The snail is alive";
        Alive alive = new Alive();
        String actualMessage = alive.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}