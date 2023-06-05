import Cashiers.Cashier;
import Cashiers.FastCashier;
import Cashiers.NormalCashier;
import Exceptions.CloseCashierException;
import Exceptions.OpenCashierException;
import Exceptions.OptionNotValidException;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private ArrayList<Cashier> cashiers;

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
	public void addCashier(ArrayList<Cashier> cashiers) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Qué tipo de caja desea añadir?");
		System.out.println("1. Caja normal");
		System.out.println("2. Caja rápida");
		int option = scanner.nextInt();
		try {
			if (cashiers.size() >= 8) {
				throw new OpenCashierException();
			}

			if (option == 1) {
				cashiers.add(new NormalCashier(cashiers.size() + 1));
				System.out.println("Caja normal añadida");
			} else if (option == 2) {
				cashiers.add(new FastCashier(cashiers.size() + 1));
				System.out.println("Caja rápida añadida");
			} else {
				throw new OptionNotValidException();
			}
		} catch (OptionNotValidException | OpenCashierException e) {
			System.out.println(e.getMessage());
		}
	}
	public void showSummary() {
		Supermarket supermarket = new Supermarket();
		supermarket.summary();
	}
	public void simulateClient() {
		Supermarket supermarket = new Supermarket();
		System.out.println("Hay una probabilidad de que llegue un cliente a la cola...");
		supermarket.getAnyOrder();
	}
	public void simulateDay(ArrayList<Cashier> cashiers) {
		Supermarket supermarket = new Supermarket();
		supermarket.begin(cashiers);
	}

}
