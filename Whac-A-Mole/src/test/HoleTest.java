package test;

import main.Mole;
import main.SmackableCharacter;
import org.junit.Assert;
import org.junit.Test;
import main.Hole;

public class HoleTest {

    @Test
    public void testGetAspect() {
        Hole hole = new Hole();
        hole.setAspect("Round");
        String aspect = hole.getAspect();
        Assert.assertEquals("Round", aspect);
    }

    @Test
    public void testSetAspect() {
        Hole hole = new Hole();
        hole.setAspect("Square");
        String aspect = hole.getAspect();
        Assert.assertEquals("Square", aspect);
    }

    @Test
    public void testShowMoleInside() {
        // Se crea un objeto Hole
        Hole hole = new Hole();

        // Se verifica inicialmente que no haya un personaje golpeable en el agujero
        Assert.assertEquals("No mole inside", hole.showMoleInside());

        // Se crea un personaje golpeable
        SmackableCharacter character = new Mole("Mole");
        character.setAvatar("Mole");

        // Se establece el personaje golpeable en el agujero
        hole.setSmackableCharacter(character);

        // Se verifica que se muestre el nombre y avatar del personaje golpeable en el agujero
        Assert.assertEquals("Mole inside: Mole", hole.showMoleInside());
    }

    @Test
    public void testIsMoleInside() {
        Hole hole = new Hole();
        boolean isMoleInside = hole.isMoleInside();
        if (isMoleInside == true) {
            System.out.println("There is a mole inside");
        }
    }
}