package Test;

import Main.Death;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeathTest {

    @Test
    public void testDeathWithMessage() {
        String message = "Custom death message";
        Death death = new Death(message);

        assertEquals(message, death.getMessage());
    }

    @Test
    public void testDeathDefaultMessage() {
        Death death = new Death();

        assertEquals("The snail is dead", death.getMessage());
    }
}