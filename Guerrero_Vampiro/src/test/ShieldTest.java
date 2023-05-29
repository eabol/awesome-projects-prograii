package test;

import main.warrior;
import org.junit.jupiter.api.Test;
import main.shield;

import static org.junit.jupiter.api.Assertions.*;

public class ShieldTest extends Equipment {

    public ShieldTest() {
        super( "Shield", 1);
    }

    @Test
    public void testActivateShield() {
        shield shield = new shield("Shield", 1);

        assertTrue(shield.activateShield());
    }

    @Test
    public void testDeactivateShield() {
        shield shield = new shield("Shield", 1);

        assertFalse(shield.deactivateShield());
    }

    @Test
    public void testSetName() {
        shield shield = new shield("Shield", 1);
        shield.setName("New Shield");

        assertEquals("New Shield", shield.getName());
    }

    @Test
    public void testSetCuantity() {
        shield shield = new shield("Shield", 1);
        shield.setCuantity(2);

        assertEquals(2, shield.getCuantity(), 0.0);
    }

    @Test
    public void testShieldUp() {
        warrior character = new warrior("Warrior", 100, 100, 100);
        shield shield = new shield("Shield", 1);

        shield.shieldUp(character);

        assertTrue(character.getShieldActive());
    }

    @Test
    public void testShieldDown() {
        warrior character = new warrior("Warrior", 100, 100, 100);
        shield shield = new shield("Shield", 1);

        shield.shieldDown(character);

        assertFalse(character.getShieldInactive());
    }
}

