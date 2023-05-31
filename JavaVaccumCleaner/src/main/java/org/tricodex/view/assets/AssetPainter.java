package org.tricodex.view.assets;

import org.tricodex.model.Vaccum;
import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;

public abstract class AssetPainter {
    public static void paintVaccumCleaner(Graphics2D g2, Vaccum vaccum, ScreenSettings screenSettings) {
        g2.setColor(Color.RED);
        g2.fillRect(vaccum.getPosition().x, vaccum.getPosition().y, screenSettings.getTileSize(), screenSettings.getTileSize());
    }

    public static void paintCell(Graphics2D g2) {

    }
}
