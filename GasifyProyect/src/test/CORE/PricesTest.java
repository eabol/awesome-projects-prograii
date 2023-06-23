package test.CORE;

import main.core.data.Prices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PricesTest {

    private Prices prices;

    @BeforeEach
    void setUp() {
        prices = new Prices(2023, "01/2023", 5);
    }

    @Test
    void testGetYear() {
        int expectedYear = 2023;
        int actualYear = prices.getYear();
        Assertions.assertEquals(expectedYear, actualYear);
    }

    @Test
    void testSetYear() {
        int expectedYear = 2024;
        prices.setYear(expectedYear);
        int actualYear = prices.getYear();
        Assertions.assertEquals(expectedYear, actualYear);
    }

    @Test
    void testGetPeriod() {
        String expectedPeriod = "01/2023";
        String actualPeriod = prices.getPeriod();
        Assertions.assertEquals(expectedPeriod, actualPeriod);
    }

    @Test
    void testSetPeriod() {
        String expectedPeriod = "01/2023";
        prices.setPeriod(expectedPeriod);
        String actualPeriod = prices.getPeriod();
        Assertions.assertEquals(expectedPeriod, actualPeriod);
    }

    @Test
    void testGetValue() {
        float expectedValue = 5;
        float actualValue = prices.getValue();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    void testSetValue() {
        int expectedValue = 15;
        prices.setValue(expectedValue);
        float actualValue = prices.getValue();
        Assertions.assertEquals(expectedValue, actualValue);
    }
}
