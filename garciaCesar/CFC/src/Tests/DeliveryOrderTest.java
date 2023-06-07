package Tests;

import Orders.DeliveryOrder;
import org.junit.Assert;
import org.junit.Test;

public class DeliveryOrderTest {

	@Test
	public void testIsDelivery() {
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		boolean expected = true;
		boolean actual = deliveryOrder.isDelivery();
		System.out.println("Esperado: " + expected);
		System.out.println("Actual: " + actual);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNumberOfItems() {
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		int expectedMin = 25;
		int expectedMax = 50;
		int numberOfItems = deliveryOrder.numberOfItems();
		int actual = deliveryOrder.getNumItems();
		System.out.println("Rango esperado: " + expectedMin + " - " + expectedMax);
		System.out.println("Número de elementos actual: " + numberOfItems);
		System.out.println("Número de elementos almacenado actual: " + actual);
		Assert.assertTrue(numberOfItems >= expectedMin && numberOfItems <= expectedMax);
		Assert.assertEquals(numberOfItems, actual);
	}
}