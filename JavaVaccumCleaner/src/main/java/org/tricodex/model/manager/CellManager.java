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


    public CellManager(ScreenSettings screenSettings) {
        this.cell = new Cell[16];
        this.screenSettings = screenSettings;
        this.mapCellNumber = new int[screenSettings.getMaxScreenTilesWidth()][screenSettings.getMaxScreenTilesHeight()];

        getCellImage();

    }

    public void getCellImage() {
        try {
            cell[0] = new Cell(new Point(0, 16), DirtLevel.CLEAN, false);
            cell[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/clean.png"));
            cell[0].hasFurniture();

            cell[1] = new Cell(new Point(1, 48), DirtLevel.DIRTY, false);
            cell[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirty.png"));

            cell[2] = new Cell(new Point(2, 48), DirtLevel.VERY_DIRTY, false);
            cell[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/very_dirty.png"));

            cell[3] = new Cell(new Point(3, 64), DirtLevel.FILTHY, false);
            cell[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/filthy.png"));

            cell[4] = new Cell(new Point(5, 13), DirtLevel.CLEAN, true);
            cell[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/chair1.png"));

            cell[5] = new Cell(new Point(22, 19), DirtLevel.CLEAN, true);
            cell[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/chair2.png"));

            cell[6] = new Cell(new Point(11, 16), DirtLevel.CLEAN, true);
            cell[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/chair3.png"));

            cell[7] = new Cell(new Point(8, 13), DirtLevel.CLEAN, true);
            cell[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/chair4.png"));

            cell[8] = new Cell(new Point(5, 16), DirtLevel.CLEAN, true);
            cell[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/chair5.png"));

            cell[9] = new Cell(new Point(13, 9), DirtLevel.CLEAN, true);
            cell[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/chair6.png"));

            cell[10] = new Cell(new Point(9, 12), DirtLevel.CLEAN, true);
            cell[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/side table.png"));

            cell[11] = new Cell(new Point(20, 17), DirtLevel.CLEAN, true);
            cell[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/small table1.png"));

            cell[12] = new Cell(new Point(5, 20), DirtLevel.CLEAN, true);
            cell[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/small table2.png"));

            cell[13] = new Cell(new Point(4, 18), DirtLevel.CLEAN, true);
            cell[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/stool.png"));

            cell[14] = new Cell(new Point(2, 21), DirtLevel.CLEAN, true);
            cell[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/table.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cell getCell(int index) {
        return cell[index];
    }

    public void addFurniture(Cell localCell) {
        if (!localCell.hasFurniture() && localCell == cell[0]) {
            localCell.setHasFurniture(true);
        }
    }

    public void removeFurniture(Cell localCell) {
        if (localCell.hasFurniture()) {
            localCell.setHasFurniture(false);
        }
    }


    public int[][] getMapCellNumber() {
        return mapCellNumber;
    }

}
