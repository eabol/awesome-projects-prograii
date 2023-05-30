import java.util.ArrayList;

public class Money {
    private ArrayList<Float> worth;
    private ArrayList<Integer> quantity;

    public Money() {
        this.worth = new ArrayList<Float>();
        this.quantity = new ArrayList<Integer>();
    }

    public void add(float worth, int quantity) {
        this.worth.add(worth);
        this.quantity.add(quantity);
    }

    public int getCantidad(float worth) {
        int pos = this.worth.indexOf(worth);
        return this.quantity.get(pos);
    }

    public void setCantidad(float worth, int quantity) {
        int pos = this.worth.indexOf(worth);
        this.quantity.set(pos, getCantidad(worth) + quantity);
    }
}
