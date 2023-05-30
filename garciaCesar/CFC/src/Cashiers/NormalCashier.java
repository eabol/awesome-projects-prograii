package Cashiers;

public class NormalCashier extends Cashier implements Status{
	public boolean open;
	public NormalCashier(int number) {
		super(number);
		this.open=true;
	}



	@Override
	public boolean isOpen() {
		return this.open;
	}

	@Override
	public void open() {
		this.open=true;
	}

	@Override
	public void close() {
		this.open=false;

	}
}
