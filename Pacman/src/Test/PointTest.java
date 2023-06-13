package Test;

import Points.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    @Test
    public void testConstructor() {
        int x = 5;
        int y = 10;
        int value = 20;

        Point point = new Point(x, y, value) {

            public void Draw() {

            }
        };

        assertEquals(x, point.getX());
        assertEquals(y, point.getY());
        assertEquals(value, point.getValue());
        assertFalse(point.isEaten());
    }

    @Test
    public void testSetEaten() {
        Point point = new Point(5, 10, 20) {

            public void Draw() {

            }
        };

        point.setEaten(true);

        assertTrue(point.isEaten());
    }
}