package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnhealthyWalletTest {
    @Test
    void addCoinsTest() {
        main.core.UnhealthyWallet unhealthyWallet = new main.core.UnhealthyWallet();
        unhealthyWallet.addCoins();
        double expected = 124;
        double actual = unhealthyWallet.total();
        assertEquals(expected, actual);
    }
}
