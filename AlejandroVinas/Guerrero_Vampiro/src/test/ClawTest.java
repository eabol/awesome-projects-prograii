package test;
import main.Warrior;
import org.junit.Assert;
import org.junit.Test;
import main.Claw;

public class ClawTest extends Weapons{
    Warrior enemy = new Warrior("enemy", 100);
    Claw claw = new Claw("Claw", 15);
    public ClawTest() {
        super(0.5, 0.5);
    }
    @Test
    public void testClawAttacks() {



            claw.clawAttack();
            enemy.setHealth(enemy.getHealth() - claw.getDamage());


            double expectedHealth = 100 - claw.getDamage();
            Assert.assertEquals(expectedHealth, enemy.getHealth(), 0.0);
    }
    @Test
    public void testClawAttacks2() {

        claw.setDamage(25);
        claw.setAccuracy(78.0);

        claw.clawAttack();
        enemy.setHealth(enemy.getHealth() - claw.getDamage());


        double expectedHealth = 100 - claw.getDamage();
        Assert.assertEquals(expectedHealth, enemy.getHealth(), 0.0);
    }
}
