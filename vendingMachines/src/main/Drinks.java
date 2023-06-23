package main;

public class Drinks extends Product {

    private boolean isAlcoholic;
    private int milliliters;

    public Drinks(String name, double price, int id, int quantity, boolean isAlcoholic, int milliliters) {
        super(name, price, id, quantity);
        this.isAlcoholic = isAlcoholic;
        this.milliliters = milliliters;
    }

    @Override
    public void sell(int quantity) {
        this.quantity = this.quantity - 1;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }
}
