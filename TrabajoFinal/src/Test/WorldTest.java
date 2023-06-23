package Test;

import Main.State;
import Main.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {
    @Test
    public void testCheckAlive() {
        World world = new World();
        world.well.setWaterDepth(-10);
        world.snail.setAltitude(-5);

        State result = world.check();

        assertEquals(State.ALIVE, result, "Snail should be alive when water depth is less than snail altitude");
        assertEquals(State.ALIVE, world.snail.getState(), "Snail state should be set to alive");
    }

    @Test
    public void testCheckDeath() {
        World world = new World();
        world.well.setWaterDepth(-5);
        world.snail.setAltitude(-10);

        State result = world.check();

        assertEquals(State.DEATH, result, "Snail should be dead when water depth is greater than or equal to snail altitude");
        assertEquals(State.DEATH, world.snail.getState(), "Snail state should be set to death");
    }

}