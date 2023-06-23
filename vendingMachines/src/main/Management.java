package main;

import exceptions.FailureException;
import exceptions.JamException;
import interfaces.Incidence;

import java.util.ArrayList;

public class Management {
    private ArrayList<Machine> machines;
    private ArrayList<Incidence> incidences;

    public Management() {
        this.machines = new ArrayList<Machine>();
        this.incidences = new ArrayList<Incidence>();
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Cookies", 1.5, 1, 10));
        products.add(new Product("Chocolate", 1.1, 2, 10));
        products.add(new Product("Drink", 1.05, 3, 10));
        products.add(new Product("Sandwich", 1.75, 4, 10));
        products.add(new Product("Candies", 0.95, 5, 10));


        Money m1 = new Money();
        m1.insert(0.05f, 10);
        m1.insert(0.2f, 20);
        m1.insert(0.5f, 20);
        m1.insert(1f, 10);
        m1.insert(2f, 5);
        m1.insert(5f, 2);
        m1.insert(10f, 1);
        m1.insert(20f, 3);
        Machine machine1 = new Machine(1);
        machine1.setProducts(products);
        machine1.setMoney(m1);
        this.machines.add(machine1);

        Money m2 = new Money();
        m1.insert(0.05f, 20);
        m1.insert(0.2f, 30);
        m1.insert(0.5f, 25);
        m1.insert(1f, 15);
        m1.insert(2f, 7);
        m1.insert(5f, 3);
        m1.insert(10f, 2);
        m1.insert(20f, 3);
        Machine machine2 = new Machine(2);
        machine2.setProducts(products);
        machine2.setMoney(m2);
        this.machines.add(machine2);

        Money m3 = new Money();
        m1.insert(0.05f, 15);
        m1.insert(0.2f, 10);
        m1.insert(0.5f, 30);
        m1.insert(1f, 12);
        m1.insert(2f, 5);
        m1.insert(5f, 3);
        m1.insert(10f, 1);
        m1.insert(20f, 3);
        Machine machine3 = new Machine(3);
        machine3.setProducts(products);
        machine3.setMoney(m3);
        this.machines.add(machine3);
    }

    public void screen(int machine) {
        for (Machine value : this.machines) {
            if (value.getId() == machine) {
                value.machineReport();
            }
        }
    }

    public void paymentManagement(int machine, int idProduct, Money clientMoney) {
        Money change = null;
        try {
            change = this.machines.get(machine).buyProduct(clientMoney, idProduct);
            System.out.println(change.getTotal() + "euros are returned to the client");
        } catch (JamException e) {
            System.out.println(e.getMessage());
        } catch (FailureException e) {
            this.incidences.add(e);
            System.out.println(e.getMessage());
        }
    }
}
