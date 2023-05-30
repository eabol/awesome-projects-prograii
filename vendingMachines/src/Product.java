public class Product {
    protected String name;
    protected double price;
    protected int[] quantity;

    public Product(String name, double price, int quantity1, int quantity2, int quantity3) {
        this.name = name;
        this.price = price;
        this.quantity = new int[3];
        this.quantity[0] = quantity1;
        this.quantity[1] = quantity2;
        this.quantity[2] = quantity3;
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
        return quantity[i];
    }

    public void setQuantity(int i, int quantity) {
        this.quantity[i] = quantity;
    }

    public void sell(int i) {
        this.quantity[i] = this.quantity[i] - 1;
    }
}
