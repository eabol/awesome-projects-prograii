package Test;

import Points.Food;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {

    @Test
    public void testConstructor() {
        int x = 5;
        int y = 10;
        int value = 20;

        Food food = new Food(x, y, value);

        assertEquals(x, food.getX());
        assertEquals(y, food.getY());
        assertEquals(value, food.getValue());
    }

    @Test
    public void testDraw() {
        Food food = new Food(5, 10, 20);

        try {
            food.Draw();
        } catch (Exception e) {
            fail("Se produjo una excepción: " + e.getMessage());
        }
    }
}
