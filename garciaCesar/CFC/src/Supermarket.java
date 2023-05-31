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
		cashiers.add(new FastCashier(3));
	}
	public void begin() {
		for (int hours = 9; hours < 21; hours++) {
			for (int minutes = 0; minutes < 60; minutes++){

				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("Hour: " +(hours<10?"0"+hours:hours) + ":" + (minutes<10?"0"+minutes:minutes));
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("");
				getAnyOrder();
				nextMinute();
				
			}
		}
	}


	public void getAnyOrder() {
			int probablity = (int)(Math.random()*100+1);
			if (probablity<=40){
				queue.addOrder(new NormalOrder());
			}
			if (probablity>=90){
				queue.addOrder(new DeliveryOrder());
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
				System.out.println("caja "+ cashier.getNumber() + "le quedan por procesar " + cashier.getActualItems() + " productos");
			}
			else {
				System.out.println(cashier.getNumber() + "closed");
			}
		}
	}
	public void summary() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Resumen cierre de tienda");
		System.out.println("Clientes atendidos: " + (NormalCashier.getClientsServed() + FastCashier.getClientsServed()));
		System.out.println("Productos vendidos: " + (NormalCashier.getNumItemsProcessed() + FastCashier.getNumItemsProcessed()));
		//System.out.println("Clientes sin atender en la cola: " + (NormalCashier.getPeopleInQueue() + DeliveryOrder.getPeopleInQueue()));
		//System.out.println("Minutos sin cola: " + (NormalCashier.getMimutesWithoutQueue() + FastCashier.getMimutesWithoutQueue()));
		System.out.println("-----------------------------------------------------------------------------");
	}

}
