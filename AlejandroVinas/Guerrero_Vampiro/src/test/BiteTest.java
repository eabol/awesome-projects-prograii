package test;
import org.junit.Assert;
import org.junit.Test;
import main.Warrior;
import main.Bite;
public class BiteTest extends Weapons{
Warrior enemy = new Warrior("enemy", 100);
Bite bite = new Bite("Bite", 15);
    public BiteTest() {
        super(0.5, 0.5);
    }
    @Test
    public void testBiteAttacks() {




        bite.biteAttack();
        enemy.setHealth(enemy.getHealth() - bite.getDamage());


        double expectedHealth = 100 - bite.getDamage();
        Assert.assertEquals(expectedHealth, enemy.getHealth(), 0.0);
    }
    @Test
    public void testBiteAttacks2() {
        bite.setDamage(25);
        bite.setAccuracy(78.0);

        bite.biteAttack();
        enemy.setHealth(enemy.getHealth() - bite.getDamage());


        double expectedHealth = 100 - bite.getDamage();
        Assert.assertEquals(expectedHealth, enemy.getHealth(), 0.0);
    }
}
