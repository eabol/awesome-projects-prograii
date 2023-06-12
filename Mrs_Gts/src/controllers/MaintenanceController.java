package controllers;

public class MaintenanceController {

    public void checkAndRefillProducts(java.util.List<models.MachineModel> machines) {
        for (models.MachineModel machine : machines) {
            for (models.ProductModel product : machine.listOfProducts()) {
                if (product.getQuantity() < 4 ) {
                    product.updateQuantity(10);
                }
            }
        }
    }
}