package main.core;

public class UnhealthyWallet extends Wallet{
    public UnhealthyWallet(){
        super();
    }
    public void addCoins(){
        this.coins.add(new Coin(20.00, 3));
        this.coins.add(new Coin(10.00, 1));
        this.coins.add(new Coin(5.00, 3));
        this.coins.add(new Coin(2.00, 5));
        this.coins.add(new Coin(1.00, 12));
        this.coins.add(new Coin(0.50, 30));
        this.coins.add(new Coin(0.20, 10));
        this.coins.add(new Coin(0.05, 15));
    }
}
