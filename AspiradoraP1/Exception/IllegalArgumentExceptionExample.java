package Exception;

import vacuum.VacuumCleaner;

public class IllegalArgumentExceptionExample extends Exception {
    public static void main(String[] args) {
        try {
            int bagCapacity = -10;
            VacuumCleaner P1 = new VacuumCleaner(5,12,5,0,-10,900,900,0,true);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Capacity must be a positive integer");
        }
    }
}



