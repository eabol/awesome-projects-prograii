package test;

import main.Drinks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinksTest {

    @BeforeEach
    void setUp() {
        Drinks drink1 = new Drinks("Coca Cola", 2.5, 1, 1, false, 330);
        Drinks drink2 = new Drinks("Beer", 3, 2, 4, true, 500);
        Drinks drink3 = new Drinks("Water", 1.5, 3, 1, false, 500);
    }

    @Test
    void isIsAlcoholic() {
        Drinks drink1 = new Drinks("Coca Cola", 2.5, 1, 1, false, 330);
        Drinks drink2 = new Drinks("Beer", 3, 2, 4, true, 500);
        Drinks drink3 = new Drinks("Water", 1.5, 3, 1, false, 500);
        assertFalse(drink1.isAlcoholic());
        assertTrue(drink2.isAlcoholic());
        assertFalse(drink3.isAlcoholic());

    }
}