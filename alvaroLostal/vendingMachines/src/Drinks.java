public class Drinks extends Product implements Salable {

    private boolean isAlcoholic;
    private int milliliters;

    public Drinks(String name, double price, int id, boolean isAlcoholic, int milliliters) {
        super(name, price, id);
        this.isAlcoholic = isAlcoholic;
        this.milliliters = milliliters;
    }

    @Override
    public boolean isSalable() {
        return false;
    }

    @Override
    public void replanish(int newQuantity) {
        set
    }
}
