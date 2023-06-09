package main.core;

public class HealthyWallet extends Wallet{
    public HealthyWallet(){
        super();
    }
    public void addCoins(){
        this.coins.add(new Coin(20.00, 3));
        this.coins.add(new Coin(10.00, 2));
        this.coins.add(new Coin(5.00, 3));
        this.coins.add(new Coin(2.00, 7));
        this.coins.add(new Coin(1.00, 15));
        this.coins.add(new Coin(0.50, 25));
        this.coins.add(new Coin(0.20, 30));
        this.coins.add(new Coin(0.05, 20));
    }
}
