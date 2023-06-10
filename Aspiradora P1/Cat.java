package vacuum;

public class Cat extends MovingEntity{
    Boolean isPresent = true;

    public Cat(int id, int xCoordinate, int yCoordinate, Boolean isPresent) {
        super(id, xCoordinate, yCoordinate);
        this.isPresent = isPresent;

    }
}
