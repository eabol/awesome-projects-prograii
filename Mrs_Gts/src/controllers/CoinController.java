package controllers;

import models.CoinModel;

import java.util.ArrayList;
import java.util.List;

public class CoinController {
    public List<CoinModel> createCoinList(int quantity1, int quantity2, int quantity3) {
        final List<CoinModel> coins = new ArrayList<CoinModel>();
        coins.add(new CoinModel(0.50, quantity1));
        coins.add(new CoinModel(0.20, quantity2));
        coins.add(new CoinModel(0.05, quantity3));
        return coins;
    }
}
