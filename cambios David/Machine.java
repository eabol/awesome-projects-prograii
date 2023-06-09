package Basis;

import java.util.ArrayList;
import java.util.Random;

public class Machine implements Salable {

    public int id;
    public ArrayList<Product> products;
    private Money money;
    private Alert salable;

    public Machine(int id, Money money) {
        this.id = id;
        this.money = money;
        this.products = new ArrayList<Product>();
    }

    public int getId() {
        return id;
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

    public Alert getSalable() {
        return salable;
    }

    public void setSalable(Alert salable) {
        this.salable = salable;
    }


    @Override
    public void pricing() {

    }

    @Override
    public int productQuantity(int price) {

        return price;
    }

    @Override
    public void productQuantity() {

    }

    @Override
    public boolean available() {
        return false;
    }

    @Override
    public void replenish(int n) {

    }

    @Override
    public Money manageChange(Money clientMoney, float priceProduct) {
        Money change = new Money();
        float quantity= clientMoney.getTotal();
        int importReturn=0;

        int rest=1;
        if (quantity>=priceProduct){
            importReturn=(int)((quantity-priceProduct)*100);

            for (float valu : Salable.value){
                int cents=(int)(valu *100);
                if (importReturn>=cents && money.getAmount(valu)>0){
                    rest= importReturn%cents;
                    change.insetMoney(valu, importReturn/cents);
                    importReturn=rest;
                }
            }
        }
        if(rest>0){
            return null;
        }else{
            return change;
        }
    }

    @Override
    public Alert possibleJam() {
        Random random = new Random();
        if (random.nextInt(100) <= 3) {
            return Alert.JAM;
        }
        return Alert.NORMAL;
    }

    @Override
    public Alert possibleFailure() {
        Random random = new Random();
        if (random.nextInt(100) <= 2) {
            return Alert.FAILURE;
        }
        return Alert.NORMAL;
    }

    public void listProducts() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public double getPriceProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.getPrice();
            }
        }
        return -1;
    }

    public Money buyProduct(Money clientMoney, int idProduct) throws FailuireException, JamException {
       // metodo que recibe el dinero entregado por el cliente y el producto a comprar y devuelve la vuelta si la hubiera
     if (this.possibleFailure()==Alert.JAM){
         setSalable(Alert.JAM);
         throw new JamException(this.id, idProduct);
     }
     if (this.possibleFailure()==Alert.FAILURE){
         setSalable(Alert.FAILURE);
         throw new FailuireException(this.id);
     }
     Money returnMoney= null;
     if (clientMoney.getTotal()>=this.products.get(idProduct).price){
         returnMoney=manageChange(clientMoney, (float) getPriceProduct(idProduct));
         this.money.suma(clientMoney);
         this.money.resta(returnMoney);
     }
     return returnMoney; //si devuelve null no se garantiza la venta
    }

    public void infoMachine(){
        System.out.println("Dinero disponible: ");
        this.money.info();
        System.out.println("Productos disponibles: ");
        listProducts();
    }

}
