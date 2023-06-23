package models;

public class BillModel extends MoneyAbstract {
    public BillModel(double value, int quantity) {
        super(value, quantity);
    }

    @Override
    public void received(PurchaseModel purchaseModel) {
        purchaseModel.depositMoney(this);
    }
}
