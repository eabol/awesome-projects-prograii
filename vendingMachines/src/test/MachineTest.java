package test;

import main.Machine;
import main.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

    @BeforeEach
    void setUp() {
        Machine machine = new Machine(1);
    }

    @Test
    void getMoney() {
        Machine machine = new Machine(1);
        assertEquals(0, machine.getMoney());
    }

    @Test
    void getStatus() {
        Machine machine = new Machine(1);
        assertEquals("NORMAL", machine.getStatus());
    }

    @Test
    void manageChange() {
            // Arrange
            Money clientMoney = new Money();
            clientMoney.insert(1.0f, 2); // Insert $1 with quantity 2
            clientMoney.insert(0.5f, 4); // Insert $0.5 with quantity 4
            float productPrice = 1.8f;

            Money change = new Money();
    }

    @Test
    void buyProduct() {
    }
}