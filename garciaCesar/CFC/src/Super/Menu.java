package Super;

import Exceptions.OptionNotValidException;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	ArrayList<String>options;

	public Menu() {
		this.options = new ArrayList<>();
	    this.addOption("Añade una nueva caja");
		this.addOption("Cierra una caja");
		this.addOption("Ver cajas actuales");
		this.addOption("Enseña el resumen del dia");
		this.addOption("Simula la llegada de un cliente");
		this.addOption("Simula la jornada completa");
		this.addOption("Salir");
	}

	public void addOption(String option) {
		this.options.add(option);
	}
	public void showMenu() {
		int cont=1;
		for (String option : options) {
			System.out.println(cont+"."+option);
			cont++;
		}
	}

	public int selectOption() throws OptionNotValidException {
		Scanner scanner = new Scanner(System.in);
		int optionSelected = scanner.nextInt();
		int cont=1;

		for (String option : options) {
			if(optionSelected==cont){
				return optionSelected;
			}
			cont++;
		}

		throw new OptionNotValidException();
	}
}
