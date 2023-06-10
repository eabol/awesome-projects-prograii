package models;

public abstract class MoneyAbstract {
    public double value;
    public int quantity;

    MoneyAbstract(double value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public void updateValue(double value) {
        this.value = value;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract void recieved(PurchaseModel purchaseModel);
}
