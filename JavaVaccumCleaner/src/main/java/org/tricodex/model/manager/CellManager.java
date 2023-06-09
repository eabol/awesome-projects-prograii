package org.tricodex.model.manager;

import org.tricodex.factory.CellFactory;
import org.tricodex.model.Cell;
import org.tricodex.utils.enums.DirtLevel;
import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;
import java.io.IOException;

public class CellManager {

    private static final int WALL_CELL = 0;
    private static final int FLOOR_CELL = 1;
    private static final int FURNITURE_CELL = 2;

    private int[][] mapCellNumber;
    private Cell[][] mapCell;
    private final ScreenSettings screenSettings;
    private final CellFactory cellFactory;

    public CellManager(ScreenSettings screenSettings, CellFactory cellFactory) {
        this.screenSettings = screenSettings;
        this.cellFactory = cellFactory;
    }

    public void setMapCellNumber(int[][] mapCellNumber) {
        this.mapCellNumber = mapCellNumber;
        initializeMapCell();
    }

    private void initializeMapCell() {
        mapCell = new Cell[mapCellNumber.length][mapCellNumber[0].length];

        for (int i = 0; i < mapCellNumber.length; i++) {
            for (int j = 0; j < mapCellNumber[i].length; j++) {
                Point position = new Point(i * screenSettings.getTileSize(), j * screenSettings.getTileSize());
                int cellType = mapCellNumber[i][j];

                switch (cellType) {
                    case WALL_CELL -> mapCell[i][j] = cellFactory.createWallCell(position);
                    case FLOOR_CELL -> mapCell[i][j] = cellFactory.createFloorCell(position);
                    case FURNITURE_CELL -> mapCell[i][j] = cellFactory.createFurnitureCell(position);
                    default -> throw new IllegalArgumentException("Invalid cell type at index [" + i + ", " + j + "]: " + cellType);
                }
            }
        }
    }

    public int[][] getMapCellNumber() {
        return mapCellNumber;
    }

    public Cell getCellByPoint(Point position) {
        int i = position.x / screenSettings.getTileSize();
        int j = position.y / screenSettings.getTileSize();
        if (i >= mapCell.length || i < 0 || j >= mapCell[i].length || j < 0) {
            throw new IllegalArgumentException("Invalid cell index: " + i + ", " + j);
        }
        return mapCell[i][j];
    }

    public Cell getCellByIndices(int i, int j) {
        if (i >= mapCell.length || i < 0 || j >= mapCell[i].length || j < 0) {
            throw new IllegalArgumentException("Invalid cell index: " + i + ", " + j);
        }
        return mapCell[i][j];
    }

    public int getMapWidth() {
        return screenSettings.getScreenWidth();
    }

    public int getMapHeight() {
        return screenSettings.getScreenHeight();
    }

    public int getCellSize() {
        return screenSettings.getTileSize();
    }

    public int getMapCellWidth() {
        return screenSettings.getMaxScreenTilesWidth();
    }

    public int getMapCellHeight() {
        return screenSettings.getMaxScreenTilesHeight();
    }
}
