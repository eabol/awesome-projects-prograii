package org.tricodex.model.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class MapLoaderTest {
    private MapLoader mapLoader;
    private ScreenSettings mockScreenSettings;
    private CellManager mockCellManager;

    @BeforeEach
    public void setUp() {
        mockScreenSettings = Mockito.mock(ScreenSettings.class);
        mockCellManager = Mockito.mock(CellManager.class);
        Mockito.when(mockScreenSettings.getMaxScreenTilesWidth()).thenReturn(3);
        Mockito.when(mockScreenSettings.getMaxScreenTilesHeight()).thenReturn(3);

        mapLoader = new MapLoader(mockScreenSettings, mockCellManager);
    }

    @Test
    public void testLoadMap() {
        mapLoader.loadMap("/testMap.txt"); // The file is in src/test/resources
        Mockito.verify(mockCellManager, Mockito.times(1)).setMapCellNumber(new int[][] {
                {0, 1, 2},
                {1, 2, 0},
                {2, 0, 1}
        });
    }

    @Test
    public void testLoadMapWithException() {
        assertThrows(RuntimeException.class, () -> mapLoader.loadMap("nonexistent/path"));
    }

}
