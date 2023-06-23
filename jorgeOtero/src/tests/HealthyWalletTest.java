package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthyWalletTest {
    @Test
    void addCoinsTest() {
        main.core.HealthyWallet healthyWallet = new main.core.HealthyWallet();
        healthyWallet.addCoins();
        double expected = 143;
        double actual = healthyWallet.total();
        assertEquals(expected, actual);
    }

}
