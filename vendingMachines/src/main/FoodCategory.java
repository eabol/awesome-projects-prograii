package main;

public class FoodCategory extends ProductCategory {
    public FoodCategory(String name, String description) {
        super(name, description);
    }

    public void sell(Product product, int quantity) {
        int availableQuantity = product.getQuantity(0);
        if (availableQuantity >= quantity) {
            product.setQuantity(0, availableQuantity - quantity);
        } else {
            System.out.println("Not enough stock. " + quantity + " units of " + product.getName());
            System.out.println("Available amount: " + availableQuantity);
        }
    }
}
