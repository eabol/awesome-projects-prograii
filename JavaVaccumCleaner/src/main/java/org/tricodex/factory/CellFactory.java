package org.tricodex.factory;

import org.tricodex.model.Cell;
import org.tricodex.utils.enums.DirtLevel;
import org.tricodex.view.assets.AssetLoader;

import java.awt.*;

public class CellFactory {

    private static final String TILE_PATH = "tiles/";
    private static final String[] FURNITURE_IMAGES = { "chair1.png", "chair2.png", "stool.png", "table.png" };
    private final AssetLoader imageLoader;

    public CellFactory(AssetLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public Cell createFloorCell(Point position) {
        DirtLevel dirtLevel = getDirtLevelBasedOnRandomValue();

        return new Cell(position, dirtLevel, false, imageLoader.loadImage(TILE_PATH + dirtLevel.name().toLowerCase() + ".png"));
    }

    private DirtLevel getDirtLevelBasedOnRandomValue() {
        double dirtProb = Math.random();

        if (dirtProb < 0.1) {
            return DirtLevel.CLEAN;
        } else if (dirtProb < 0.4) {
            return DirtLevel.DIRTY;
        } else if (dirtProb < 0.7) {
            return DirtLevel.VERY_DIRTY;
        } else {
            return DirtLevel.FILTHY;
        }
    }

    public Cell createFurnitureCell(Point position) {
        int randomIndex = (int) (Math.random() * FURNITURE_IMAGES.length);
        String imagePath = TILE_PATH + FURNITURE_IMAGES[randomIndex];

        return new Cell(position, DirtLevel.CLEAN, true, imageLoader.loadImage(imagePath));
    }

    public Cell createWallCell(Point position) {
        return new Cell(position, DirtLevel.CLEAN, true, imageLoader.loadImage(TILE_PATH + "default_wall.png")); // Default image for walls
    }
}
