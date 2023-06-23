package test;

import org.junit.Assert;
import org.junit.Test;
import main.Intimidate;

public class IntimidateTest extends Weapons{

    Intimidate intimidate = new Intimidate(0.5, 0.5);

        public IntimidateTest() {
            super(0.5, 0.5);
        }

    @Test
    public void testDamage() {
        intimidate.setDamage(0);
        intimidate.setAccuracy(0.5);
        double expectedDamage = 0;
        double actualDamage = intimidate.getDamage();

        Assert.assertEquals(expectedDamage, actualDamage, 0.0);
    }
    @Test
    public void testDamage2() {
        intimidate.setDamage(1);
        intimidate.setAccuracy(0.5);
        double expectedDamage = 1;
        double actualDamage = intimidate.getDamage();

        Assert.assertEquals(expectedDamage, actualDamage, 0.0);
    }
}
