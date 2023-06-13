package vacuum;


public class VacuumCleaner extends MovingEntity implements Entity{

    int bag;

    int bagCapacity;

    int currentBattery;

    int maxBattery;

    int steps;

    public VacuumCleaner(int id, int xCoordinate, int yCoordinate,
                         int bag, int bagCapacity, int currentBattery, int maxBattery, int steps, boolean automated) {
        super(id,xCoordinate,yCoordinate, automated);
        this.bag = bag;
        this.bagCapacity = bagCapacity;
        this.currentBattery = currentBattery;
        this.maxBattery = maxBattery;
        this.steps = steps;
        this.automated = automated;
    }

    public void emptyBag(){
        if (this.bag == 0){
            System.out.println("The bag is already empty");
        } else {
            this.bag = 0;
            System.out.println("The bag has been emptied");
        }
    }

    public void checkBattery(VacuumCleaner P1){
        System.out.println("Battery left: " + P1.getCurrentBattery() + "/" + P1.getMaxBattery() );
        if (P1.getCurrentBattery() <= 0){
            System.out.println("¡You ran out of battery!");
            System.out.println("Total steps made:" +P1.getSteps());
            System.out.println("You Lost!");
            System.exit(0);
        }
    }

    public void checkCoordinates(VacuumCleaner P1){
        System.out.println("Vacuum cleaner's current coordinates: "
                + P1.getXCoordinate() + "," + P1.getYCoordinate());
    }

    public void checkBag(VacuumCleaner P1){
        System.out.println("Bag status: " + P1.getBag() + "/" + P1.getBagCapacity() );
        if (P1.getBag()== P1.getBagCapacity()){
            System.out.println("(E) The bag is full! Please empty the bag");
        }
    }

    public int getBag() {
        return bag;
    }

    public int getBagCapacity() {
        return bagCapacity;
    }


    public int getCurrentBattery() {
        return currentBattery;
    }

    public void setCurrentBattery(int currentBattery) {
        this.currentBattery = currentBattery;
    }

    public int getMaxBattery() {
        return maxBattery;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
