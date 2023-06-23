package Exceptions;

public class CloseCashierException extends Throwable {
	public CloseCashierException() {
		System.out.println("No se puede cerrar una caja si no hay ninguna abierta");
	}

}
