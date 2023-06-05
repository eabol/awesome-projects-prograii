import Orders.Order;

import java.util.ArrayList;

public class Queue {
	private ArrayList<Order> queue ;
	public Queue() {
		this.queue = new ArrayList<Order>();
	}
	public ArrayList<Order> getQueue() {
		return queue;
	}
	public void setQueue(ArrayList<Order> queue) {
		this.queue = queue;
	}

	public void addOrder(Order order) {
		this.queue.add(order);
	}
	public void removePerson() {
		this.queue.remove(0);
	}
	public int getQueueSize() {
		return this.queue.size();
	}


}
