package DataClasses;
public class Product extends Entity{
    private float price;

    public float getPrice() {
        return price;
    }

    public Product(String entityName, String entityId, float price) {
        super(entityName, entityId);
        this.price = price;
    }

    public void debugProduct(){
        System.out.println(this.getEntityName()+" id:"+getEntityId()+" Price:"+getPrice()+"€");
    }

}
