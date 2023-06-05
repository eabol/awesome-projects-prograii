import Exceptions.OptionNotValidException;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
	/*	ArrayList<Cashier> cashiers = new ArrayList<Cashier>();
		cashiers.add(new NormalCashier(1));
		cashiers.add(new NormalCashier(2));
		cashiers.add(new NormalCashier(3));
		cashiers.add(new FastCashier(4));*/
		Supermarket supermarket=new Supermarket();

		Menu menu = new Menu();
		System.out.println("Bienvenido al menu del gerente del supermercado");
		int option=-1;
		do {
			menu.showMenu();
			try {
				option = menu.selectOption();
				System.out.println(option);
				switch (option){
					case 1:
						supermarket.addCashier();
						break;
					case 2:
						supermarket.closeCashier();
						break;
					case 3:
						supermarket.showCashiers();
						break;
					case 4:
						supermarket.summary();
						break;
					case 5:
						supermarket.simulateArrival();
						break;
					case 6:
						supermarket.simulateDay();
						break;
					case 7:
						System.out.println("Hasta luego");
						System.exit(0);
						break;
				}

			} catch (OptionNotValidException e) {
				System.out.println(e.getMessage());
			}

		}while (true);


	}
}
