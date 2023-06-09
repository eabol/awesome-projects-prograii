package SystemData;
import DataClasses.Product;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private List<Product> productsCart;
    private float totalCost;
    private float discountsTotal;
    private float finalCost;
    public float getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public void addProduct(Product product){
        productsCart.add(product);
        totalCost+=product.getPrice();
    }

    /**
    public void tryDiscount(){
        for (String discount :
             ) {

        }
    }*/

    public void applyDiscount(){

    }




}
