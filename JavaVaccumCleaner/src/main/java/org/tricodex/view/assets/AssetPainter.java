package org.tricodex.view.assets;

import org.tricodex.model.Cat;
import org.tricodex.model.PowerUp;
import org.tricodex.model.Vacuum;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;

public abstract class AssetPainter {
    public static void paintVaccumCleaner(Graphics2D g2, Vacuum vacuum, ScreenSettings screenSettings) {
        g2.setColor(Color.RED);
        g2.fillRect(vacuum.getPosition().x, vacuum.getPosition().y, screenSettings.getTileSize(), screenSettings.getTileSize());
    }
    public static void paintCat(Graphics2D g2, Cat cat, ScreenSettings screenSettings) {
        g2.setColor(Color.BLUE);
        g2.fillRect(cat.getPosition().x, cat.getPosition().y, screenSettings.getTileSize(), screenSettings.getTileSize());
    }
    public static void paintPowerUp(Graphics2D g2, PowerUp cell, ScreenSettings screenSettings) {
        g2.setColor(Color.BLACK);
        g2.fillRect(cell.getPosition().x, cell.getPosition().y, screenSettings.getTileSize(), screenSettings.getTileSize());
    }

    public static void paintCells(Graphics2D g2, CellManager cellManager, ScreenSettings screenSettings, int mapCellNum[][]) {
        for (int col = 0; col < mapCellNum.length; col++) {
            for ( int row = 0; row < mapCellNum[col].length; row++) {

                int cellNum = mapCellNum[col][row];
                g2.drawImage(cellManager.getCell(cellNum).image, col* screenSettings.getTileSize(), row* screenSettings.getTileSize(), screenSettings.getTileSize(), screenSettings.getTileSize(),null);

            }

        }
    }
}
