package org.tricodex.view.panels;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.Panel;
import org.tricodex.view.assets.AssetPainter;

import java.awt.*;

public class SurfacePanel extends Panel {
    private CellManager cellManager;
    private AssetPainter assetPainter;

    public SurfacePanel(CellManager cellManager, AssetPainter assetPainter) {
        this.cellManager = cellManager;
        this.assetPainter = assetPainter;
    }

    public void drawSurface(Graphics2D g2d) {
        assetPainter.paintCells(g2d, cellManager, cellManager.getMapCellNumber());
    }
}
