import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    public void testPacmanComerComida() {
        // Preparación del Pacman
        Pacman pacman = new Pacman();
        int puntajeInicial = pacman.getPuntaje();
        Comida comida = new Comida();

        // Ejecución del método para obtener el puntaje
        pacman.comerComida(comida);
        int puntajeFinal = pacman.getPuntaje();

        // Verificación del resultado
        Assert.assertEquals(puntajeInicial + comida.getPuntos(), puntajeFinal);
    }

}
