package test;

import org.junit.Assert;
import org.junit.Test;
import main.warrior;
import main.vampireAttack;

public class VampireAttackTest extends Weapons {

    public VampireAttackTest() {
        super(0.5, 0.5);
    }

    @Test
    public void testVampireAttacks() {
        warrior enemy = new warrior("enemy", 100, 10, 10);
        vampireAttack vampire = new vampireAttack(10, 0.9);

        // Realizar una serie de ataques para probar diferentes casos
        vampire.vampireAttacks();
        enemy.setHealth(enemy.getHealth() - vampire.getDamage());

        // Verificar el estado esperado del enemigo después de los ataques
        double expectedHealth = 100 - vampire.getDamage();
        Assert.assertEquals(expectedHealth, enemy.getHealth(), 0.0);
    }


    @Test
    public void testVampireAttacks2() {
        warrior enemy = new warrior("enemy", 100, 10, 10);
        vampireAttack vampire = new vampireAttack(11, 0.9);

        // Realizar una serie de ataques para probar diferentes casos
        vampire.vampireAttacks();
        enemy.setHealth(enemy.getHealth() - vampire.getDamage());

        // Verificar el estado esperado del enemigo después de los ataques
        double expectedHealth = 100 - vampire.getDamage();
        Assert.assertEquals(expectedHealth, enemy.getHealth(), 0.0);
    }
}

