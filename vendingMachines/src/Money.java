import java.util.ArrayList;

public class Money {
    private ArrayList<Float> worth;
    private ArrayList<Integer> quantity;

    public Money() {
        this.worth = new ArrayList<>();
        this.quantity = new ArrayList<>();
    }

    public void insert(float w, int q) {
        int pos = worth.indexOf(w);
        if (pos != -1) {
            this.quantity.set(pos, this.quantity.get(pos) + q);
        } else {
            this.worth.add(w);
            this.quantity.add(q);
        }
    }

    public void add(Money d) {
        for (float w : d.worth) {
            this.insert(w, d.getQuantity(w));
        }
    }

    public boolean remove(Money d) {
        for (float w : d.worth) {
            if (this.getQuantity(w) < d.getQuantity(w)) {
                return false;
            }
        }
        for (float w : d.worth) {
            this.insert(w, -d.getQuantity(w));
        }
        return true;
    }

    public ArrayList<Float> getWorth() {
        return worth;
    }

    public int getQuantity(float w) {
        int pos = this.worth.indexOf(w);
        if (pos != -1) {
            return this.quantity.get(pos);
        } else {
            return 0;
        }
    }

    public float getTotal() {
        float total = 0;
        for (float w : this.worth) {
            total += w * this.getQuantity(w);
        }
        return total;
    }

    public void information() {
        for (float w : this.worth) {
            if (w >= 5) {
                System.out.println("Bills of " + w + " --->" + this.getQuantity(w));
            } else {
                System.out.println("Coins of " + w + " --->" + this.getQuantity(w));
            }
        }
    }
}