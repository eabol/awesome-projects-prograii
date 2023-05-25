public class Gluten extends Food implements Salable {

    public Gluten(String name, double price,int[] cantidad) {
        super(name, price, cantidad);
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
