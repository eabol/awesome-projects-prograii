package Basis;

import Exceptions.FailuireException;
import Exceptions.JamException;
import Interface.Incidence;

import java.util.ArrayList;

public class Managment {
    ArrayList<Machine> machines;
    ArrayList<Incidence> incidences;

    public Managment() {
        ArrayList<Product> products = new ArrayList<>();


        //introducción de  productos
        products.add(new Food("Biscuits",1.50, 1,10));
        products.add(new Food("Chocolate",1.10,2, 10));
        products.add(new Drinks("Basis.Drinks",1.05, 3,10));
        products.add(new Food("Sandwich",1.75, 4, 10));

        //introducción de monedas

        Money m1= new Money();
        m1.insetMoney(20, 10);
        m1.insetMoney(10,10);
        m1.insetMoney(5,10);
        m1.insetMoney(2,10);
        m1.insetMoney(1,10);
        m1.insetMoney(0.5F,10);
        m1.insetMoney(0.2F,10);
        m1.insetMoney(0.05F,10);
        Machine machine1= new Machine(1,m1);
        machine1.setProducts(products);
        this.machines.add(machine1);


        Money m2= new Money();
        m2.insetMoney(20, 10);
        m2.insetMoney(10,10);
        m2.insetMoney(5,10);
        m2.insetMoney(2,10);
        m2.insetMoney(1,10);
        m2.insetMoney(0.5F,10);
        m2.insetMoney(0.2F,10);
        m2.insetMoney(0.05F,10);
        Machine machine2= new Machine(1,m2);
        machine2.setProducts(products);
        this.machines.add(machine2);

        Money m3= new Money();
        m3.insetMoney(20, 10);
        m3.insetMoney(10,10);
        m3.insetMoney(5,10);
        m3.insetMoney(2,10);
        m3.insetMoney(1,10);
        m3.insetMoney(0.5F,10);
        m3.insetMoney(0.2F,10);
        m3.insetMoney(0.05F,10);
        Machine machine3= new Machine(1,m3);
        machine3.setProducts(products);
        this.machines.add(machine3);
    }

    public void menu(int idMachine){
        for (int i = 0; i < this.machines.size(); i++) {
            if (this.machines.get(i).getId()==idMachine){
                this.machines.get(i).listProducts();
            }
        }
    }

    public void buyProductMachine(int idMachine, int idProduct, Money money){
        Money change = null;

        for (int i = 0; i < this.machines.size(); i++) {
            if (this.machines.get(i).getId()==idMachine){
                try {
                    change = this.machines.get(i).buyProduct(money, idProduct);
                    System.out.println("Your change is: " + change.getTotal() + "€");
                } catch (FailuireException e) {
                    System.out.println(e.getMessage());
                    this.incidences.add(e);
                } catch (JamException e) {
                    System.out.println(e.getMessage());
                    this.incidences.add(e);
                }
            }
        }
    }

    public void generalInfo(){
        for (int i = 0; i < this.machines.size(); i++) {
        System.out.println("Basis.Machine: " + this.machines.get(i).getId());

        this.machines.get(i).getMoney().info();
        System.out.println("Basis.Money: " + this.machines.get(i).getMoney().getTotal());
        System.out.println("Products: ");
        this.machines.get(i).listProducts();
        }
    }

}
