package Super;

import Cashiers.Cashier;
import Cashiers.FastCashier;
import Cashiers.NormalCashier;
import Cashiers.State;
import Exceptions.CloseCashierException;
import Exceptions.OpenCashierException;
import Orders.DeliveryOrder;
import Orders.NormalOrder;

import java.util.ArrayList;

public class Supermarket {
	private ArrayList <Cashier> cashiers;
	Queue queue;
	public Supermarket() {
		this.queue = new Queue();
		cashiers = new ArrayList<Cashier>();
		cashiers.add(new NormalCashier(1));
		cashiers.add(new NormalCashier(2));
		cashiers.add(new NormalCashier(3));
		cashiers.add(new FastCashier(4));
	}
	public void begin() {
		openSupermarket();
		for (int hours = 9; hours < 21; hours++) {
			for (int minutes = 0; minutes < 60; minutes++){

				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("Hour: " +(hours<10?"0"+hours:hours) + ":" +(minutes<10?"0"+minutes:minutes));
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("");
				getAnyOrder();
				nextMinute(cashiers);
				
			}
		}
		closedSupermarket();
	}

	public void closedSupermarket() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("El supermercado ha cerrado");
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void openSupermarket() {
		// Text Journey:
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Jornada: 09:00 - 21:00");
		System.out.println("-----------------------------------------------------------------------------");
	}

	public void getAnyOrder() {
			int probablity = (int)(Math.random()*100+1);
			if (probablity<=20){
				System.out.println("Llega un cliente normal");
				queue.addOrder(new NormalOrder());

			}
			if (probablity>=95){
				System.out.println("Llega un cliente con pedido a domicilio");
				queue.addOrder(new DeliveryOrder());

			}
			if (probablity>20 && probablity<95){
				System.out.println("No llega ningun cliente");
			}
	}
	public void nextMinute(ArrayList<Cashier> cashiers) {
		for (Cashier cashier : cashiers) {
			if (cashier.getState() == State.OPEN) {
				if (queue.getQueueSize() > 0) {
					cashier.insertOrder(queue.getQueue().get(0));
					queue.removePerson();
					cashier.setState(State.BUSY);
				}
			} else if (cashier.getState() == State.BUSY && cashier.getActualItems() == 0) {
				cashier.setState(State.OPEN);
				cashier.setClientsServed(cashier.getClientsServed() + 1);
			} else if (cashier.getState() == State.BUSY && cashier.getActualItems() > 0) {
				cashier.processOrder();
				System.out.println("A la caja " + cashier.getNumber() + " le quedan por procesar " + cashier.getActualItems() + " productos");
			} else if (cashier.getState() == State.CLOSED) {
				System.out.println("La caja " + cashier.getNumber() + " está cerrada");
			}

			if (queue.getQueueSize() >= 15 && cashier instanceof FastCashier && cashier.getState() == State.CLOSED) {
				System.out.println("La caja rápida se ha abierto");
				cashier.setState(State.OPEN);
				cashier.insertOrder(queue.getQueue().get(0));
				queue.removePerson();
			} else if (queue.getQueueSize() <= 15 && cashier instanceof FastCashier && cashier.getState() == State.OPEN) {
				System.out.println("La caja rápida se ha cerrado");
				cashier.setState(State.CLOSED);
			}
		}

	}
	public void summary() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Resumen cierre de tienda");
		System.out.println("Clientes atendidos: " + cashiers.get(0).getClientsServed());
		System.out.println("Productos vendidos: " + (NormalCashier.getNumItemsProcessed() + FastCashier.getNumItemsProcessed()));
		System.out.println("Clientes sin atender en la cola al final de la jornada: " + (queue.getQueueSize()));
		System.out.println("-----------------------------------------------------------------------------");
	}

	public void addCashier() {
		try {
			if (cashiers.size() >= 8) {
				throw new OpenCashierException();
			}
				cashiers.add(new NormalCashier(cashiers.size() + 1));
				System.out.println("Caja normal añadida");
		} catch ( OpenCashierException e) {
			System.out.println(e.getMessage());
		}
	}
	public void closeCashier() {
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
	public void showCashiers() {
		for (Cashier cashier : cashiers) {
			System.out.println("Caja " + cashier.getNumber() + " " + cashier.getState());
		}
	}
	public void simulateArrival() {
		System.out.println("Hay una probabilidad de que llegue un cliente a la cola...");
		getAnyOrder();
	}
	public void simulateDay() {
		begin();
	}

	public ArrayList<Cashier> getCashiers() {
		return  cashiers;
	}
}
