public class Drinks extends Product implements Salable {

    public Drinks(double mililiters) {
        this.mililiters = mililiters;
    }

    public Drinks(String name, double price, int[] amount, double mililiters) {
        super(name, price, amount);
        this.mililiters = mililiters;
    }

    private double mililiters;


    public double getMililiters() {
        return mililiters;
    }

    public void setMililiters(double mililiters) {
        this.mililiters = mililiters;
    }

    @Override
    public void ponerPrecio() {

    }

    @Override
    public void cantidadProducto(int precio) {

    }

    @Override
    public void cantidadProducto() {

    }

    @Override
    public boolean disponible() {
        return false;
    }

    @Override
    public void reponer(int n) {

    }

}


