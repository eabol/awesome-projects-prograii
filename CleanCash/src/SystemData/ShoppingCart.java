package SystemData;
import DataClasses.Entity;
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

    public Product findProduct(Product findProduct){
        for (Product product : productsCart) {
            if (product.getEntityId().equals(findProduct.getEntityId())){
                return product;
            }
        }
        return null;
    }

    public Product findProduct(String productName){
        for (Product product : productsCart) {
            if (product.getEntityName().equals(productName)){
                return product;
            }
        }
        return null;
    }

    public void removeProduct(Product product){
        productsCart.remove(product);
        totalCost-=product.getPrice();
    }



}
