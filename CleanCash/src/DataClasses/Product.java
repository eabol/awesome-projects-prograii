package DataClasses;
public abstract class Product extends Entity{

    float price;
    public Product(String entityName, String entityId, float price) {
        super(entityName, entityId);
        this.price = price;
    }
}
