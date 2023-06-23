package enumerators;

public enum TransportTypes {
    BOAT(6),
    FOOT(4),
    HORSE(7),
    CARPET(5);

    private final int speed;

    TransportTypes(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

}
