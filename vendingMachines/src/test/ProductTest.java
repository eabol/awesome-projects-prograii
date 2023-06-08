package test;

import main.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @BeforeEach
    void setUp() {
        Product product = new Product("Coca Cola", 2.5, 1, 1);
    }

    @Test
    void getName() {
        Product product = new Product("Coca Cola", 2.5, 1, 1);
        assertEquals("Coca Cola", product.getName());
    }

    @Test
    void getPrice() {
        Product product = new Product("Coca Cola", 2.5, 1, 1);
        assertEquals(2.5, product.getPrice());
    }
}