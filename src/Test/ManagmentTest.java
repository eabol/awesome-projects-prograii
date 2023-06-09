
class ManagmentTest {
    private Managment managment;

    @BeforeEach
    void setUp() {
        managment = new Managment();
    }

    @Test
    void menu() {
        int idMachine = 1;
        managment.menu(idMachine);
    }

    @Test
    void buyProductMachine() {
        int idMachine = 1;
        int idProduct = 1;
        Money money = new Money();
        money.insetMoney(20, 1);
        money.insetMoney(2, 1);
        managment.buyProductMachine(idMachine, idProduct, money);
    }

    @Test   void generalInfo() {
        managment.generalInfo();
    }
}
