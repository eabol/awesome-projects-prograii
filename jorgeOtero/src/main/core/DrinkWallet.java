package main.core;

public class DrinkWallet extends Wallet{
    public DrinkWallet(){
        super();
    }
    public void addCoins(){
        this.coins.add(new Coin(20.00, 3));
        this.coins.add(new Coin(10.00, 1));
        this.coins.add(new Coin(5.00, 2));
        this.coins.add(new Coin(2.00, 5));
        this.coins.add(new Coin(1.00, 10));
        this.coins.add(new Coin(0.50, 20));
        this.coins.add(new Coin(0.20, 20));
        this.coins.add(new Coin(0.05, 10));
    }
}
