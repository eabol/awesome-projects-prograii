package Orders;
import Cashiers.NormalCashier;
public class DeliveryOrder extends Order implements Delivery{
	public boolean isDelivery;
	public DeliveryOrder() {
		isDelivery =true;
		this.setNumItems(numberOfItems());
	}

	@Override
	public boolean isDelivery() {
		return false;
	}
	public int numberOfItems(){
		numItems=(int)(Math.random()*50+1);
		if (numItems<25){
			numItems= numItems+25;
		}
		return  numItems;
	}




}
