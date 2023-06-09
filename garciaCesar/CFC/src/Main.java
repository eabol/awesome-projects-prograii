import Exceptions.OptionNotValidException;
import Super.Menu;
import Super.Supermarket;

public class Main {
	public static void main(String[] args) {
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
						System.out.println("Saliendo del sistema...");
						System.exit(0);
						break;
				}

			} catch (OptionNotValidException e) {
				System.out.println(e.getMessage());
			}

		}while (true);


	}
}
