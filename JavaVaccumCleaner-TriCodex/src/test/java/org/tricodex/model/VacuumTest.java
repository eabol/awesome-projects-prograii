package org.tricodex.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.enums.BoostType;
import org.tricodex.utils.enums.MoveDirection;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class VacuumTest {

    @Mock
    private CellManager cellManager;

    @Mock
    private Cell cell;

    private Vacuum vacuum;

    @BeforeEach
    public void setUp() {
        lenient().when(cellManager.getMapWidth()).thenReturn(500);  // Mock to return a positive value
        lenient().when(cellManager.getMapHeight()).thenReturn(500);  // Mock to return a positive value
        lenient().when(cellManager.getCellByPoint(any(Point.class))).thenReturn(cell);
        lenient().when(cell.cellIsDirty()).thenReturn(true);
        vacuum = new Vacuum(new Point(0, 0), 5, cellManager, 1, 1);
    }


    @Test
    public void testMove() {
        vacuum.move(MoveDirection.RIGHT);
        assertEquals(99.9, vacuum.getBatteryFill());
    }

    @Test
    public void testRecharge() {
        vacuum.move(MoveDirection.RIGHT);
        vacuum.recharge();
        assertEquals(100.0, vacuum.getBatteryFill());
    }

    @Test
    public void testEmptyBag() {
        vacuum.emptyBag();
        assertEquals(0, vacuum.getBagFill());
    }

    @Test
    public void testApplyPowerUpBatteryLevel() {
        vacuum.applyPowerUp(BoostType.BATTERY_LEVEL, 20);
        assertEquals(100, vacuum.getBatteryFill());
    }

    @Test
    public void testApplyPowerUpBatteryMax() {
        vacuum.applyPowerUp(BoostType.BATTERY_MAX, 50);
        assertEquals(150, vacuum.getBatteryCapacity());
    }

    @Test
    public void testApplyPowerUpVacuumCapacity() {
        vacuum.applyPowerUp(BoostType.VACUUM_CAPACITY, 50);
        assertEquals(150, vacuum.getBagCapacity());
    }

    @Test
    public void testApplyPowerUpRechargeMax() {
        vacuum.applyPowerUp(BoostType.RECHARGE_MAX, 3);
        assertEquals(8, vacuum.getMAX_RECHARGES());
    }

    @Test
    public void testApplyPowerUpEmptyMax() {
        vacuum.applyPowerUp(BoostType.EMPTY_MAX, 3);
        assertEquals(8, vacuum.getMAX_EMPTIES());
    }

    @Test
    public void testReset() {
        vacuum.applyPowerUp(BoostType.EMPTY_MAX, 3);
        vacuum.move(MoveDirection.RIGHT);
        vacuum.reset();
        assertEquals(100, vacuum.getBatteryCapacity());
        assertEquals(100, vacuum.getBagCapacity());
        assertEquals(100, vacuum.getBatteryFill());
        assertEquals(0, vacuum.getBagFill());
        assertEquals(5, vacuum.getMAX_RECHARGES());
        assertEquals(5, vacuum.getMAX_EMPTIES());
        assertEquals(0, vacuum.getCleaningScore());
        assertEquals(4, vacuum.getSpeed());
    }
}
