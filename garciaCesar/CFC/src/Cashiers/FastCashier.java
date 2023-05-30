package Cashiers;

public class FastCashier extends Cashier implements Status{
	public boolean open;
	public FastCashier( int number) {
		super(number);
		this.open = false;
	}


	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public static void open() {
		this.open = true;

	}

	@Override
	public void close() {
		this.open = false;

	}


}
