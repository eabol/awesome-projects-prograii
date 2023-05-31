package Cashiers;

public class NormalCashier extends Cashier implements Status{
	public boolean state;
	public NormalCashier(int number) {
		super(number);
		this.state=true;
	}

	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public void close() {

	}
}
