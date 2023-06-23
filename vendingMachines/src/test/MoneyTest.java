package test;

import main.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    Money money = new Money();

    @BeforeEach
    void setUp() {
        money.insert(20, 2);
        money.insert(10, 1);
        money.insert(0.05f, 8);
    }

    @Test
    void add() {
        Money client = new Money();
        client.insert(20, 2);
        money.add(client);
        assertEquals(90.4f, money.getTotal());
    }

    @Test
    void getTotal() {
        float expected = 50.4f;
        assertEquals(expected, money.getTotal());
    }
}