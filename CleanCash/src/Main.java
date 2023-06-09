import SystemData.InventoryDataBase;
import SystemData.ShoppingCart;
import SystemManagement.CartManager;
import SystemManagement.MemberManager;
import Tests.MainTest;

import java.util.Scanner;

public class Main {
    InventoryDataBase inventoryDataBase = new InventoryDataBase();
    MemberManager memberManager = new MemberManager();
    CartManager cartManager = new CartManager();

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        mainTest.run();
    }




}