import PacMan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacManTest {

    private PacMan pacMan;

    @BeforeEach
    public void setUp() {
        pacMan = new PacMan();
    }

    @Test
    public void testDefaultPosition() {
        assertEquals(0, pacMan.x);
        assertEquals(0, pacMan.y);
    }

    @Test
    public void testMovementUp() {
        pacMan.movement("w");
        assertEquals(0, pacMan.x);
        assertEquals(1, pacMan.y);
    }

    @Test
    public void testMovementLeft() {
        pacMan.movement("a");
        assertEquals(-1, pacMan.x);
        assertEquals(0, pacMan.y);
    }

    @Test
    public void testMovementDown() {
        pacMan.movement("s");
        assertEquals(0, pacMan.x);
        assertEquals(-1, pacMan.y);
    }

    @Test
    public void testMovementRight() {
        pacMan.movement("d");
        assertEquals(1, pacMan.x);
        assertEquals(0, pacMan.y);
    }

    @Test
    public void testMovementCaseInsensitive() {
        pacMan.movement("W");
        assertEquals(0, pacMan.x);
        assertEquals(1, pacMan.y);

        pacMan.movement("A");
        assertEquals(-1, pacMan.x);
        assertEquals(0, pacMan.y);

        pacMan.movement("S");
        assertEquals(0, pacMan.x);
        assertEquals(-1, pacMan.y);

        pacMan.movement("D");
        assertEquals(1, pacMan.x);
        assertEquals(0, pacMan.y);
    }

    @Test
    public void testMovementInvalidInput() {
        pacMan.movement("z");
        assertEquals(0, pacMan.x);
        assertEquals(0, pacMan.y);
    }
}