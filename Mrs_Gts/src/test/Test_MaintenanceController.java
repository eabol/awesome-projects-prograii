package test;

import controllers.MaintenanceController;
import models.BillModel;
import models.CoinModel;
import models.MachineModel;
import models.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_MaintenanceController {

    @Test
    public void testCheckAndRefillProducts() {
        List<MachineModel> machines = new ArrayList<>();

        List<BillModel> bills1 = new ArrayList<>();
        List<CoinModel> coins1 = new ArrayList<>();
        List<ProductModel> products1 = new ArrayList<>();
        MachineModel machine1 = new MachineModel("Máquina 1", bills1, coins1, products1);
        ProductModel product1 = new ProductModel("Producto 1", 3, 10);
        machine1.addProducts(product1);
        machines.add(machine1);

        List<BillModel> bills2 = new ArrayList<>();
        List<CoinModel> coins2 = new ArrayList<>();
        List<ProductModel> products2 = new ArrayList<>();
        MachineModel machine2 = new MachineModel("Máquina 2", bills2, coins2, products2);
        ProductModel product2 = new ProductModel("Producto 2", 6, 6);
        machine2.addProducts(product2);
        machines.add(machine2);

        MaintenanceController maintenanceController = new MaintenanceController();

        maintenanceController.checkAndRefillProducts(machines);

        int expectedQuantity = 10;
        int actualQuantity = machine1.listOfProducts().get(0).getQuantity();
        Assertions.assertEquals(expectedQuantity, actualQuantity);

        expectedQuantity = 6;
        actualQuantity = machine2.listOfProducts().get(0).getQuantity();
        Assertions.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void testCheckAndRefillProducts_NoRefillRequired() {
        List<MachineModel> machines = new ArrayList<>();

        List<BillModel> bills = new ArrayList<>();
        List<CoinModel> coins = new ArrayList<>();
        List<ProductModel> products = new ArrayList<>();
        MachineModel machine = new MachineModel("Máquina", bills, coins, products);
        ProductModel product = new ProductModel("Producto", 10, 10);
        machine.addProducts(product);
        machines.add(machine);

        MaintenanceController maintenanceController = new MaintenanceController();

        maintenanceController.checkAndRefillProducts(machines);

        int expectedQuantity = 10;
        int actualQuantity = machine.listOfProducts().get(0).getQuantity();
        Assertions.assertEquals(expectedQuantity, actualQuantity);
    }
}
