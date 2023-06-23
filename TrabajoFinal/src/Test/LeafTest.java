package Test;

import Main.Leaf;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeafTest {

    @Test
    public void testLeafFall() {
        Leaf leaf = new Leaf();
        leaf.setDescription("The leaf fell");

        assertEquals("The leaf fell", leaf.getDescription());
    }

    @Test
    public void testNoLeafFall() {
        Leaf leaf = new Leaf();
        leaf.setDescription("No leaf fell");

        assertEquals("No leaf fell", leaf.getDescription());
    }
}