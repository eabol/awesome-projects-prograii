
class MachineTest {

    @BeforeEach
    void setUp() {
        int id = 1;
        Money money = new Money();
        Product[] products = new Product[20];
        int[] change = new int[]{1, 0, 0}; // Suponiendo que hay 1 moneda de 1 dólar disponible
        Machine machine = new Machine(id, money);

    }

    @Test
    void setSalable() {
        Machine machine= new Machine(1,new Money());
        machine.setSalable(Alert.JAM);
        assertEquals(Alert.JAM, machine.getSalable());
    }

    @Test
    void listProducts() {
        // Configurar los productos de la máquina
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Food("Biscuits", 1.50, 1, 10));
        products.add(new Food("Chocolate", 1.10, 2, 10));
        products.add(new Drinks("Basis.Drinks", 1.05, 3, 10));
        products.add(new Food("Sandwich", 1.75, 4, 10));
        Machine machine= new Machine(1,new Money());
        machine.setProducts(products);

        // Llamar al método listProducts()
        machine.listProducts();

    }
}
