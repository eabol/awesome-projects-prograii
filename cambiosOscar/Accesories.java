public class Accesories extends Product implements Salable {

    public Accesories(String name, double price, int[] amount) {
        super(name, price, amount);
    }

    @Override
    public void ponerPrecio() {
    }

    @Override
    public void cantidadProducto(int precio) {
    }

    @Override
    public void cantidadProducto() {

    }


    @Override
    public boolean disponible() {
        return false;
    }

    @Override
    public void reponer(int n) {
    }
}
