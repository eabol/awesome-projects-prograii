import Cashiers.Cashier;
import Cashiers.FastCashier;
import Cashiers.NormalCashier;
import Exceptions.OptionNotValidException;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		ArrayList<Cashier> cashiers = new ArrayList<Cashier>();
		cashiers.add(new NormalCashier(1));
		cashiers.add(new NormalCashier(2));
		cashiers.add(new FastCashier(3));
		Menu menu = new Menu();
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
							menu.showCashiers(cashiers);
							break;
						case 3:
							menu.showSummary(cashiers);
							break;
						case 4:
							menu.simulateClient();
							break;
						case 5:
							menu.simulateDay();
							break;
						case 6:
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
