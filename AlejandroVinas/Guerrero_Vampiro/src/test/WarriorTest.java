package test;

import main.Warrior;
import org.junit.jupiter.api.Test;
import main.Characters;

import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest extends Characters {

    public WarriorTest(){
        super("Warrior", 100);
    }

    @Test
    public void testSetName() {
        Warrior warrior = new Warrior("Warrior", 100);
        warrior.setName("New Warrior");

        assertEquals("New Warrior", warrior.getName());
    }

    @Test
    public void testSetHealth() {
        Warrior warrior = new Warrior("Warrior", 100);
        warrior.setHealth(150);

        assertEquals(150, warrior.getHealth(), 0.0);
    }


    @Test
    public void testGetHealth() {
        Warrior warrior = new Warrior("Warrior", 100);

        assertEquals(100, warrior.getHealth(), 0.0);
    }



    @Test
    public void testGetName() {
        Warrior warrior = new Warrior("Warrior", 100);

        assertEquals("Warrior", warrior.getName());
    }




}
