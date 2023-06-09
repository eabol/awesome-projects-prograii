package SystemData;

import DataClasses.Product;
public class InventoryDataBase {

    Product[] products = new Product[20];

    public Product[] getProducts() {
        return products;
    }

    public  InventoryDataBase() {
        products[0] = new Product("Cocacola", "01", 2.0F);
        products[1] = new Product("Fanta", "02", 1.8F);
        products[2] = new Product("Sprite", "03", 1.5F);
        products[3] = new Product("Water", "04", 0.5F);
        products[4] = new Product("Beer", "05", 2.0F);
        products[5] = new Product("Wine", "06", 16.0F);
        products[6] = new Product("Vodka", "07", 20.0F);
        products[7] = new Product("HeadPhones", "08", 50.5F);
        products[8] = new Product("Monitor", "09", 140.0F);
        products[9] = new Product("Keyboard", "10", 70.0F);
        products[10] = new Product("Mouse", "11", 40.0F);
        products[11] = new Product("Laptop", "12", 700.0F);
        products[12] = new Product("Tablet", "13", 300.0F);
        products[13] = new Product("Phone", "14", 800.0F);
        products[14] = new Product("TV", "15", 200.0F);
        products[15] = new Product("Bread", "16", 0.6F);
        products[16] = new Product("Pasta", "17", 2.0F);
        products[17] = new Product("Rice", "18", 2.0F);
        products[18] = new Product("Chicken", "19", 7.0F);
        products[19] = new Product("Beef", "20", 10.0F);
    }

    public Product findProduct(String input){
        for (Product product : products) {
            if (input.equals(product.getEntityName()) || input.equals(product.getEntityId())){
                return product;
            }
        }
        return null;
    }


}
