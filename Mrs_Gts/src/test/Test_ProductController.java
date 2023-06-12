package test;

import controllers.ProductController;
import models.ProductModel;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test_ProductController {

    private ProductController productController;

    @Before
    public void setUp() {
        productController = new ProductController();
    }

    @Test
    public void testCreateProductList() {
        List<ProductModel> products = productController.createProductList();

        assertEquals(4, products.size());

        ProductModel product1 = products.get(0);
        assertEquals("Galletas", product1.name);
        assertEquals(1.50, product1.price, 0.01);
        assertEquals(10, product1.quantity);

        ProductModel product2 = products.get(1);
        assertEquals("Chocolates", product2.name);
        assertEquals(1.10, product2.price, 0.01);
        assertEquals(10, product2.quantity);

        ProductModel product3 = products.get(2);
        assertEquals("Bebida", product3.name);
        assertEquals(1.05, product3.price, 0.01);
        assertEquals(10, product3.quantity);

        ProductModel product4 = products.get(3);
        assertEquals("Bocadillo", product4.name);
        assertEquals(1.75, product4.price, 0.01);
        assertEquals(10, product4.quantity);
    }

    @Test
    public void testUpdatePrice() {
        ProductModel product = new ProductModel("Galletas", 1.50, 10);
        product.updatePrice(2.00);

        assertEquals(2.00, product.price, 0.01);
    }

    @Test
    public void testUpdateName() {
        ProductModel product = new ProductModel("Galletas", 1.50, 10);
        product.updateName("Nuevas Galletas");

        assertEquals("Nuevas Galletas", product.name);
    }

    @Test
    public void testUpdateQuantity() {
        ProductModel product = new ProductModel("Galletas", 1.50, 10);
        product.updateQuantity(20);

        assertEquals(20, product.quantity);
    }
}
