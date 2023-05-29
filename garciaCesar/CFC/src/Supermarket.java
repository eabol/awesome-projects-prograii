import Cashiers.Cashier;
import Cashiers.FastCashier;
import Cashiers.NormalCashier;
import Orders.DeliveryOrder;
import Orders.NormalOrder;
import Orders.Order;

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
				System.out.println("Hour: " + hours + ":" + minutes);
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("");
				getAnyOrder();


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
	public void processOrder() {
		for (Cashier cashier : cashiers) {
			if (cashier.isOpen()) {
				if (queue.getQueueSize() > 0) {
					cashier.processOrder(queue.getQueue().get(0));
					queue.removePerson();
				}
			}
		}
	}
	public void summary() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Resumen cierre de tienda");
		System.out.println("Clientes atendidos: " + (NormalCashier.getClientsServed() + FastCashier.getClientsServed()));
		System.out.println("Productos vendidos: " + (NormalCashier.getNumItemsProcessed() + FastCashier.getNumItemsProcessed()));
		//System.out.println("Clientes sin atender en la cola: " + (NormalCashier.getPeopleInQueue() + DeliveryOrder.getPeopleInQueue()));
		System.out.println("Minutos sin cola: " + (NormalCashier.getMimutesWithoutQueue() + FastCashier.getMimutesWithoutQueue()));
		System.out.println("-----------------------------------------------------------------------------");
	}



}
