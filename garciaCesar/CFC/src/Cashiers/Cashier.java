package Cashiers;

import Orders.Order;

public abstract class Cashier {
	protected static int numItemsProcessed = 0;
	protected static int clientsServed = 0;
	protected static int mimutesWithoutQueue = 0;
	protected int number;
	protected boolean open;

	public Cashier(int number) {
		this.number = number;
	}
	public boolean isOpen() {
		return open;
	}
	public void open() {
		this.open = true;
	}

	public static int getNumItemsProcessed() {
		return numItemsProcessed;
	}
	public void setNumItemsProcessed(int numItemsProcessed) {
		this.numItemsProcessed = numItemsProcessed;
	}
	public static int getClientsServed() {
		return clientsServed;
	}
	public void setClientsServed(int clientsServed) {
		this.clientsServed = clientsServed;
	}
	public static int getMimutesWithoutQueue() {
		return mimutesWithoutQueue;
	}
	public void setMimutesWithoutQueue(int mimutesWithoutQueue) {
		this.mimutesWithoutQueue = mimutesWithoutQueue;
	}
	public void processOrder(Order order) {
		clientsServed++;
		numItemsProcessed += order.getNumItems();

	}



}
