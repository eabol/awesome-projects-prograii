
class FoodTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Food p= new Food("Pizza", 1.5, 1, 1);
        Food b= new Food("Burger", 1.5, 2, 1);
        Food c= new Food("Chicken", 1.5, 3, 1);
        Food s= new Food("Salad", 1.5, 4, 1);
        Food p2= new Food("Pasta", 1.5, 5, 1);
    }

    @Test
    void getName() {
        Food p= new Food("Pizza", 1.5, 1, 1);
        assertEquals("Pizza", p.getName());
    }

    @Test
    void getPrice() {
        Food p= new Food("Pizza", 1.5, 1, 1);
        assertEquals(1.5, p.getPrice());
    }



}
