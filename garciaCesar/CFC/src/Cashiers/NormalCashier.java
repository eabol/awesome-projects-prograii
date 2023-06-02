package Cashiers;

public class NormalCashier extends Cashier {

	public NormalCashier(int number) {
		super(number);
		this.state=State.OPEN;
	}




}
