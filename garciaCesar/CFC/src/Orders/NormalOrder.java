package Orders;

import Cashiers.NormalCashier;

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
	public void probablityOfOrder(){
		int probablity = (int)(Math.random()*100+1);
		if (probablity<=40){
			products = (int)(Math.random()*15+1);
			if (products<5){
				products= products+5;
			}
		}
	}
	@Override
	public void processOrder(){
		if ((peopleInQueue > 0) && NormalCashier.isOpen()){
			peopleInQueue--;
		}
	}


}
