public class Discount extends Item {
    private double discountValue;

    public Discount(String id, String name, double discountValue) {
        super(id, name);
        this.discountValue = discountValue;
    }

    public double getDiscountValue() { return discountValue; }
}