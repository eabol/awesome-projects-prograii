package org.tricodex.model;

import java.awt.*;

import org.tricodex.utils.settings.ScreenSettings;

public class Surface {
    private final int width;
    private final int height;

    private final ScreenSettings screenSettings;
    private final int tileSize;
    private Cell[][] cells;
    private int mapCellNum[][];

    public Surface(ScreenSettings screenSettings, int mapCellNum[][]) {
        this.screenSettings = screenSettings;
        this.width = screenSettings.getScreenWidth();
        this.height = screenSettings.getScreenHeight();
        this.tileSize = screenSettings.getTileSize();
        cells = new Cell[width][height];
        this.mapCellNum = new int[screenSettings.getMaxScreenTilesWidth()][screenSettings.getMaxScreenTilesHeight()];

    }

    public Cell getCell(Point position) {
        if (isPositionWithinBounds(position)) {
            return cells[position.x][position.y];
        }
        return null;
    }

    private boolean isPositionWithinBounds(Point position) {
        return position.x >= 0 && position.x < width && position.y >= 0 && position.y < height;
    }

    public void setCell(Point position, Cell cell) {
        if (isPositionWithinBounds(position)) {
            cells[position.x][position.y] = cell;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTileSize() {
        return tileSize;
    }

    public int [][] getMapCellNum() {
        return mapCellNum;
    }

    public int getValueMapCellNum(int x, int y) {
        return mapCellNum[x][y];
    }
}
