
public  class Accesories extends Product implements Salable {

    public Accesories(String name, double price, int id, int amount) {
        super(name, price, id, amount);
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
        return null;
    }

    @Override
    public Alert possibleJam() {
        return null;
    }

    @Override
    public Alert possibleFailure() {
        return null;
    }
}
