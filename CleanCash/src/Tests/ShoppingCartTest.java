package Tests;

import DataClasses.Product;
import SystemData.ShoppingCart;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    public ShoppingCart newCart = new ShoppingCart();

    @Test
    public void FindItemTest(){
        Product expectedProduct = new Product("Product", "1", 1.0f);
        newCart.addProduct(expectedProduct);

        Product foundProduct = newCart.findProduct(expectedProduct);
        assertEquals(expectedProduct, foundProduct);
    }


    @Test
    public void RemoveProductTest(){
        ShoppingCart removeCart = new ShoppingCart();
        Product productTest = new Product("Product", "1", 1.0f);
        removeCart.addProduct(productTest);

        removeCart.removeProduct(productTest);
        Product foundProduct = newCart.findProduct(productTest);
        assertEquals(null, foundProduct);
    }


}
