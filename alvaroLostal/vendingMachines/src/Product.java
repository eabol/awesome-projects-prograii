public class Product {
    protected String name;
    protected double price;
    protected int[] cantidad;

    public Product(String name, double price, int id, int cantidad1, int cantidad2, int cantidad3) {
        this.name = name;
        this.price = price;
        this.cantidad[0] = cantidad1;
        this.cantidad[1] = cantidad2;
        this.cantidad[2] = cantidad3;
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

    public int getCantidad(int i) {
        return cantidad[i];
    }

    public void setCantidad(int i, int cantidad) {
        this.cantidad[i] = cantidad;
    }

    public void sell(int i) {
        this.cantidad[i] = this.cantidad[i] - 1;
    }
}
