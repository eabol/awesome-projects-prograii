package test;

import exceptions.FailureException;
import exceptions.JamException;
import main.Machine;
import main.Money;
import main.Product;
import main.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {
    private Machine machine;

    @BeforeEach
    void setUp() {
        machine = new Machine(1);
        machine.setMoney(new Money());
        machine.getMoney().insert(10.0f, 10); // Inserting 10 bills of 10.0
        machine.getMoney().insert(5.0f, 20);  // Inserting 20 bills of 5.0
        machine.getMoney().insert(1.0f, 50);  // Inserting 50 coins of 1.0

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 2.5, 1, 1));
        products.add(new Product("Product 2", 3.0, 2, 4));
        products.add(new Product("Product 3", 1.5, 3, 2));
        machine.setProducts(products);
    }

    @Test
    void getMoney() {
        assertNotNull(machine);
        Money money = machine.getMoney();
        assertNotNull(money);
    }


    @Test
    void getStatus() {
        // Arrange
        Machine machine = new Machine(1);
        machine.setStatus(Status.NORMAL);

        // Act
        Status status = machine.getStatus();

        // Assert
        Assertions.assertEquals(Status.NORMAL, status);
    }


    @Test
    void manageChange() {
        // Arrange
        Machine machine = new Machine(1);
        machine.setMoney(new Money());
        Money clientMoney = new Money();
        clientMoney.insert(1.0f, 2);
        float productPrice = 1.5f;

        // Act
        Money change = machine.manageChange(clientMoney, productPrice);

        // Assert
        Assertions.assertNotNull(change);
        Assertions.assertEquals(0, change.getQuantity(0.5f));
        Assertions.assertEquals(2, clientMoney.getQuantity(1.0f));
    }

    @Test
    public void buyProduct() throws JamException, FailureException {
        Machine machine = new Machine(1);
        Product product = new Product("Coke", 1.5, 0, 1);
        machine.getProducts().add(product);
        machine.setMoney(new Money());

        Money clientMoney = new Money();
        clientMoney.insert(2.0f, 1);

        Money change = machine.buyProduct(clientMoney, 0);

        assertNotNull(change);
        assertEquals(0.0f, change.getTotal());

        assertEquals(2.0f, machine.getMoney().getTotal());
    }


}