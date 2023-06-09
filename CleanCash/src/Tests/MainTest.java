package Tests;

import DataClasses.Entity;
import DataClasses.Product;
import SystemData.InventoryDataBase;
import SystemManagement.CartManager;
import SystemManagement.MemberManager;

import java.util.Scanner;

public class MainTest {

    InventoryDataBase inventoryDataBase = new InventoryDataBase();
    MemberManager memberManager = new MemberManager();
    CartManager cartManager = new CartManager();


    public void run() {
        System.out.println("Welcome to the test version of CleanCash");
        consoleRun();
    }


    public void consoleRun() {
        showCart();
        selectOption();
    }

    public void selectOption() {
        System.out.println("Type 0 to add an item to the basket, 1 to checkout, other to exit");
        switch (consoleInput()) {
            case "0":
                addItemPrompt();
                break;
            case "1":
                checkOut();
                break;
            default:
                break;
        }
    }

    public void addItemPrompt() {
        System.out.println("These are the avilable products:");
        showInventory();
        System.out.println("#####################");
        System.out.println("Introduce product ID");
        String productId = consoleInput();
        Entity product = inventoryDataBase.findProduct(productId);
        if (product != null) {
            cartManager.add(product);
            consoleRun();
        } else {
            System.out.println("Product not found");
            selectOption();
        }
    }

    public void checkOut() {
        System.out.println("Welcome to checkout");
        System.out.println("Your total cart cost is " + cartManager.getTotalCost());
        discountMenu();
    }

    public void discountMenu(){
        System.out.println("Do you have a discount?");
        System.out.println("Type 1 for yes, 0 for no");
        switch (consoleInput()) {
            case "0":
                endSale();
                break;
            case "1":
                useDiscount();
                break;
            default:
                break;
        }
    }

    public void endSale(){
        System.out.println("Your final cost is " + cartManager.getFinalCost());
    }

    public void useDiscount(){
        System.out.println("Introduce your coupon code");
        String saleCode = consoleInput();
        int discount = memberManager.getDiscount(saleCode);
        if (discount > 0) {
            cartManager.applyDiscount(discount);
            System.out.println("Applied " + discount + "% of discount");
            endSale();
        }
        else {
            System.out.println("Invalid discount");
            discountMenu();
        }
    }


    //ONLY FOR TEST PROPOUSES

    public String consoleInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }


    public void showCart() {
        for (Product product : cartManager.getShoppingCart().getProductsCart()) {
            product.debugProduct();
        }
    }

    public void showInventory() {
        for (Product product : inventoryDataBase.getProducts()) {
            product.debugProduct();
        }
    }


    // 1 Muestra carrito
    // 2 Muestra inventario
    //Opciones: Añadir item, finalizar compra
    //Añadir -> introduce id - va a 1


}
