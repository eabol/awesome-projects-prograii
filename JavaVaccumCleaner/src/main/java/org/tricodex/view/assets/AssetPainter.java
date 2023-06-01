package org.tricodex.view.assets;

import org.tricodex.model.Cell;
import org.tricodex.model.Vaccum;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;

public abstract class AssetPainter {
    public static void paintVaccumCleaner(Graphics2D g2, Vaccum vaccum, ScreenSettings screenSettings) {
        g2.setColor(Color.RED);
        g2.fillRect(vaccum.getPosition().x, vaccum.getPosition().y, screenSettings.getTileSize(), screenSettings.getTileSize());
    }

    public static void paintCells(Graphics2D g2, CellManager cellManager, ScreenSettings screenSettings, int mapCellNum[][]) {
        int col = 0;
        int row = 0;

        int x = 0;
        int y = 0;

        while (col < screenSettings.getMaxScreenTilesWidth() && row < screenSettings.getMaxScreenTilesHeight()) {
            int cellNum = mapCellNum[col][row];

            g2.drawImage(cellManager.getCell(cellNum).image, x, y, screenSettings.getTileSize(), screenSettings.getTileSize(), null);
            col++;
            x += screenSettings.getTileSize();

            if (col == screenSettings.getMaxScreenTilesWidth()) {
                col = 0;
                x = 0;
                row++;
                y += screenSettings.getTileSize();
            }
        }
    }
}
