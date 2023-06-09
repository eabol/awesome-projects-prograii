package org.tricodex.model.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.tricodex.factory.CellFactory;
import org.tricodex.model.Cell;
import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CellManagerTest {
    private CellManager cellManager;
    private CellFactory mockCellFactory;
    private ScreenSettings mockScreenSettings;
    private Cell mockCell;

    @BeforeEach
    public void setUp() {
        mockCellFactory = Mockito.mock(CellFactory.class);
        mockScreenSettings = Mockito.mock(ScreenSettings.class);
        mockCell = Mockito.mock(Cell.class);

        Mockito.when(mockScreenSettings.getTileSize()).thenReturn(10);
        Mockito.when(mockScreenSettings.getScreenWidth()).thenReturn(100);
        Mockito.when(mockScreenSettings.getScreenHeight()).thenReturn(100);
        Mockito.when(mockCellFactory.createWallCell(Mockito.any())).thenReturn(mockCell);
        Mockito.when(mockCellFactory.createFloorCell(Mockito.any())).thenReturn(mockCell);
        Mockito.when(mockCellFactory.createFurnitureCell(Mockito.any())).thenReturn(mockCell);

        cellManager = new CellManager(mockScreenSettings, mockCellFactory);
        cellManager.setMapCellNumber(new int[][]{
                {0, 1, 2},
                {2, 0, 1},
                {1, 2, 0}
        });
    }

    @Test
    public void testGetCellByPoint() {
        Cell cell = cellManager.getCellByPoint(new Point(0, 0));
        assertNotNull(cell);
        assertSame(mockCell, cell);
    }

    @Test
    public void testGetCellByIndices() {
        Cell cell = cellManager.getCellByIndices(1, 1);
        assertNotNull(cell);
        assertSame(mockCell, cell);
    }

    @Test
    public void testGetMapWidth() {
        assertEquals(100, cellManager.getMapWidth());
    }

    @Test
    public void testGetMapHeight() {
        assertEquals(100, cellManager.getMapHeight());
    }

    @Test
    public void testGetCellSize() {
        assertEquals(10, cellManager.getCellSize());
    }

    @Test
    public void testInvalidIndices() {
        assertThrows(IllegalArgumentException.class, () -> cellManager.getCellByIndices(10, 10));
    }

    @Test
    public void testInvalidPoint() {
        assertThrows(IllegalArgumentException.class, () -> cellManager.getCellByPoint(new Point(1000, 1000)));
    }
}
