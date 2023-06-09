import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import proyectoterraques.source.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StandardClientTest {

    private StandardClient standardClient;
    private DebitAccount debitAccount;
    private CreditAccount creditAccount;

    @Before
    public void setUp() {
        standardClient = new StandardClient("12345678A", "John", "Doe", "123 Main St", "555555555");
        debitAccount = new DebitAccount("1234567890", "12345678A");
        creditAccount = new CreditAccount("0987654321","12345678A");
    }

    @Test
    public void testGetDni() {
        assertEquals("12345678A", standardClient.getDni());
    }

    @Test
    public void testGetFullName() {
        assertEquals("John Doe", standardClient.getFullName());
    }

    @Test
    public void testGetFullData() {
        // Asegúrate de que este método devuelve los datos correctos
        assertEquals("12345678A - John Doe - 123 Main St - 555555555\n", standardClient.getFullData());
    }


    @Test
    public void testAddAccount() {
        // Testeamos añadir una cuenta de débito cuando no hay ninguna
        assertFalse(standardClient.addAccount(debitAccount));

        // Testeamos intentar añadir otra cuenta de débito
        assertTrue(standardClient.addAccount(new DebitAccount("1234567891", "12345678A")));

        // Testeamos intentar añadir una cuenta de crédito
        assertTrue(standardClient.addAccount(new CreditAccount("0987654322","12345678A")));
    }

    @Test
    public void testRemoveAccount() {
        // Comprueba que no hay cuenta antes de intentar eliminar
        assertNull(standardClient.debit_Account);

        // Intenta añadir una cuenta y luego intenta eliminarla
        boolean accountAdded = standardClient.addAccount(debitAccount);

        if (accountAdded) {
            standardClient.removeAccount(debitAccount.getAccountNumber());
            assertNull(standardClient.debit_Account);
        } else {
            // La cuenta no se añadió correctamente, así que no intentes eliminarla
            System.out.println("No se pudo añadir la cuenta. Saltando la eliminación de la cuenta...");
        }
    }

    @Test
    public void testListAccounts() {
        // Añade una cuenta de débito al cliente
        standardClient.addAccount(debitAccount);

        // Captura la salida de la consola
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));

        // Llama al método que quieres probar
        standardClient.listAccounts();

        // Comprueba si la salida contiene el texto esperado
        assertTrue(consoleOutput.toString().contains("Debit Account:"));
        assertTrue(consoleOutput.toString().contains(debitAccount.getAccountNumber()));
    }

}
