package vacuum;

public class Controller {



    public static void gameKeys(VacuumCleaner P1, Board map1) {
        switch (PlayerInput.takePlayerInput()) {
            case 'r', 'R' -> P1.setAutomated(!P1.getAutomated());
            case 'f', 'F' -> P1.setCurrentBattery(0);
            case 'e', 'E' -> P1.emptyBag();
            case 'm', 'M' -> P1.DMovement(P1, map1);
            default -> {
                if (P1.getAutomated()) {
                    P1.RMovement(map1);
                    P1.setSteps(P1.getSteps()+1);
                    P1.setCurrentBattery(P1.getCurrentBattery()-1);
                }
            }
        }
    }

    public static void printHeader(VacuumCleaner P1, Cat C1, Board map1){
        System.out.println("______________________________________________________________________");
        System.out.println("(f) Finish");
        System.out.println("(R) Toggle automated mode: " + P1.getAutomated());
        System.out.println("(M) Manual movement");
        System.out.println("total dirt:" + map1.getTotalDirt());
        P1.checkCoordinates(P1);
        P1.checkBattery(P1);
        P1.checkBag(P1);
        System.out.println("Steps taken: " + P1.getSteps());
        C1.checkCat(C1);
        if (P1.checkCollision(map1.map)){
            System.out.println("There is something in your way");
        }
        System.out.println("______________________________________________________________________");


    }

    public static void felineActivity(Cat C1,Board map1){
        if (C1.isPresent){
            C1.RMovement(map1);
            C1.dirty(map1,map1.map);
        }
        C1.mightSpawnOrDeSpawn();
    }

    public static boolean checkGameState(VacuumCleaner P1,Cat C1, Board map1){
        if (P1.getCurrentBattery() <= 0) {
            map1.printMap(P1,C1);
            System.out.println("You ran out of battery! too bad...");
            System.out.println("Total steps made:" + P1.getSteps());
            System.out.println("You Lost!");
            return false;
        } else if (map1.getTotalDirt()==0){
            map1.printMap(P1,C1);
            System.out.println("You cleaned the entire place, Well done!");
            System.out.println("Total steps made:" +P1.getSteps());
            System.out.println("You Won!");
            System.exit(0);
            return false;
        } return true;
    }
}