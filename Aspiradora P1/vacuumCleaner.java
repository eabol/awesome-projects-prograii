package vacuum;


public class VacuumCleaner extends MovingEntity {

    int bag;

    int currentBattery;

    int maxBattery;

    int vacuumedDirt;


    public VacuumCleaner(int id, int xCoordinate, int yCoordinate,
                         int bag, int currentBattery, int maxBattery, int vacuumedDirt) {
        super(id,xCoordinate,yCoordinate);
        this.bag = bag;
        this.currentBattery = currentBattery;
        this.maxBattery = maxBattery;
        this.vacuumedDirt = vacuumedDirt;
    }




}
