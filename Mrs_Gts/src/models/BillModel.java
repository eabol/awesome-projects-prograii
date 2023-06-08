package models;

public class BillModel {
    public BillModel(double value, int quantity) {
        super(value, quantity);
    }

    @Override
    public void recieved(PurchaseModel purchaseModel) {
        purchaseModel.depositMoney(this);
    }
}
