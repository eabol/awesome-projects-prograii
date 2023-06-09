
class JamExceptionTest {
    private JamException jamException;

    @BeforeEach
    void setUp() {

    }
    @Test
    void setDate() {
        LocalDate currentDate = LocalDate.now();
        assertEquals(currentDate, jamException.getDate());
    }
}
