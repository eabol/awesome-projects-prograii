package pacman.test;

import org.junit.Assert;
import org.junit.Test;

public class DireccionTest {

    @Test
    public void testMovimientoPacman() {
        // Arrange (Preparación de datos)
        Pacman pacman = new Pacman();
        Direction teclado = new Direction();
        
        // Act (Ejecución del método a probar)
        teclado.simularTeclaPresionada(Tecla.UP);
        pacman.mover(teclado);
        
        // Assert (Verificación del resultado)
        Assert.assertEquals(Direction.UP, pacman.getNextPosition());
    }
}

