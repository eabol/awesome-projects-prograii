package Test;

import Main.Day;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DayTest {
    @Test
    public void testNextDay() {
        Day.nextDay();
        assertEquals(2, Day.getDay());

        Day.nextDay();
        assertEquals(3, Day.getDay());
    }
}