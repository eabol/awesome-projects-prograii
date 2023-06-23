package test;

import main.SoulShypon;
import main.Warrior;
import org.junit.Assert;
import org.junit.Test;

public class SoulShyponTest extends Weapons{

    Warrior enemy = new Warrior("enemy", 100);
    SoulShypon bite = new SoulShypon("Bite", 15);

    public SoulShyponTest() {
        super(0.5, 0.5);
    }


    @Test
    public void testBiteAttacks() {




        bite.soulAttack();
        enemy.setHealth(enemy.getHealth() - bite.getDamage());


        double expectedHealth = 100 - bite.getDamage();
        Assert.assertEquals(expectedHealth, enemy.getHealth(), 0.0);
    }
    @Test
    public void testBiteAttacks2() {
        bite.setDamage(25);
        bite.setAccuracy(78.0);

        bite.soulAttack();
        enemy.setHealth(enemy.getHealth() - bite.getDamage());


        double expectedHealth = 100 - bite.getDamage();
        Assert.assertEquals(expectedHealth, enemy.getHealth(), 0.0);
    }
}
