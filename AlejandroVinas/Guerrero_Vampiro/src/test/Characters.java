package test;
import org.junit.jupiter.api.Test;

public abstract class Characters {
    protected String name;
    protected double health;



    public Characters(String name, double health) {
        this.name = name;
        this.health = health;
    }


}
