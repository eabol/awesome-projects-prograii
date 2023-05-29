import Cashiers.Cashier;
import Cashiers.FastCashier;
import Cashiers.NormalCashier;
import Orders.DeliveryOrder;
import Orders.NormalOrder;

public class Time {
	private int minutes;
	private int hours;
	private int lastHour=21;
	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	public int getMinutes() {
		return minutes;
	}
	public int getHours() {
		return hours;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public void addMinutes(int minutes) {
		this.minutes += minutes;
	}
	public void printTime() {
		for (hours = 9; hours < lastHour; hours++) {
			for (minutes = 0; minutes < 60; minutes++){
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("Hour: " + hours + ":" + minutes);
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("");
			}
		}
	}
	public void summary() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Resumen cierre de tienda");
		System.out.println("Clientes atendidos: " + (NormalCashier.getClientsServed() + FastCashier.getClientsServed()));
		System.out.println("Productos vendidos: " + (NormalCashier.getNumItemsProcessed() + FastCashier.getNumItemsProcessed()));
		System.out.println("Clientes sin atender en la cola: " + (NormalOrder.getPeopleInQueue() + DeliveryOrder.getPeopleInQueue()));
		System.out.println("Minutos sin cola: " + (NormalCashier.getMimutesWithoutQueue() + FastCashier.getMimutesWithoutQueue()));
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void closedSupermarket() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Supermarket is closed");
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void journey() {
		// Text Journey:
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Journey: 09:00 - 21:00");
		System.out.println("-----------------------------------------------------------------------------");
	}

}
