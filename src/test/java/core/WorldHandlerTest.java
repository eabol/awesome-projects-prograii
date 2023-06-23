package core;

import org.junit.Test;
import view.WorldHandler;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WorldHandlerTest {
    @Test
    public void testStartGameThread() {
        WorldHandler worldHandler = new WorldHandler();
        worldHandler.startGameThread();
        Thread gameThread = worldHandler.gameThread;
        assertNotNull(gameThread);
        assertTrue(gameThread.isAlive());
    }
}
