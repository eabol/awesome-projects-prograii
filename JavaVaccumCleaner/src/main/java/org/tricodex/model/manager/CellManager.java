package org.tricodex.model.manager;

import org.tricodex.model.Cell;
import org.tricodex.utils.enums.DirtLevel;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.assets.AssetLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class CellManager {
    private Cell[] cell;
    private int mapCellNumber[][];
    private ScreenSettings screenSettings;


    public CellManager (ScreenSettings screenSettings) {
        this.cell = new Cell[5];
        this.screenSettings = screenSettings;
        this.mapCellNumber = new int[screenSettings.getMaxScreenTilesWidth()][screenSettings.getMaxScreenTilesHeight()];

        getCellImage();

    }

    public void getCellImage() {
        try {
            cell[0] = new Cell(new Point(0, 16), DirtLevel.CLEAN, false);
            cell[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/clean.png"));

            cell[1] = new Cell(new Point(1, 48), DirtLevel.DIRTY, false);
            cell[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirty.png"));

            cell[2] = new Cell(new Point(2, 48), DirtLevel.VERY_DIRTY, false);
            cell[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/very_dirty.png"));

            cell[3] = new Cell(new Point(3, 64), DirtLevel.FILTHY, false);
            cell[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/filthy.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cell getCell(int index) {
        for (int i = 0; i < cell.length; i++) {
            if (i == index) {
                return cell[i];
            }
        }
        return null;
    }

    public void addFurniture(Cell localCell) {
        if (!localCell.hasFurniture() && localCell == cell[0]) {
            localCell.setHasFurniture(true);
        }
    }

    public void removeFurniture(Cell localCell) {
        if(localCell.hasFurniture()) {
            localCell.setHasFurniture(false);
        }
    }


    public int[][] getMapCellNumber() {
        return mapCellNumber;
    }
}
