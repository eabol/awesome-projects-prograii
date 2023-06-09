package main.print;

import main.core.Machine;


public class MachinePrinting {
    final String instruction = "  Units->Name->Id->Price";
    private int machineHigh;
    private int machineBroad;

    public MachinePrinting() {
        this.machineHigh = 30;
        this.machineBroad = 15;
    }

    public void printMachineProducts(Machine machine, int machineId) {
        int productUnits;
        String productName;
        int productId;
        boolean fileInUse = false;
        double productPrice;
        int a = 0;
        System.out.println("Machine " + machineId);
        for (int i = 0; i < machineBroad; i++) {
            for (int j = 0; j < machineHigh; j++) {
                if (i == 0 && j == machineHigh - 1) {
                    System.out.print("=");
                    System.out.println();
                } else if (i==0 ){
                System.out.print("=");
                } else if (j == 0) {
                    System.out.print("|");
                } else if (j == machineHigh - 1){
                    System.out.println("|");
                    fileInUse = false;
                } else if (i == machineBroad - 1) {
                    System.out.print("=");
                } else if (i == 1 && j == 1){
                    System.out.print(instruction);
                    machineHigh -= (instruction.length() - 1);
                    fileInUse =true;
                } else {
                    try {
                        if (!fileInUse) {
                            productUnits = machine.getProducts().get(a).getUnits();
                            productName = machine.getProducts().get(a).getName();
                            productId = machine.getProducts().get(a).getProductId();
                            productPrice = machine.getProducts().get(a).getPrice();
                            System.out.print("  "+ productUnits+ "->" + productName + "->" + productId + "->" + productPrice);
                            machineHigh -= (productName.length() + 14);
                            a++;
                            fileInUse = true;
                        } else {
                            System.out.print(" ");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.print(" ");

                    }
                }
            }
            machineHigh = 30;
        }
    }
}
