package main;

public class Product {
    protected String name;
    protected double price;
    protected int id;
    protected int quantity;

    public Product(String name, double price, int id, int quantity) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity(int i) {
        return quantity;
    }

    public void setQuantity(int i, int quantity) {
        this.quantity = quantity;
    }

    public void sell(int i) {
        this.quantity -= i;
    }

    public int getId() {
        return this.id;
    }
}
