import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proyectoterraques.exceptions.InvalidCharacterException;
import proyectoterraques.source.CreditAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditAccountTest {
    private CreditAccount account;

    @BeforeEach
    public void setup() {
        account = new CreditAccount("1234567890","76548742A");
    }

    @Test
    public void testAccountNumber() {
        assertEquals("1234567890", account.getAccountNumber(), "El número de cuenta debería ser correcto");
    }
    @Test
    public void testGetDni() {
        assertEquals("76548742A", account.getDni(), "El número de DNI debería ser correcto");
    }

    @Test
    public void testDeposit_validAmount() throws InvalidCharacterException {
        double initialAmount = account.getAmount();
        double depositAmount = 100.0;

        account.deposit(depositAmount);
        double newAmount = account.getAmount();

        assertEquals(initialAmount + depositAmount, newAmount, "El saldo de la cuenta debería incrementar después de un depósito válido");
    }

    @Test
    public void testWithdraw_validAmount() throws InvalidCharacterException {
        double initialAmount = account.getAmount();
        double withdrawAmount = initialAmount;

        account.withdraw(withdrawAmount);
        double newAmount = account.getAmount();

        assertEquals(initialAmount - withdrawAmount, newAmount, "El saldo de la cuenta debería disminuir después de un retiro válido");
    }

    @Test
    public void testWithdraw_exceedingAmount() throws InvalidCharacterException {
        double initialAmount = account.getAmount();
        double withdrawAmount = initialAmount + 100.0;

        account.withdraw(withdrawAmount);
        double newAmount = account.getAmount();
        double expectedDebt = Math.abs(newAmount) * (account.interest/100);

        assertEquals(-withdrawAmount, newAmount, "El saldo de la cuenta debería ser negativo después de un retiro que excede el saldo");
        assertEquals(expectedDebt, account.getDebt(), "La deuda debería ser la cantidad correcta después de un retiro que excede el saldo");
    }


    @Test
    public void testDeposit_negativeAmount() {
        assertThrows(InvalidCharacterException.class, () -> {
            account.deposit(-100.0);
        }, "Debería lanzar una excepción al intentar depositar una cantidad negativa");
    }
}
