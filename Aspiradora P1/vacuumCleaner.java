public class vacuumCleaner extends entityInMovement {

    int bag;
    int battery;
    public vacuumCleaner(int bag, int battery, int id, int[] coordinates, String skin) {
        super(id, coordinates, skin);
        this.bag = bag;
        this.battery = battery;
    }

}
