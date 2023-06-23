package org.tricodex.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.enums.BoostType;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PowerUpTest {

    @Mock
    private CellManager cellManager;

    @Mock
    private Cell cell;

    private PowerUp powerUp;

    @BeforeEach
    public void setUp() {
        when(cellManager.getCellByPoint(any(Point.class))).thenReturn(cell);
        when(cell.canCollide()).thenReturn(false);
        when(cellManager.getMapWidth()).thenReturn(100);
        when(cellManager.getMapHeight()).thenReturn(100);
        powerUp = new PowerUp(cellManager, 5);
    }

    @Test
    public void testGenerateRandomBoost() {
        powerUp.generateRandomBoost();
        assertNotNull(powerUp.getBoostType());
        assertTrue(powerUp.getBoostAmount() >= 1 && powerUp.getBoostAmount() <= 10);
        if(powerUp.getBoostType() == BoostType.RECHARGE_MAX || powerUp.getBoostType() == BoostType.EMPTY_MAX) {
            assertEquals(5, powerUp.getBoostAmount());
        }
    }

    @Test
    public void testSetNewPosition() {
        Point oldPosition = powerUp.getPosition();
        powerUp.setNewPosition();
        Point newPosition = powerUp.getPosition();
        assertNotEquals(oldPosition, newPosition);
    }
}
