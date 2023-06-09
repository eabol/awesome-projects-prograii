import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proyectoterraques.exceptions.InvalidCharacterException;
import proyectoterraques.source.DebitAccount;

import static org.junit.jupiter.api.Assertions.*;

public class DebitAccountTest {

    DebitAccount account;

    @BeforeEach
    public void setup() {
        account = new DebitAccount("1234567890", "73542564A");
    }

    @Test
    public void testAccountNumber() {
        assertEquals("1234567890", account.getAccountNumber(), "El número de cuenta debería ser correcto");
    }

    @Test
    public void testGetDni() {
        assertEquals("73542564A", account.getDni(), "El número de Dni debería ser correcto");
    }

    @Test
    public void testDeposit_validAmount() throws InvalidCharacterException {
        double initialAmount = account.getAmount();
        double depositAmount = 100.0;

        account.deposit(depositAmount);
        double newAmount = account.getAmount();

        assertEquals(initialAmount + depositAmount, newAmount, "La cantidad de la cuenta después del depósito debería ser correcta");
    }

    @Test
    public void testDeposit_negativeAmount() {
        assertThrows(InvalidCharacterException.class, () -> account.deposit(-100.0));
    }

    @Test
    public void testWithdraw_exceedingAmount() {
        double initialAmount = account.getAmount();
        double withdrawAmount = initialAmount + 100.0;

        try {
            account.withdraw(withdrawAmount);
        } catch (InvalidCharacterException e) {
            // Este bloque está vacío porque queremos que el test siga corriendo
            // incluso si se lanza la excepción.
        }

        double newAmount = account.getAmount();
        assertEquals(initialAmount, newAmount, "El saldo de la cuenta no debería cambiar si intentamos retirar una cantidad que supera el saldo disponible");
    }

    @Test
    public void testWithdraw_exactAmount() throws InvalidCharacterException {
        double initialAmount = account.getAmount();

        account.withdraw(initialAmount);
        double newAmount = account.getAmount();

        assertEquals(0, newAmount, "Deberías ser capaz de retirar exactamente la cantidad que tienes en la cuenta");
    }


}
