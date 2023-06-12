package vacuum;

import java.util.Scanner;
public class Controller {
    public static void main(String[] args) {

        VacuumCleaner P1 = new VacuumCleaner(5,5,5,0,300,300,1,true);
        Cat C1 = new Cat(6,6,6,true, false);
        System.out.println("la aspiradora ha sido desplegada");


        for (int i=0;i<=25;i++){

            imprimir(P1, C1);

            gameKeys(P1);

            if (C1.isPresent){
                C1.RMovement();
            } else {
                C1.mightSpawnOrDeSpawn();
            }
        }
    }

    public static char takePlayerInput(){
        Scanner input = new Scanner(System.in);
        return input.nextLine().charAt(0);
    }

    public static void gameKeys(VacuumCleaner P1) {
        switch (takePlayerInput()) {
            case 'r', 'R' -> P1.setAutomated(!P1.getAutomated());
            case 'f', 'F' -> System.out.println("el juego terminara");
            case 'e', 'E' -> P1.emptyBag();
            case 'm', 'M' -> P1.DMovement();
            default -> {
                if (P1.getAutomated()) {
                    P1.RMovement();
                }
            }
        }
    }

    public static void imprimir(VacuumCleaner P1, Cat C1){
        System.out.println("____________________________________________________");
        System.out.println("(f) Finalizar");
        System.out.println("las coordenadas actuales de la aspiradora son: "
                + P1.getXCoordinate() + " y " + P1.getYCoordinate());
        if (C1.isPresent) {
            System.out.println("las coordenadas actuales del gato son: "
                    + C1.getXCoordinate() + " y " + C1.getYCoordinate());
        }
        System.out.println("(R) modo automatizado: " + P1.getAutomated());
        System.out.println("(M) movimiento manual");
        System.out.println("____________________________________________________");


    }

}