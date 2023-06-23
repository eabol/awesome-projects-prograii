
class DrinksTest {

    @BeforeEach
    void setUp() {
        Drinks c= new Drinks("Coca cola", 1.5, 1, 1);
        Drinks f= new Drinks("Fanta", 1.5, 2, 1);
        Drinks s= new Drinks("Sprite", 1.5, 3, 1);
        Drinks w= new Drinks("Water", 1.5, 4, 1);
        Drinks t= new Drinks("Tea", 1.5, 5, 1);
    }

    @Test
    void getName() {
    Drinks f= new Drinks("Fanta", 1.5, 2, 1);
    assertEquals("Fanta", f.getName());
    }

    @Test
    void getPrice() {
        Drinks t= new Drinks("Tea", 1.5, 5, 1);
        assertEquals(1.5, t.getPrice());
    }
}
