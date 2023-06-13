package Vacuum;

import Vacuum.Board;
import Vacuum.Cat;

import java.util.Scanner;
public class Controller {
    public static void main(String[] args) {

        VacuumCleaner P1 = new VacuumCleaner(5,12,5,0,30,900,900,0,true);
        Cat C1 = new Cat(6,6,6,true, false);
        System.out.println("la aspiradora ha sido desplegada");

        Board map = new Board(10,25);
        map.generateMap();


        for (int i=0;i<=25;i++){

            imprimir(P1, C1, map);

            map.printMap();
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
            case 'm', 'M' -> P1.DMovement(P1);
            default -> {
                if (P1.getAutomated()) {
                    P1.RMovement();
                    P1.setSteps(P1.getSteps()+1);
                    P1.setCurrentBattery(P1.getCurrentBattery()-1);
                }
            }
        }
    }

    public static void imprimir(VacuumCleaner P1, Cat C1, Board map){
        System.out.println("______________________________________________________________________");
        System.out.println("(f) Finish");
        System.out.println("total dirt:" + map.getTotalDirt());
        System.out.println("Vacuum cleaner's current coordinates: "
                + P1.getXCoordinate() + "," + P1.getYCoordinate());
        System.out.println("Battery left: " + P1.getCurrentBattery() + "/" + P1.getMaxBattery() );
        System.out.println("Bag status: " + P1.getBag() + "/" + P1.getBagCapacity() );
        System.out.println("Steps taken: " + P1.getSteps());
        if (P1.getBag()== P1.getBagCapacity()){
            System.out.println("(E) The bag is full! Please empty the bag");
        }
        if (C1.isPresent) {
            System.out.println("the cat's current coordinates: "
                    + C1.getXCoordinate() + "," + C1.getYCoordinate());
        }
        System.out.println("(R) Toggle automated mode: " + P1.getAutomated());
        System.out.println("(M) Manual movement");
        System.out.println("______________________________________________________________________");


    }

}