package Cashiers;

import Orders.Order;

public abstract class Cashier {
	protected static int numItemsProcessed = 0;
	protected static int clientsServed = 0;
	protected int number;
	protected State state;
	protected int actualItems = 0;


	public Cashier(int number) {
		this.number = number;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getActualItems() {
		return actualItems;
	}
	public void setActualItems(int actualItems) {
		this.actualItems = actualItems;
	}
	public void insertOrder(Order order) {
		numItemsProcessed += order.getNumItems();
		clientsServed++;
		actualItems = order.getNumItems();
		this.state = State.BUSY;
	}
	public void processOrder() {
		actualItems--;
		if (actualItems <= 0) {
			this.state = State.OPEN;
		}

	}



}
