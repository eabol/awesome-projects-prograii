package Orders;

public class NormalOrder extends Order{
	public NormalOrder() {
		this.setNumItems(numberOfItems());
	}

	public int numberOfItems(){
		numItems=(int)(Math.random()*15+1);
		if (numItems<5){
			numItems= numItems+5;
		}
		return  numItems;
	}



}
