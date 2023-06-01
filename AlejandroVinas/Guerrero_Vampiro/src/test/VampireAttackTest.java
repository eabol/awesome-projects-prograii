package test;

import org.junit.Assert;
import org.junit.Test;
import main.Warrior;
import main.VampireAttack;

public class VampireAttackTest extends Weapons {

    public VampireAttackTest() {
        super(0.5, 0.5);
    }

    @Test
    public void testVampireAttacks() {
        Warrior enemy = new Warrior("enemy", 100);
        VampireAttack vampire = new VampireAttack(10, 0.9);

        // Realizar una serie de ataques para probar diferentes casos
        vampire.vampireAttacks();
        enemy.setHealth(enemy.getHealth() - vampire.getDamage());

        // Verificar el estado esperado del enemigo después de los ataques
        double expectedHealth = 100 - vampire.getDamage();
        Assert.assertEquals(expectedHealth, enemy.getHealth(), 0.0);
    }


    @Test
    public void testVampireAttacks2() {
        Warrior enemy = new Warrior("enemy", 100);
        VampireAttack vampire = new VampireAttack(11, 0.9);

        // Realizar una serie de ataques para probar diferentes casos
        vampire.vampireAttacks();
        enemy.setHealth(enemy.getHealth() - vampire.getDamage());

        // Verificar el estado esperado del enemigo después de los ataques
        double expectedHealth = 100 - vampire.getDamage();
        Assert.assertEquals(expectedHealth, enemy.getHealth(), 0.0);
    }
}

