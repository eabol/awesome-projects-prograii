package vacuum;


public class VacuumCleaner extends MovingEntity{

    int bag;

    int currentBattery;

    int maxBattery;

    int vacuumedDirt;

    public VacuumCleaner(){

    }

    public VacuumCleaner(int id, int xCoordinate, int yCoordinate,
                         int bag, int currentBattery, int maxBattery, int vacuumedDirt, boolean automated) {
        super(id,xCoordinate,yCoordinate, automated);
        this.bag = bag;
        this.currentBattery = currentBattery;
        this.maxBattery = maxBattery;
        this.vacuumedDirt = vacuumedDirt;
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
}
