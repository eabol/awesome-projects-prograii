package test;
import main.Sword;
import org.junit.Assert;
import org.junit.Test;

public class SwordTest extends Weapons{

    public SwordTest() {
        super(0.5, 0.5);
    }

    @Test
    public void testDamage() {
        Sword handaxe1 = new Sword(0,5);
        handaxe1.setDamage(10);

        double expectedDamage = 10;
        double actualDamage = handaxe1.getDamage();

        Assert.assertEquals(expectedDamage, actualDamage, 0.0);
    }

    @Test
    public void testAccuracy() {
        Sword handaxe1 = new Sword(0,6);
        handaxe1.setAccuracy(0.75);

        double expectedAccuracy = 0.75;
        double actualAccuracy = handaxe1.getAccuracy();

        Assert.assertEquals(expectedAccuracy, actualAccuracy, 0.0);
    }
}


