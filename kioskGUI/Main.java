public class Main {
    public static void main(String[] args) {
        CheckoutKiosk kiosk = new CheckoutKiosk();

        // Products
        Product product1 = new Product("1", "Sandia", 3.5);
        Product product2 = new Product("2", "Coche", 590.3);
        Product product3 = new Product("3", "Farola", 6.9);
        Product product4 = new Product("4", "Paco", 100.9);

        kiosk.addProduct(product1);
        kiosk.addProduct(product2);
        kiosk.addProduct(product3);
        kiosk.addProduct(product4);


        // Discounts
        Discount discount1 = new Discount("D10", "10 Euros descuento", 100.);
        Discount discount2 = new Discount("6C", "5 Euros descuento", 5.0);
        kiosk.addDiscount(discount1);
        kiosk.addDiscount(discount2);
    }
}
