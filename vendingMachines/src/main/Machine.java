package main;

import exceptions.FailureException;
import exceptions.JamException;
import interfaces.Salable;

import java.util.ArrayList;
import java.util.Random;

public class Machine implements Salable {
    private int id;
    private ArrayList<Product> products;
    private Money money;
    private Status status;

    public Machine(int id) {
        this.id = id;
        this.products = new ArrayList<>();
        this.status = Status.NORMAL;
    }

    public int getId() {
        return 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void machineReport() {
        System.out.println("Avalaible money: ");
        this.money.information();
        System.out.println("Avalaible products: ");
        productList();
    }

    public Money manageChange(Money clientMoney, float productPrice) {
        Money change = new Money();
        float quantity = clientMoney.getTotal();
        int changeQuantity = 0;

        int debt = 1;
        if (quantity >= productPrice) {
            changeQuantity = (int) ((quantity - productPrice) * 100);

            for (float w : Salable.values) {
                int cents = (int) (w * 100);
                if (changeQuantity >= cents && money.getQuantity(w) > 0) {
                    debt = changeQuantity % cents;
                    change.insert(w, changeQuantity / cents);
                    changeQuantity = debt;
                }
            }
        }
        if (debt > 0) {
            return new Money();
        } else {
            return change;
        }
    }

    @Override
    public Status possibleJam() {
        Random r = new Random();
        if (r.nextInt(100) <= 2) {
            return Status.JAM;
        } else {
            return Status.NORMAL;
        }
    }

    @Override
    public Status possibleFailure() {
        Random r = new Random();
        if (r.nextInt(100) <= 3) {
            return Status.FAILURE;
        } else {
            return Status.NORMAL;
        }
    }

    public float getProductPrice(int id) {
        for (Product p : this.products) {
            if (p.getId() == id) {
                return (float) p.getPrice();
            }
        }
        return 0;
    }

    public void productList() {
        for (Product p : this.products) {
            System.out.println(p.toString());
        }
    }

    public Money buyProduct(Money clientMoney, int idProduct) throws JamException, FailureException {
        if (this.possibleJam() == Status.JAM) {
            setStatus(Status.JAM);
            throw new JamException(this.id, idProduct);
        }
        if (this.possibleFailure() == Status.FAILURE) {
            setStatus(Status.FAILURE);
            throw new FailureException(this.id);
        }
        Money change = new Money();
        if (clientMoney.getTotal() >= this.products.get(idProduct).getPrice()) {
            change = manageChange(clientMoney, getProductPrice(idProduct));
            this.money.add(clientMoney);
            this.money.remove(change);
        }

        return change;
    }
}