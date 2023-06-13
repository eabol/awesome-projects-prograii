package Test;

import PowerUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PowerUpTest {

    private PowerUp powerUp;

    @BeforeEach
    public void setUp() {
        powerUp = new PowerUp(2, 3);
    }

    @Test
    public void testConstructor() {
        assertEquals(2, powerUp.getX());
        assertEquals(3, powerUp.getY());
        assertEquals(10, powerUp.getValue());
        assertEquals(5, powerUp.getDuration());
    }

    @Test
    public void testDraw() {

        powerUp.Draw();

        assertTrue(true);
    }
}
