package org.tricodex.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.tricodex.utils.enums.DirtLevel;
import org.tricodex.view.assets.AssetLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    private Cell cell;
    private BufferedImage mockImage;
    private AssetLoader mockLoader;

    @BeforeEach
    public void setUp() {
        mockImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        mockLoader = Mockito.mock(AssetLoader.class);
        Mockito.when(mockLoader.loadImage(Mockito.anyString())).thenReturn(mockImage);

        cell = new Cell(new Point(10, 10), DirtLevel.CLEAN, false, mockImage, 1, mockLoader);
    }

    @Test
    public void testCanCollide() {
        assertFalse(cell.canCollide());
    }

    @Test
    public void testCellIsDirty() {
        assertFalse(cell.cellIsDirty());
    }

    @Test
    public void testClean() {
        cell.increaseDirtLevel();
        assertTrue(cell.cellIsDirty());

        cell.clean();
        assertFalse(cell.cellIsDirty());
    }

    @Test
    public void testIncreaseDirtLevel() {
        assertFalse(cell.cellIsDirty());

        cell.increaseDirtLevel();
        assertTrue(cell.cellIsDirty());
    }

    @Test
    public void testGetImage() {
        assertSame(mockImage, cell.getImage());
    }
}
