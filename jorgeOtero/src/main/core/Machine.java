package main.core;

import main.core.exceptions.NoProductAdded;

import java.util.ArrayList;
import java.util.Scanner;

public class Machine implements PreMachine {
        private int id;
        private ArrayList<Product> products;
        private Wallet money;


    public Machine(int id, Wallet money){
        this.id = id;
        this.products = new ArrayList<>();
        this.money = money;
    }

        public ArrayList<Product> getProducts() {
            return products;
        }

        public void setProducts(ArrayList<Product> products)throws NoProductAdded {
            if (products.size() == 0) {
                throw new NoProductAdded("No products added");
            } else {
                this.products = products;
            }
        }
        public int getID(){
        return this.id;
    }
    public double askMoney(){
        Scanner money = new Scanner(System.in);
        return money.nextDouble();
    }
    public boolean refillProduct(int id){
        boolean productRefilled = false;
        for(Product p:this.products){
            if(p.getProductId()==id){
                System.out.println("You selected " + p.getName());
                p.setUnits(10);
                productRefilled = true;
            }
        }
        return productRefilled;
    }
    public void showRefilling(boolean productRefilled){
        if(productRefilled){
            System.out.println("Product refilled");
        } else{
            System.out.println("Product not found");
        }
    }

    public Wallet getMoney() {
        return money;
    }

    public void buyProduct(int id, Wallet wallet){
        double change;
        for(Product p:this.products){
            if(p.getProductId()==id){
                if(p.getUnits()>0){
                    p.setUnits(p.getUnits()-1);
                    System.out.println("You selected " + p.getName());
                    System.out.println("Enter the money");
                    double money = askMoney();
                    if(money>=p.getPrice()){
                        change = money-p.getPrice();
                        change = Math.round(change*100.0)/100.0;
                        if(change<=wallet.total()){
                            wallet.checkToAddCoins(money);
                            wallet.checkCoins(change);
                        } else{
                            System.out.println("Not enough money in the machine");
                        }
                    } else {
                        System.out.println("You have to enter more money");
                    }
                } else{
                    System.out.println("Sorry we need to refill the machine");
                    }
            }
        }
    }
}