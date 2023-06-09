package org.tricodex.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.MoveObject;

import java.awt.*;

import static org.mockito.Mockito.*;

class CatTest {

    private Cat cat;
    private CellManager cellManager;
    private MoveObject moveObject;

    @BeforeEach
    void setUp() {

        //This class depends too much on other classes to be properly tested
        cellManager = Mockito.mock(CellManager.class);
        moveObject = Mockito.mock(MoveObject.class);

        Mockito.when(cellManager.getCellSize()).thenReturn(10);
        lenient().when(cellManager.getMapWidth()).thenReturn(500);
        lenient().when(cellManager.getMapHeight()).thenReturn(500);
        lenient().when(moveObject.getCurrentLocation()).thenReturn(new Point(5, 5));
        lenient().when(moveObject.getTargetLocation()).thenReturn(new Point(7, 7));
        cat = new Cat(new Point(0, 0), 2, cellManager, 1, 1);
        cat.setMoveObject(moveObject); // You may need to add a setter for moveObject in Cat class for this line.
    }

    @Test
    void testMoveRandomly() {
        cat.moveRandomly();
        verify(moveObject, times(1)).moveToTarget();
    }

    @Test
    void testCatFoul() {
        Cell cell = Mockito.mock(Cell.class);
        lenient().when(cellManager.getCellByPoint(new Point(5, 5))).thenReturn(cell);
        cat.catFoul();
        verify(cell, times(1)).increaseDirtLevel();
    }
}
