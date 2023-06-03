import Cashiers.Cashier;
import Cashiers.NormalCashier;

import java.util.ArrayList;

public class Menu {
	public void showMenu() {
		System.out.println("1. Añade una nueva caja");
		System.out.println("2. Ver cajas actuales");
		System.out.println("3. Enseña el resumen del dia");
		System.out.println("4. Simula la llegada de un cliente");
		System.out.println("5. Simula la jornada completa");
		System.out.println("6. Salir");
	}
	public void showCashiers(ArrayList<Cashier> cashiers) {
		for (Cashier cashier : cashiers) {
			System.out.println("Caja " + cashier.getNumber() + " " + cashier.getState());
		}
	}
	public void showSummary(ArrayList<Cashier> cashiers) {
		Supermarket supermarket = new Supermarket();
		supermarket.summary();
	}
	public void simulateClient() {
		Supermarket supermarket = new Supermarket();
		supermarket.getAnyOrder();
	}
	public void simulateDay() {
		Supermarket supermarket = new Supermarket();
		supermarket.begin();
		supermarket.summary();
	}
	public void addCashier(ArrayList<Cashier> cashiers) {
		int number = cashiers.size()+1;
		cashiers.add(new NormalCashier(number));
	}
}
