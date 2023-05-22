public class Accesories extends Product implements Salable{

    public Accesories(String name, double price, int id) {
        super(name, price);
    }

    @Override
    public void setPrize() {

    }

    @Override
    public void amount(int n) {

    }

    @Override
    public void amount() {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
