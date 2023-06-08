package Test;

import Main.CameOut;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CameOutTest {

    @Test
    public void testCameOut() {
        CameOut cameOut = new CameOut();

        assertEquals("The snail get out of the well", cameOut.getMessage());
    }
}