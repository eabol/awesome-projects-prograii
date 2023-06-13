package core;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeTest {

    @Test
    public void testAdvanceTime() {
        Time time = new Time(10, 30, 15);
        time.advanceTime();

        assertEquals(10, time.getHours());
        assertEquals(30, time.getMinutes());

        for (int i = 0; i < 5; i++) {
            time.advanceTime();
        }

        assertEquals("isMorning", time.getMomentOfDay());
    }

    @Test
    public void testGetMomentOfDay() {
        Time time = new Time(8, 0, 5);

        assertEquals("isMorning", time.getMomentOfDay());

        time.setHours(19);
        assertEquals("isSunset", time.getMomentOfDay());
    }
}
