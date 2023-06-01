package org.tricodex.view;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.Panel;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.assets.AssetLoader;
import org.tricodex.view.assets.AssetPainter;

import java.awt.*;

public class SurfacePanel extends Panel {
    CellManager cellManager;
    AssetLoader assetLoader;
    ScreenSettings screenSettings;
    public SurfacePanel(CellManager cellManager, AssetLoader assetLoader, ScreenSettings screenSettings) {
        this.cellManager = cellManager;
        this.assetLoader = assetLoader;
        this.screenSettings = screenSettings;
    }

    public void drawSurface(Graphics2D g2d) {
        assetLoader.loadMap(cellManager,screenSettings, cellManager.getMapCellNumber(), "/maps/map01.txt");
        AssetPainter.paintCells(g2d, cellManager, screenSettings, cellManager.getMapCellNumber());
    }
}
