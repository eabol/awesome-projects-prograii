package SystemManagement;

import DataClasses.Entity;
import SystemData.ShoppingCart;

public class CartManager implements DataManager{

    private ShoppingCart shoppingCart;
    public CartManager() {
        shoppingCart = new ShoppingCart();
    }

    @Override
    public void add(Entity newEntity) {

    }

    @Override
    public void remove(Entity removedEntity) {

    }

    public ShoppingCart getShoppingCart(){
        return shoppingCart;
    }
    public float getTotalCost() {
        return shoppingCart.getTotalCost();
    }

    public float getTotalDiscount(){
        return shoppingCart.getDiscountsTotal();
    }

    public float getFinalCost(){
        return shoppingCart.getFinalCost();
    }


    @Override
    public void identify(Entity entity) {

    }

    public void applyDiscount(){
        // Calls shopping cart and tests discount to apply it
    }

}
