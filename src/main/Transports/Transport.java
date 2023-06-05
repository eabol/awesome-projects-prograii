package src.main.Transports;

public abstract class Transport {
    public int speed;
    public String name;

    public Transport(int speed, String name) {
        this.speed = speed;
        this.name = name;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getName() {
        return this.name;
    }

}
