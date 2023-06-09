
class ProductTest {

    @BeforeEach
    void setUp() {
        String name = "Product 1";
        double price = 1.99;
        int id = 1;
        int amount = 10;
        Product product = new Product(name, price, id, amount);
    }

@Test
    void getId() {
        // Prueba de obtención del ID del producto
    Product product = new Product("Product 1", 1.99, 1, 10);
    int expectedId = 1;
        int actualId = product.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    void setAmount() {
        // Prueba de configuración de la cantidad del producto
       Product product = new Product("Product 1", 1.99, 1, 10);
        int newAmount = 20;
        product.setAmount(newAmount);
        assertEquals(newAmount, product.getAmount());
    }
}
