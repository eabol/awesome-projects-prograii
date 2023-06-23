package test;
import org.junit.jupiter.api.Test;

public abstract class Equipment {

    protected String name;
    protected int cuantity;

    public Equipment(String name, int cuantity) {
        this.name = name;
        this.cuantity = cuantity;
    }

}
