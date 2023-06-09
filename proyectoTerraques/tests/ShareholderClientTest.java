import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import proyectoterraques.source.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class ShareholderClientTest {

    private ShareholderClient shareholderClient;
    private DebitAccount debitAccount1;
    private DebitAccount debitAccount2;
    private CreditAccount creditAccount1;
    private CreditAccount creditAccount2;

    @Before
    public void setUp() {
        shareholderClient = new ShareholderClient("12345678A", "John", "Doe", "123 Main St", "555555555");
        debitAccount1 = new DebitAccount("1234567890", "12345678A");
        debitAccount2 = new DebitAccount("0987654321", "12345678A");
        creditAccount1 = new CreditAccount("1234567899","12345678A");
        creditAccount2 = new CreditAccount("0987654320","12345678A");
    }

    @Test
    public void testGetDni() {
        assertEquals("12345678A", shareholderClient.getDni());
    }

    @Test
    public void testGetFullName() {
        assertEquals("John Doe", shareholderClient.getFullName());
    }

    @Test
    public void testGetFullData() {
        assertEquals("12345678A - John Doe - 123 Main St - 555555555\n", shareholderClient.getFullData());
    }

    @Test
    public void testAddAccount() {
        // Testeamos añadir una cuenta de débito cuando no hay ninguna
        assertFalse(shareholderClient.addAccount(debitAccount1));

        // Testeamos intentar añadir otra cuenta de débito
        assertFalse(shareholderClient.addAccount(debitAccount2));

        // Testeamos intentar añadir una cuenta de crédito
        assertFalse(shareholderClient.addAccount(creditAccount1));

        // Testeamos intentar añadir otra cuenta de crédito cuando ya hay una
        assertTrue(shareholderClient.addAccount(creditAccount2));
    }


    @Test
    public void testRemoveAccount() {
        // Añadimos cuentas
        assertFalse(shareholderClient.addAccount(debitAccount1));
        assertFalse(shareholderClient.addAccount(creditAccount1));

        // Luego intentamos eliminar una cuenta que no existe
        shareholderClient.removeAccount("1234");  // Esto no debería eliminar ninguna cuenta

        // Luego intentamos eliminar las cuentas que hemos añadido
        shareholderClient.removeAccount(debitAccount1.getAccountNumber());
        shareholderClient.removeAccount(creditAccount1.getAccountNumber());
    }


    @Test
    public void testListAccounts() {
        // Añade cuentas de débito y crédito al cliente
        shareholderClient.addAccount(debitAccount1);
        shareholderClient.addAccount(creditAccount1);

        // Captura la salida de la consola
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));

        // Llama al método que quieres probar
        shareholderClient.listAccounts();

        // Comprueba si la salida contiene el texto esperado
        assertTrue(consoleOutput.toString().contains("Debit Accounts:"));
        assertTrue(consoleOutput.toString().contains(debitAccount1.getAccountNumber()));
        assertTrue(consoleOutput.toString().contains("Credit Account:"));
        assertTrue(consoleOutput.toString().contains(creditAccount1.getAccountNumber()));
    }



}
