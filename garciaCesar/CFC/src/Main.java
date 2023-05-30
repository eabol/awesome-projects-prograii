import Cashiers.Cashier;
import Cashiers.FastCashier;
import Cashiers.NormalCashier;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		ArrayList<Cashier> cashiers = new ArrayList<Cashier>();
		cashiers.add(new NormalCashier(1));
		cashiers.add(new NormalCashier(2));
		cashiers.add(new FastCashier(3));
		for (int hours = 9; hours < 21; hours++) {
			for (int minutes = 0; minutes < 60; minutes++){
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("Hour: " + hours + ":" + minutes);
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("");



			}
		}
	}

}
