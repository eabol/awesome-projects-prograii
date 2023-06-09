package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import SystemData.DiscountsDataBase;

public class DiscountsDataBaseTest {

    @Test
    public void testAddDiscount() {
        DiscountsDataBase db = new DiscountsDataBase();
        String expected = "10";
        assertEquals(expected, db.getSaleDiscount("summertime"));

    }
}