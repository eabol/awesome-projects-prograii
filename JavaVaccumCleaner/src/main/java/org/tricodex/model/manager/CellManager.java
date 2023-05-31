package org.tricodex.model.manager;

import org.tricodex.model.Cell;
import org.tricodex.utils.enums.DirtLevel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CellManager {
    private Cell[] cell;

    public CellManager () {
        cell = new Cell[10];

        getCellImage();
    }

    public void getCellImage() {
        try {
            cell[0] = new Cell(cell[0].getPosition(), DirtLevel.CLEAN, false);
            cell[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/clean.png"));

            cell[1] = new Cell(cell[1].getPosition(), DirtLevel.DIRTY, false);
            cell[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirty.png"));

            cell[2] = new Cell(cell[2].getPosition(), DirtLevel.VERY_DIRTY, false);
            cell[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/very_dirty.png"));

            cell[3] = new Cell(cell[3].getPosition(), DirtLevel.FILTHY, false);
            cell[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/filthy.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
