package Tests;

import Orders.NormalOrder;
import org.junit.Assert;
import org.junit.Test;

public class NormalOrderTest {

	@Test
	public void testNumberOfItems() {
		NormalOrder normalOrder = new NormalOrder();
		int expectedMin = 5;
		int expectedMax = 15;
		int numberOfItems = normalOrder.numberOfItems();
		int actual = normalOrder.getNumItems();
		System.out.println("Rango esperado: " + expectedMin + " - " + expectedMax);
		System.out.println("Número de elementos actual: " + numberOfItems);
		System.out.println("Número de elementos almacenado actual: " + actual);
		Assert.assertTrue(numberOfItems >= expectedMin && numberOfItems <= expectedMax);
		Assert.assertEquals(numberOfItems, actual);
	}
}