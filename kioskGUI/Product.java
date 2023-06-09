public class Product extends Item {
    private double price;

    public Product(String id, String name, double price) {
        super(id, name);
        this.price = price;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public void applyDiscount(Discount discount) { this.price -= discount.getDiscountValue(); }
}