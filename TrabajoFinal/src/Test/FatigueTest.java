package Test;

import Main.Fatigue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class FatigueTest {

    @Test
    public void testFatigueValueInRange() {
        Fatigue fatigue = new Fatigue();
        int result = fatigue.getSeverity(4);

        assertTrue(result >= 1 && result <= 10);
    }

}