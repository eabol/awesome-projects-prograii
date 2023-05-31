import java.util.ArrayList;

public class Money {
    private ArrayList<Float> valor;
    private ArrayList<Integer> cantidad;

    public Money() {
        this.valor = new ArrayList<Float>();
        this.cantidad = new ArrayList<Integer>();
    }

    public void add(float valor, int cantidad) {
        this.valor.add(valor);
        this.cantidad.add(cantidad);
    }

    public int getCantidad(float valor) {
        int pos = this.valor.indexOf(valor);
        return this.cantidad.get(pos);
    }

    public void setCantidad(float valor, int cantidad) {
        int pos = this.valor.indexOf(valor);
        this.cantidad.set(pos, getCantidad(valor) + cantidad);
    }
}
