package test;

import main.warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest extends Characters {

    public WarriorTest(){
        super("Warrior", 100, 100, 100);
    }

    @Test
    public void testSetName() {
        warrior warrior = new warrior("Warrior", 100, 100, 100);
        warrior.setName("New Warrior");

        assertEquals("New Warrior", warrior.getName());
    }

    @Test
    public void testSetHealth() {
        warrior warrior = new warrior("Warrior", 100, 100, 100);
        warrior.setHealth(150);

        assertEquals(150, warrior.getHealth(), 0.0);
    }

    @Test
    public void testSetAttack() {
        warrior warrior = new warrior("Warrior", 100, 100, 100);
        warrior.setAttack(120);

        assertEquals(120, warrior.getAttack(), 0.0);
    }

    @Test
    public void testGetHealth() {
        warrior warrior = new warrior("Warrior", 100, 100, 100);

        assertEquals(100, warrior.getHealth(), 0.0);
    }

    @Test
    public void testGetAttack() {
        warrior warrior = new warrior("Warrior", 100, 100, 100);

        assertEquals(100, warrior.getAttack(), 0.0);
    }

    @Test
    public void testGetName() {
        warrior warrior = new warrior("Warrior", 100, 100, 100);

        assertEquals("Warrior", warrior.getName());
    }

    @Test
    public void testSetAccuracy() {
        warrior warrior = new warrior("Warrior", 100, 100, 100);
        warrior.setAccuracy(90);

        assertEquals(90, warrior.getAccuracy(), 0.0);
    }

    @Test
    public void testGetAccuracy() {
        warrior warrior = new warrior("Warrior", 100, 100, 100);

        assertEquals(100, warrior.getAccuracy(), 0.0);
    }

    @Test
    public void testSetShieldActive() {
        warrior warrior = new warrior("Warrior", 100, 100, 100);
        warrior.setShieldActive(true);

        assertTrue(warrior.getShieldActive());
    }

    @Test
    public void testSetShieldInactive() {
        warrior warrior = new warrior("Warrior", 100, 100, 100);
        warrior.setShieldInactive(true);

        assertFalse(warrior.getShieldInactive());
    }
}
