package Orders;

public abstract class Order {
	protected int numItems = 0;

	public Order() {

	}

	public int getNumItems() {
		return numItems;
	}
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

}
