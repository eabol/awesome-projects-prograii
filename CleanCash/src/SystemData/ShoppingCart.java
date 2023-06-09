package SystemData;
import DataClasses.Product;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private List<Product> productsCart;
    private float totalCost;
    private float discountsTotal;
    private float finalCost;

    public ShoppingCart(){
        productsCart = new ArrayList<>();
    }
    public List<Product> getProductsCart(){
        return productsCart;
    }



    public float getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public float getDiscountsTotal() {
        return discountsTotal;
    }

    public void setDiscountsTotal(float discountsTotal) {
        this.discountsTotal = discountsTotal;
        finalCost = totalCost-discountsTotal;
    }

    public float getFinalCost() {
        float effectiveDiscount = (totalCost*discountsTotal)/100;
        finalCost = totalCost-effectiveDiscount;
        return finalCost;
    }

    public void setFinalCost(float finalCost) {
        this.finalCost = finalCost;
    }

    public void addProduct(Product product){
        productsCart.add(product);
        totalCost+=product.getPrice();
        finalCost = totalCost;
    }

    public void applyDiscount(float discount){
        discountsTotal+=discount;
    }




}
