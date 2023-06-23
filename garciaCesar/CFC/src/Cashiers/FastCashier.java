package Cashiers;

public class FastCashier extends Cashier{

	public FastCashier( int number) {
		super(number);
		this.state = State.CLOSED;
	}

	@Override
	public void processOrder() {
		actualItems-=2;
		if (actualItems <= 0) {
			this.state = State.OPEN;
		}
	}
}
