package main;

public class Food extends Product {
    public Food(String name, double price, int id, int quantity) {
        super(name, price, id, quantity);
    }

    @Override
    public void sell(int quantity) {
        this.quantity = this.quantity - 1;
    }
}