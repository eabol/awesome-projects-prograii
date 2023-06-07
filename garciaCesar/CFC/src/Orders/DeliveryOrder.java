package Orders;

public class DeliveryOrder extends Order implements Delivery {

	private boolean isDelivery;

	public DeliveryOrder() {
		isDelivery = true;
		this.setNumItems(numberOfItems());
	}

	@Override
	public boolean isDelivery() {
		return isDelivery;
	}

	public int numberOfItems() {
		numItems = (int) (Math.random() * 50 + 1);
		if (numItems < 25) {
			numItems += 25;
		}
		return numItems;
	}
}