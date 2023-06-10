package views;

import controllers.MachineController;
import controllers.PurchaseController;
import models.MachineModel;
import utils.Line;

import java.util.List;
import java.util.Scanner;

public class PurchaseView {
    static Scanner input = new Scanner(System.in);
    private MachineController machineController;
    private PurchaseController purchaseController;
    private Line line;

    public PurchaseView(MachineController machineController, PurchaseController purchaseController, Line line) {
        this.machineController = machineController;
        this.purchaseController = purchaseController;
        this.line = line;
    }

    public void purchaseMenu(final List<MachineModel> machines) {
        boolean exit = false;

        do{
            line.printDoubleLine();
            System.out.println("[1] Comprar");
            System.out.println("[2] Salir");
            System.out.println("----------------   Elige una opcion: ");

            String option = "";
            option = input.nextLine();

            if(option.equals("1"))
                this.machineController.machineSelection(machines);
            else if(option.equals("2")){
                System.out.println("Saliendo...");
                exit = true;
            }
            //exit = true;
        }while(!exit);
    }

}
