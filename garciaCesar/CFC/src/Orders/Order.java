package Orders;

import Cashiers.FastCashier;
import Cashiers.NormalCashier;



public abstract class Order {
	protected static int peopleInQueue = 0;
	protected int numItems = 0;

	public Order() {

	}
	public static int getPeopleInQueue() {
		return peopleInQueue;
	}
	public void setPeopleInQueue(int peopleInQueue) {
		this.peopleInQueue = peopleInQueue;
	}
	public int getNumItems() {
		return numItems;
	}
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
	public void processOrder(){
		if ((peopleInQueue > 0) && (NormalCashier.isOpen())){
			peopleInQueue--;
		}
	}
	public void processDelivery(){
		if ((peopleInQueue > 15)){
			peopleInQueue--;
			FastCashier.open();
		}
	}

}
