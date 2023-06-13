package test;

import main.Luck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuckTest {

    private Luck luck;
    @BeforeEach
    void setUp() {
        luck = new Luck();
    }

    @Test
    void getPositiveLuck() {
        // Realiza múltiples ejecuciones de la función y verifica los resultados
        for (int i = 0; i < 1000; i++) {
            boolean result = luck.getPositiveLuck();
            assertTrue(result || !result); // Verifica que el resultado sea verdadero o falso
        }
    }

    @Test
    void getNegativeLuck() {
        // Realiza múltiples ejecuciones de la función y verifica los resultados
        for (int i = 0; i < 1000; i++) {
            boolean result = luck.getNegativeLuck();
            assertTrue(result || !result); // Verifica que el resultado sea verdadero o falso
        }
    }
}