package main.core;

import java.util.ArrayList;

public abstract class Wallet {

    protected ArrayList<Coin> coins;
    public Wallet(){
        this.coins = new ArrayList<>();
    }
    public void addCoins(){
    }
    public int total() {
        int total = 0;
        for (Coin c : this.coins) {
            total += c.getValue() * c.getQuantity();
        }
        return total;
    }
    public void checkCoins(double change){
        double changeToUser = change;
        for(Coin c:this.coins) {
            do {
                if (c.getValue() <= change) {
                    c.setQuantity(c.getQuantity() - 1);
                    change -= c.getValue();

                }
            } while (c.getValue() <= change);
        }
        System.out.println("Your change is: "+changeToUser);
    }
    public void checkToAddCoins(double price){
        for(Coin c:this.coins) {
            if (c.getValue() <= price) {
                c.setQuantity(c.getQuantity() + 1);
                price -= c.getValue();
            }
        }
    }
    public void printWallet(){
        for(Coin c:this.coins){
            System.out.println(c.getValue()+"€ -- "+c.getQuantity());
        }
    }
}