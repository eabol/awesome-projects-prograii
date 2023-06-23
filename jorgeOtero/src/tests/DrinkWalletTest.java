package tests;

import main.core.DrinkWallet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkWalletTest {
    @Test
    public void testAddCoins() {
        DrinkWallet drinkWallet = new DrinkWallet();
        drinkWallet.addCoins();
        double expected = 114;
        double actual = drinkWallet.total();
        assertEquals(expected, actual);
    }
}
