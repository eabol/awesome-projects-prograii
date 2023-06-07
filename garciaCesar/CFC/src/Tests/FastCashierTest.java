package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;



import Cashiers.Cashier;
import Orders.NormalOrder;
import org.junit.Before;

import Cashiers.FastCashier;
import Cashiers.State;
import Orders.Order;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FastCashierTest {

	private FastCashier cashier;

	@Before
	public void setUp() {
		cashier = new FastCashier(1);
	}

	@Test
	public void testInitialState() {
		assertEquals(0, Cashier.getNumItemsProcessed());
		assertEquals(0, Cashier.getClientsServed());
		assertEquals(1, cashier.getNumber());
		assertEquals(State.CLOSED, cashier.getState());
		assertEquals(0, cashier.getActualItems());
		// Imprimir los resultados esperados y actuales
		System.out.println("Resultados esperados:");
		System.out.println("Num Items Processed: 0");
		System.out.println("Clients Served: 0");
		System.out.println("Number: 1");
		System.out.println("State: CLOSED");
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
	public void testProcessOrder() {
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


		// Procesar dos elementos
		cashier.processOrder();
		assertEquals(3, cashier.getActualItems());
		assertEquals(State.BUSY, cashier.getState());

		System.out.println("Después de procesar 2 elementos:");
		System.out.println("Resultados esperados:");
		System.out.println("Actual items: 3");
		System.out.println("State: BUSY");
		System.out.println();

		System.out.println("Resultados actuales:");
		System.out.println("Actual items: " + cashier.getActualItems());
		System.out.println("State: " + cashier.getState());
		System.out.println();

		cashier.processOrder();
		assertEquals(1, cashier.getActualItems());
		assertEquals(State.BUSY, cashier.getState());

		System.out.println("Después de procesar 2 elementos:");
		System.out.println("Resultados esperados:");
		System.out.println("Actual items: 1");
		System.out.println("State: BUSY");
		System.out.println();

		System.out.println("Resultados actuales:");
		System.out.println("Actual items: " + cashier.getActualItems());
		System.out.println("State: " + cashier.getState());
	}
}