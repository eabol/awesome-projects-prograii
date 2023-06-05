package Exceptions;

public class OpenCashierException extends Throwable {
	public OpenCashierException() {
		System.out.println("No se pueden abrir mas de 8 cajas");
	}

}
