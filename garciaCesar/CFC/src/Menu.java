import Cashiers.Cashier;
import Cashiers.NormalCashier;
import Exceptions.CloseCashierException;
import Exceptions.OpenCashierException;

import java.util.ArrayList;

public class Menu {
	public void showMenu() {
		System.out.println("Elige una opcion:");
		System.out.println("1. Añade una nueva caja");
		System.out.println("2. Cierra una caja abierta");
		System.out.println("3. Ver cajas actuales");
		System.out.println("4. Enseña el resumen del dia");
		System.out.println("5. Simula la llegada de un cliente");
		System.out.println("6. Simula la jornada completa");
		System.out.println("7. Salir");
	}
	public void showCashiers(ArrayList<Cashier> cashiers) {
		for (Cashier cashier : cashiers) {
			System.out.println("Caja " + cashier.getNumber() + " " + cashier.getState());
		}
	}
	public void closeCashier(ArrayList<Cashier> cashiers) {
		int number = cashiers.size();
		try {
			if (number == 0) {
				throw new CloseCashierException();
			} else {
				cashiers.remove(number - 1);
				System.out.println("Caja " + number + " cerrada");
			}
		} catch (CloseCashierException e) {
			System.out.println(e.getMessage());
		}
	}
	public void showSummary(ArrayList<Cashier> cashiers) {
		Supermarket supermarket = new Supermarket();
		supermarket.summary();
	}
	public void simulateClient() {
		Supermarket supermarket = new Supermarket();
		System.out.println("Hay una probabilidad de que llegue un cliente a la cola...");
		supermarket.getAnyOrder();
	}
	public void simulateDay() {
		Supermarket supermarket = new Supermarket();
		supermarket.begin();
	}
	public void addCashier(ArrayList<Cashier> cashiers) {
		int number = cashiers.size()+1;
		try {
			if (number > 7) {
				throw new OpenCashierException();
			} else {
				cashiers.add(new NormalCashier(number));
				System.out.println("Caja " + number + " abierta");
			}
		} catch (OpenCashierException e) {
			System.out.println(e.getMessage());
		}
	}
}
