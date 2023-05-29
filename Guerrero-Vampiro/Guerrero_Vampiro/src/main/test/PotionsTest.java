package test;

import main.warrior;
import org.junit.jupiter.api.Test;
import main.potions;

import static org.junit.jupiter.api.Assertions.*;

public class PotionsTest extends Equipment{

    public PotionsTest() {
        super("Potion", 1);
    }

    @Test
    public void testBerserkPotion() {
        warrior character = new warrior("Warrior", 100, 100, 100);
        potions potion = new potions("Berserk", 1);

        potion.berserkPotion(character);

        // Verificar el estado esperado del personaje después de usar la poción Berserk
        assertEquals(150, character.getHealth(), 0.0);
        potion.deactivateberserkPotion();
        assertFalse(potion.berserkActive);
    }

    @Test
    public void testHealthPotion() {
        warrior character = new warrior("Warrior", 100, 100, 100);
        potions potion = new potions("Health", 1);

        potion.lastBreath(character);

        // Verificar el estado esperado del personaje después de usar la poción de salud
        assertEquals(110, character.getHealth(), 0.0);
        potion.deactivatelastBreathPotion();
        assertFalse(potion.healthActive);
    }

    @Test
    public void testRockSolid() {
        warrior character = new warrior("Warrior", 100, 100, 100);
        potions potion = new potions("Rock Solid", 1);

        potion.rockSolid(character);

        // Verificar que la poción Rock Solid no haya tenido ningún efecto en el personaje
        assertEquals(100, character.getHealth(), 0.0);
        potion.deactivaterockPotion();
        assertFalse(potion.rockActive);
    }

    @Test
    public void testSeagullEye() {
        warrior character = new warrior("Warrior", 100, 100, 100);
        potions potion = new potions("Seagull Eye", 1);

        potion.seagullEye(character);

        // Verificar el estado esperado del personaje después de usar la poción Seagull Eye
        assertEquals(100, character.getHealth(), 0.0);
        potion.deactivateeyePotion();
        assertFalse(potion.eyeActive);
    }

    @Test
    public void testTwitterEssence() {
        warrior character = new warrior("Warrior", 100, 100, 100);
        potions potion = new potions("Twitter Essence", 1);

        potion.twitterEssence(character);

        // Verificar el estado esperado del personaje después de usar la poción Twitter Essence
        assertEquals(100, character.getHealth(), 0.0);
        potion.deactivatetwitterPotion();
        assertFalse(potion.twitterActive);
    }
}

