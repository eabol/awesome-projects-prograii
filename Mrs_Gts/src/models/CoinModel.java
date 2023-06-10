package models;

public class CoinModel extends MoneyAbstract {
    public CoinModel(double value, int quantity) {
        super(value, quantity);
    }

    @Override
    public void received(PurchaseModel purchaseModel) {
        purchaseModel.depositMoney(this);
    }
}
