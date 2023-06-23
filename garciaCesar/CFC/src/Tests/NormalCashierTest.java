package Tests;

import static org.junit.Assert.assertEquals;

import Cashiers.Cashier;
import Cashiers.NormalCashier;
import Cashiers.State;
import Orders.NormalOrder;
import Orders.Order;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NormalCashierTest {

	private NormalCashier cashier;

	@Before
	public void setUp() {
		cashier = new NormalCashier(1);
	}

	@Test
	public void testInitialState() {
		assertEquals(0, Cashier.getNumItemsProcessed());
		assertEquals(0, Cashier.getClientsServed());
		assertEquals(1, cashier.getNumber());
		assertEquals(State.OPEN, cashier.getState());
		assertEquals(0, cashier.getActualItems());
		// Imprimir los resultados esperados y actuales
		System.out.println("Resultados esperados:");
		System.out.println("Num Items Processed: 0");
		System.out.println("Clients Served: 0");
		System.out.println("Number: 1");
		System.out.println("State: OPEN");
		System.out.println("Actual Items: 0");
		System.out.println();

		System.out.println("Resultados actuales:");
		System.out.println("Num Items Processed: " + Cashier.getNumItemsProcessed());
		System.out.println("Clients Served: " + Cashier.getClientsServed());
		System.out.println("Number: " + cashier.getNumber());
		System.out.println("State: " + cashier.getState());
		System.out.println("Actual Items: " + cashier.getActualItems());
	}

	@Test
	public void testInsertOrder() {
		Order order = new NormalOrder(5);

		cashier.insertOrder(order);

		assertEquals(5, cashier.getActualItems());
		assertEquals(State.BUSY, cashier.getState());

		System.out.println("Después de insertar una orden:");
		System.out.println("Resultados esperados:");
		System.out.println("Actual items: 5");
		System.out.println("State: BUSY");
		System.out.println();
		System.out.println("Resultados actuales:");
		System.out.println("Actual items: " + cashier.getActualItems());
		System.out.println("State: " + cashier.getState());
		System.out.println();
	}
}