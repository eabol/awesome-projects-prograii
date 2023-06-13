package vacuum;


public class VacuumCleaner extends MovingEntity{

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
