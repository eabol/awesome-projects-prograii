package test;
import main.Flail;
import org.junit.Assert;
import org.junit.Test;

public class FlailTest extends Weapons{

    Flail flail = new Flail(0.5, 0.5);

    public FlailTest() {
        super(0.5, 0.5);
    }

    @Test
    public void testDamage() {
        Flail flail = new Flail(0,5);
        flail.setDamage(10);

        double expectedDamage = 10;
        double actualDamage = flail.getDamage();

        Assert.assertEquals(expectedDamage, actualDamage, 0.0);
    }

    @Test
    public void testAccuracy() {
        Flail flail = new Flail(0,6);
        flail.setAccuracy(0.75);

        double expectedAccuracy = 0.75;
        double actualAccuracy = flail.getAccuracy();

        Assert.assertEquals(expectedAccuracy, actualAccuracy, 0.0);
    }
}






