package org.tricodex.model;

import org.tricodex.model.manager.CellManager;

public class DirtSensor {
    private final CellManager surface;

    public DirtSensor(CellManager surface) {
        this.surface = surface;
    }

    public Cell getDirtiestCell() {
        Cell dirtiestCell = null;
        for (int i = 0; i < surface.getMapCellWidth(); i++) {
            for (int j = 0; j < surface.getMapCellHeight(); j++) {
                Cell cell = surface.getCellByIndices(i, j);
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
