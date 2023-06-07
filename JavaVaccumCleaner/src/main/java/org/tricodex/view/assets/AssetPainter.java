package org.tricodex.view.assets;

import org.tricodex.model.Cell;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.Entity;
import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;

public class AssetPainter {
    private ScreenSettings screenSettings;

    public AssetPainter(ScreenSettings screenSettings) {
        this.screenSettings = screenSettings;
    }

    public void paintEntity(Graphics2D g2, Entity entity, Color color) {
        g2.setColor(color);
        g2.fillRect(entity.getPosition().x, entity.getPosition().y, screenSettings.getTileSize(), screenSettings.getTileSize());
    }

    public void paintCells(Graphics2D g2, CellManager cellManager, int mapCellNum[][]) {
        for (int col = 0; col < mapCellNum.length; col++) {
            for ( int row = 0; row < mapCellNum[col].length; row++) {
                Cell cell = cellManager.getCellByIndices(col, row);

                // Instead of checking if cell is clean, check if image exists
                if (cell.getImage() != null) {
                    g2.drawImage(cell.getImage(), null, cell.getPosition().x, cell.getPosition().y);
                }
            }
        }
    }
}
