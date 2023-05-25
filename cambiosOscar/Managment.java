import java.util.ArrayList;

public class Managment {
    ArrayList<Product> products;
    ArrayList<Money> money;

    public Managment() {
        this.products = new ArrayList<>();
        this.money = new ArrayList<>();
        int[] n={10,10,10};
        this.products.add(new Gluten("Biscuits",1.50, n));
        this.products.add(new Gluten("Chocolate",1.10, n));
        this.products.add(new Gluten("Drinks",1.05, n));
        this.products.add(new Gluten("Sandwich",1.75, n));

        this.money.add(new Money(20, new int[]{3, 3, 3}));
        this.money.add(new Money(10, new int[]{1, 2, 1}));
        this.money.add(new Money(5, new int[]{2, 3, 3}));
        this.money.add(new Money(2, new int[]{5, 7, 5}));
        this.money.add(new Money(1, new int[]{10, 15, 12}));
        this.money.add(new Money(0.5F, new int[]{20, 25, 30}));
        this.money.add(new Money(0.2F, new int[]{20, 30, 10}));
        this.money.add(new Money(0.05F, new int[]{10, 20, 15}));
    }

    public int[] change(float received, float cost){

        float[] v={20,10,5,2,1,0.5F,0.2F,0.05F};
        int[] coins={0,0,0,0,0,0,0,0,0};

        if (received>cost){
            float diference= received - cost;
        }
    return null;
        // este return hay que cambiarle
    }
}
