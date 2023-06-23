package tests;

import main.core.DrinkWallet;
import main.core.Machine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MachineTest {
    @Test
    void getIdTest() {
        DrinkWallet drinkWallet = new DrinkWallet();
        Machine machine = new main.core.Machine(1, drinkWallet);
        int expected = 1;
        int actual = machine.getID();
        assertEquals(expected, actual);
    }
    @Test
    void getMoneyTest() {
        DrinkWallet drinkWallet = new DrinkWallet();
        Machine machine = new main.core.Machine(1, drinkWallet);
        double expected = 0;
        double actual = machine.getMoney().total();
        assertEquals(expected, actual);
    }
}
