package main.core;

public interface PreMachine {
    boolean refillProduct(int id);
    void showRefilling(boolean refillProducts);
    void buyProduct(int id, Wallet wallet);
}
