package Tests;

import DataClasses.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void testDebugProduct() {
        Product product = new Product("Product 1", "123", 10.99f);
        String expectedName = "Product 1";
        String expectedId = "123";
        float expectedPrice = 10.99f;

        String returnedName = product.getEntityName();
        String returnedId = product.getEntityId();
        float returnedPrice = product.getPrice();

        assertEquals(expectedName, returnedName);
        assertEquals(expectedId, returnedId);
        assertEquals(expectedPrice, returnedPrice, 0.01f);

    }
}
