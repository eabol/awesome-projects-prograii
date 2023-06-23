package Tests;

import Exceptions.CloseCashierException;
import Exceptions.OpenCashierException;
import Orders.DeliveryOrder;
import Orders.NormalOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Super.Supermarket;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SupermarketTest {

	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
Supermarket supermarket ;
	@Before
	public void setUp() {
		supermarket = new Supermarket();
		System.setOut(originalOut);
	}

	@Test
	public void testAddCashier() {

		int initialCashierCount = supermarket.getCashiers().size();
		supermarket.addCashier();
		int updatedCashierCount = supermarket.getCashiers().size();

		// Comprobamos que se agregó correctamente una caja
		Assert.assertEquals(initialCashierCount + 1, updatedCashierCount);
		System.out.println("Se espera: " + (initialCashierCount + 1) + " cajas");
		System.out.println("Actual: " + updatedCashierCount + " cajas");
	}

	@Test
	public void testAddCashierWhenMaxCashiersReached() {

		int maxCashiers = 8;
		for (int i = 0; i < maxCashiers; i++) {
			supermarket.addCashier();
		}

		int initialCashierCount = supermarket.getCashiers().size();
		supermarket.addCashier();
		int updatedCashierCount = supermarket.getCashiers().size();

		// Comprobamos que no se agregó una caja adicional al alcanzar el límite máximo
		Assert.assertEquals(maxCashiers, initialCashierCount);
		Assert.assertEquals(maxCashiers, updatedCashierCount);
		System.out.println("Se espera: " + maxCashiers + " cajas (límite máximo)");
		System.out.println("Actual: " + updatedCashierCount + " cajas");
	}

	@Test
	public void testCloseCashier() {

		int initialCashierCount = supermarket.getCashiers().size();
		supermarket.closeCashier();
		int updatedCashierCount = supermarket.getCashiers().size();

		// Comprobamos que se cerró correctamente una caja
		Assert.assertEquals(initialCashierCount - 1, updatedCashierCount);
		System.out.println("Se espera: " + (initialCashierCount - 1) + " cajas");
		System.out.println("Actual: " + updatedCashierCount + " cajas");
	}

	@Test
	public void testNextMinute() {

		try {
			supermarket.nextMinute(supermarket.getCashiers());
			// Verificar que no se lanzó ninguna excepción
			Assert.assertTrue(true);
		} catch (Exception e) {
			// En caso de excepción inesperada, fallar el test
			Assert.fail("Se produjo una excepción inesperada: " + e.getMessage());
		}
	}

	@Test
	public void testSummary() {

		try {
			supermarket.summary();
			// Verificar que no se lanzó ninguna excepción
			Assert.assertTrue(true);
		} catch (Exception e) {
			// En caso de excepción inesperada, fallar el test
			Assert.fail("Se produjo una excepción inesperada: " + e.getMessage());
		}
	}

	@Test
	public void testSimulateArrival() {

		try {
			supermarket.simulateArrival();
			// Verificar que no se lanzó ninguna excepción
			Assert.assertTrue(true);
		} catch (Exception e) {
			// En caso de excepción inesperada, fallar el test
			Assert.fail("Se produjo una excepción inesperada: " + e.getMessage());
		}
	}

	@Test
	public void testSimulateDay() {
	
		try {
			supermarket.simulateDay();
			// Verificar que no se lanzó ninguna excepción
			Assert.assertTrue(true);
		} catch (Exception e) {
			// En caso de excepción inesperada, fallar el test
			Assert.fail("Se produjo una excepción inesperada: " + e.getMessage());
		}
	}
}