package test;

import main.Mole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoleTest {

    @Test
    public void testCreateMole()
    {
        Mole mole = new Mole();

        assertEquals("Esbirro", mole.getName());
    }

    @Test
    public void testPutNameToMole()
    {
        String nameExpected = "Maurisio";

        Mole mole = new Mole(nameExpected);

        String actualName = mole.getName();

        assertEquals(nameExpected, actualName);
    }

    @Test
    public void testGetAvatarOfMole(){
        String avatar = "\'\'";

        Mole mole = new Mole();

        String actualAvatar = mole.getAvatar();

        assertEquals(avatar, actualAvatar);
    }

}