package DataClasses;
public abstract class Product extends Entity{

    float price;
    public Product(String entityName, String entityId) {
        super(entityName, entityId);
    }
}
