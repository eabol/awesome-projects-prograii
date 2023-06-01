package test;

import main.DaggThrow;
import org.junit.Assert;
import org.junit.Test;

public class DaggThrowTest extends Weapons{

    DaggThrow daggThrow = new DaggThrow(0.5, 0.5);
    public DaggThrowTest() {
        super(0.5, 0.5);
    }

    @Test
    public void testDamage() {
        daggThrow.setDamage(10);
        daggThrow.setAccuracy(0.5);
        double expectedDamage = 10;
        double actualDamage = daggThrow.getDamage();

        Assert.assertEquals(expectedDamage, actualDamage, 0.0);
    }
    @Test
    public void testDamage2() {
        daggThrow.setDamage(1);
        daggThrow.setAccuracy(0.5);
        double expectedDamage = 1;
        double actualDamage = daggThrow.getDamage();

        Assert.assertEquals(expectedDamage, actualDamage, 0.0);
    }
}
