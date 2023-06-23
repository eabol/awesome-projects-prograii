import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proyectoterraques.source.Bank;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    Bank bank;

    @BeforeEach
    public void setup() {
        bank = new Bank("office1", "country1");
        bank.clients = new ArrayList<>();
        bank.accounts = new ArrayList<>();
    }

    @Test
    public void testGetClients_withNoClients() {
        bank.getClients();
        assertEquals(0, bank.clients.size(), "La lista de clientes debería estar vacía");
    }

    @Test
    public void testGetAccounts_withNoAccounts() {
        bank.getAccounts();
        assertEquals(0, bank.accounts.size(), "La lista de cuentas debería estar vacía");
    }
}
