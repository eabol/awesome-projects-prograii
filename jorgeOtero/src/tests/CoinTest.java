package tests;

import main.core.Coin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTest {
    @Test
    public void testGetValue() {
        Coin coin = new Coin(0.25, 10);
        double expected = 0.25;
        double actual = coin.getValue();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetQuantity() {
        Coin coin = new Coin(0.25, 10);
        int expected = 10;
        int actual = coin.getQuantity();
        assertEquals(expected, actual);
    }
    @Test
    public void testSetQuantity() {
        Coin coin = new Coin(0.25, 10);
        coin.setQuantity(20);
        int expected = 20;
        int actual = coin.getQuantity();
        assertEquals(expected, actual);
    }

}
