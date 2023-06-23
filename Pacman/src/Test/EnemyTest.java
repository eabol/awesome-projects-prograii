package Test;

import Enemy.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    @Test
    public void testConstructor() {
        int x = 5;
        int y = 10;

        Enemy enemy = new Enemy(x, y) {
            @Override
            public void Draw() {

            }

            @Override
            public void movement() {

            }
        };

        assertEquals(x, enemy.getX());
        assertEquals(y, enemy.getY());
        assertTrue(enemy.isAlive());
    }

    @Test
    public void testSetX() {
        int newX = 7;
        Enemy enemy = new Enemy(5, 10) {
            @Override
            public void Draw() {

            }

            @Override
            public void movement() {

            }
        };

        enemy.setX(newX);

        assertEquals(newX, enemy.getX());
    }

    @Test
    public void testSetY() {
        int newY = 12;
        Enemy enemy = new Enemy(5, 10) {
            @Override
            public void Draw() {

            }

            @Override
            public void movement() {

            }
        };

        enemy.setY(newY);

        assertEquals(newY, enemy.getY());
    }

    @Test
    public void testSetAlive() {
        Enemy enemy = new Enemy(5, 10) {
            @Override
            public void Draw() {

            }

            @Override
            public void movement() {

            }
        };

        enemy.setAlive(false);

        assertFalse(enemy.isAlive());
    }
}