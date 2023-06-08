package Test;

import Main.Tier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TierTest {

    @Test
    public void testTierValueInRange() {
        Tier tier = new Tier();
        int result = tier.getValue(1, 10);

        assertTrue(result >= 1 && result <= 10);
    }
}