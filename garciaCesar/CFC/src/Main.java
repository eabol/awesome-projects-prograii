import Cashiers.Cashier;
import Cashiers.FastCashier;
import Cashiers.NormalCashier;
import Exceptions.OptionNotValidException;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		ArrayList<Cashier> cashiers = new ArrayList<Cashier>();
		cashiers.add(new NormalCashier(1));
		cashiers.add(new NormalCashier(2));
		cashiers.add(new NormalCashier(3));
		cashiers.add(new FastCashier(4));
		Menu menu = new Menu();
		System.out.println("Bienvenido al menu del gerente del supermercado");
		menu.showMenu();
		Scanner scanner = new Scanner(System.in);
		try {
			int option = 0;
			while (true) {
				if (scanner.hasNextInt()) {
					option = scanner.nextInt();
					switch (option) {
						case 1:
							menu.addCashier(cashiers);
							break;
						case 2:
							menu.closeCashier(cashiers);
							break;
						case 3:
							menu.showCashiers(cashiers);
							break;
						case 4:
							menu.showSummary(cashiers);
							break;
						case 5:
							menu.simulateClient();
							break;
						case 6:
							menu.simulateDay();
							break;
						case 7:
							System.out.println("Saliendo del menu...");
							System.exit(0);
						default:
							throw new OptionNotValidException();
					}
				} else {
					throw new OptionNotValidException();
				}
				menu.showMenu();
			}
		} catch (OptionNotValidException e) {
			System.out.println(e.getMessage());
		}
	}
}
