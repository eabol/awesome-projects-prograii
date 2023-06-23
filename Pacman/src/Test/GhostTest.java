package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GhostTest {

    @Test
    public void testConstructor() {
        int x = 5;
        int y = 10;

        Ghost ghost = new Ghost(x, y);

        assertEquals(x, ghost.getX());
        assertEquals(y, ghost.getY());
        assertTrue(ghost.isAlive());
    }

    @Test
    public void testDraw() {
        Ghost ghost = new ConcreteGhost(5, 10);

        // Implementa la lógica de prueba para el método Draw() según tus necesidades

        // Ejemplo: Verificar que el método no produce ninguna excepción
        try {
            ghost.Draw();
        } catch (Exception e) {
            fail("Se produjo una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testMovement() {
        Ghost ghost = new ConcreteGhost(5, 10);

        // Implementa la lógica de prueba para el método movement() según tus necesidades

        // Ejemplo: Verificar que el método no produce ninguna excepción
        try {
            ghost.movement();
        } catch (Exception e) {
            fail("Se produjo una excepción: " + e.getMessage());
        }
    }
}
