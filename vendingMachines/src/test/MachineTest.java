package test;

import main.Machine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.Mac;

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
    }

    @Test
    void buyProduct() {
    }
}