import Cashiers.Cashier;
import Cashiers.FastCashier;
import Cashiers.NormalCashier;
import Cashiers.State;
import Orders.DeliveryOrder;
import Orders.NormalOrder;

import java.util.ArrayList;

public class Supermarket {
	private ArrayList <Cashier> cashiers;
	private Queue queue;
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
				nextMinute();
				
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
			if (probablity<=40){
				System.out.println("Llega un cliente normal");
				queue.addOrder(new NormalOrder());
			}
			if (probablity>=90){
				System.out.println("Llega un cliente con pedido a domicilio");
				queue.addOrder(new DeliveryOrder());
			}
			if (probablity>40 && probablity<90){
				System.out.println("No llega ningun cliente");
			}
	}
	public void nextMinute() {
		for (Cashier cashier : cashiers) {
			if (cashier.getState()== State.OPEN) {
				if (queue.getQueueSize() > 0) {
					cashier.insertOrder(queue.getQueue().get(0));
					queue.removePerson();
				}

			}else if (cashier.getState()== State.BUSY){
				cashier.processOrder();
				System.out.println("A la caja "+ cashier.getNumber() + " le quedan por procesar " + cashier.getActualItems() + " productos");
			}
			else{
				if (queue.getQueueSize() >= 15 && cashier instanceof FastCashier && cashier.getState()== State.CLOSED) {

					cashier.setState(State.OPEN);
					cashier.insertOrder(queue.getQueue().get(0));
					queue.removePerson();

				} else if (queue.getQueueSize() <=15 && cashier instanceof FastCashier && cashier.getState()== State.OPEN) {
					cashier.setState(State.CLOSED);
				}
				System.out.println("Caja: " + cashier.getNumber() + " cerrada");
			} if (queue.getQueueSize() == 0){
				queue.setMinutesWithoutQueue(queue.getMinutesWithoutQueue()+1);
			}
		}
	}
	public void summary() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Resumen cierre de tienda");
		System.out.println("Clientes atendidos: " + (NormalCashier.getClientsServed() + FastCashier.getClientsServed()));
		System.out.println("Productos vendidos: " + (NormalCashier.getNumItemsProcessed() + FastCashier.getNumItemsProcessed()));
		System.out.println("Clientes sin atender en la cola: " + (queue.getQueueSize()));
		System.out.println("Minutos sin cola: " + (queue.getMinutesWithoutQueue()));
		System.out.println("-----------------------------------------------------------------------------");
	}

}
