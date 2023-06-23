package Tests;

import SystemManagement.DiscountsManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountsManagerTest {

    private DiscountsManager discountsManager;

    @BeforeEach
    void setUp() {
        discountsManager = new DiscountsManager();
    }

    @Test
    void getDiscount() {
        int expected = 10;
        int discount = discountsManager.getDiscount("summertime");
        assertEquals(expected, discount);
    }
}