package models;

import java.util.List;

public class MachineModel {
    private String name;
    private List<CoinModel> coins;
    private List<BillModel> bills;
    private List<ProductModel> products;

    public MachineModel(String name, List<CoinModel> coins, List<BillModel> bills, List<ProductModel> products) {
        this.name = name;
        this.coins = coins;
        this.bills = bills;
        this.products = products;
    }

    public void addCoins(CoinModel coin) {
        coins.add(coin);
    }

    public void addBills(BillModel bill) {
        bills.add(bill);
    }

    public void addProducts(ProductModel product) {
        products.add(product);
    }

    public String showName() {
        return name;
    }

    public List<CoinModel> listOfCoins() {
        return coins;
    }

    public List<BillModel> listOfBills() {
        return bills;
    }

    public List<ProductModel> listOfProducts() {
        return products;
    }
}
