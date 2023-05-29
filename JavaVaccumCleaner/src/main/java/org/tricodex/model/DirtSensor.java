package org.tricodex.model;

import java.awt.*;

public class DirtSensor {
    private Surface surface;

    public DirtSensor(Surface surface) {
        this.surface = surface;
    }

    public Cell getDirtiestCell() {
        Cell dirtiestCell = null;
        for (int i = 0; i < surface.getWidth(); i++) {
            for (int j = 0; j < surface.getHeight(); j++) {
                Cell cell = surface.getCell(new Point(i, j));
                if (cell.getDirtLevel().ordinal() > 0) {
                    if (dirtiestCell == null) {
                        dirtiestCell = cell;
                    } else if (cell.getDirtLevel().ordinal() > dirtiestCell.getDirtLevel().ordinal()) {
                        dirtiestCell = cell;
                    }
                }
            }
        }
        return dirtiestCell;
    }
}
