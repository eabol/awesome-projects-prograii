package Test;

import Basis.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @BeforeEach
    void setUp() {
        Money m= new Money();
        m.insetMoney(10,4);
        m.insetMoney(5,3);
    }
    @Test
    void getTotal() {
        Money m= new Money();
        m.insetMoney(10,4);
        m.insetMoney(5,3);
        m.getTotal();
    }

    @Test
    void suma() {
        Money clientMoney= new Money();
        clientMoney.insetMoney(10,4);
        clientMoney.insetMoney(1,4);
        clientMoney.suma(clientMoney);

    }

}