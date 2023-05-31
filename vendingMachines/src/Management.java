import java.util.ArrayList;

public class Management {
    private ArrayList<Product> products;
    private ArrayList<Money>money;

    public Management() {
        this.products= new ArrayList<Product>();
        this.products.add(new Product("Cookies", 1.5,  10, 10, 10));
        this.products.add(new Product("Chocolate", 1.1,  10, 10, 10));
        this.products.add(new Product("Drink", 1.05,  10, 10, 10));
        this.products.add(new Product("Sandwich", 1.75,  10, 10, 10));
        this.products.add(new Product("Candies", 0.95,  10, 10, 10));

        this.money = new ArrayList<Money>();
        Money m1 = new Money();
        m1.add(0.05f, 10);
        m1.add(0.2f, 20);
        m1.add(0.5f, 20);
        m1.add(1f, 10);
        m1.add(2f, 5);
        m1.add(5f, 2);
        m1.add(10f, 1);
        m1.add(20f, 3);
        money.add(m1);

        Money m2 = new Money();
        m1.add(0.05f, 20);
        m1.add(0.2f, 30);
        m1.add(0.5f, 25);
        m1.add(1f, 15);
        m1.add(2f, 7);
        m1.add(5f, 3);
        m1.add(10f, 2);
        m1.add(20f, 3);
        money.add(m2);

        Money m3 = new Money();
        m1.add(0.05f, 15);
        m1.add(0.2f, 10);
        m1.add(0.5f, 30);
        m1.add(1f, 12);
        m1.add(2f, 5);
        m1.add(5f, 3);
        m1.add(10f, 1);
        m1.add(20f, 3);
        money.add(m3);
    }

    public void screen(int machine) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getQuantity(machine) > 0) {
                System.out.println(i + ". " + products.get(i).getName() + " " + products.get(i).getPrice() + "€" + " " + products.get(i).getQuantity(machine) + " unidades");
            }
        }
    }
    public void paymentManagement(int machine, int product, float money) {
        if (products.get(product).getPrice() <= money) {
            if (products.get(product).getQuantity(machine) > 0) {
                products.get(product).sell(machine);
                System.out.println("Thanks for your purchase");
            } else {
                System.out.println("No units available");
            }
        } else {
            System.out.println("Not enough money");
        }
    }
}
