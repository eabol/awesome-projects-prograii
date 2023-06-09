package Tests;

import DataClasses.Product;
import org.junit.jupiter.api.Test;
import SystemData.InventoryDataBase;
import static org.junit.jupiter.api.Assertions.*;

class InventoryDataBaseTest {

    @Test
    void findProduct() {
        InventoryDataBase inventoryDataBase = new InventoryDataBase();

        Product expectedProduct = inventoryDataBase.findProduct("15");
        Product[] products;

        products = inventoryDataBase.getProducts();

        assertEquals(expectedProduct, products[14]);

    }
}