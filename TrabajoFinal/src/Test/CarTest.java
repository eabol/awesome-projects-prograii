package Test;

import Main.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarPass() {
        Car car = new Car();
        car.setDescription("The car passed");

        assertEquals("The car passed", car.getDescription());
    }

    @Test
    public void testCarNotPass() {
        Car car = new Car();
        car.setDescription("The car did not pass");

        assertEquals("The car did not pass", car.getDescription());
    }
}