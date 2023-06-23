package tests;

import main.core.Options;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsTest {
    @Test
    void testAdd() {
        Options options = new Options(4);
        options.add("Prueba1");
        options.add("Prueba2");
        options.add("Prueba3");
        int expected = 3;
        int actual = options.getSize();
        assertEquals(expected, actual);
    }
    @Test
    void testGetDefaultSelection() {
        Options options = new Options(4);
        int expected = 3;
        int actual = options.getDefaultSelection();
        assertEquals(expected, actual);
    }
}
