
    class FailuireExceptionTest {

        private FailuireException failureException;

        @BeforeEach
        void setUp() {
            int idMachine = 123; // Replace with the desired machine ID
            failureException = new FailuireException(idMachine);
        }

        @Test
        void setDate() {
            LocalDate currentDate = LocalDate.now();
            assertEquals(currentDate, failureException.getDate());}
    }
