package org.tricodex.model;

import org.tricodex.utils.abstracts.Entity;
import org.tricodex.utils.enums.DirtLevel;
import org.tricodex.view.assets.AssetLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Cell extends Entity {
    private static final String TILE_PATH = "tiles/";
    private DirtLevel dirtLevel;
    private final boolean isCollidable;
    private final Map<DirtLevel, BufferedImage> images;
    private BufferedImage fixedImage;

    public Cell(Point position, DirtLevel dirtLevel, boolean isCollidable, BufferedImage image, int size, AssetLoader imageLoader) {
        super(position, size);
        this.dirtLevel = dirtLevel;
        this.isCollidable = isCollidable;
        this.images = new HashMap<>();

        if (isCollidable) {
            // If the cell is collidable, its image should not change, so we keep a fixed image
            this.fixedImage = new BufferedImage(image.getColorModel(), image.copyData(null), image.isAlphaPremultiplied(), null);
        } else {
            for (DirtLevel level : DirtLevel.values()) {
                String imagePath = TILE_PATH + level.name().toLowerCase() + ".png";
                this.images.put(level, imageLoader.loadImage(imagePath));
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, entitySize, entitySize);
    }

    public void clean() {
        DirtLevel previousDirtLevel = dirtLevel.previous();
        if (previousDirtLevel != null) {
            dirtLevel = previousDirtLevel;
        }
    }

    public void increaseDirtLevel() {
        DirtLevel nextDirtLevel = dirtLevel.next();
        if (nextDirtLevel != null) {
            dirtLevel = nextDirtLevel;
        }
    }
    public boolean canCollide() {
        return isCollidable;
    }

    public BufferedImage getImage() {
        if (isCollidable) {
            return fixedImage;
        } else {
            return this.images.get(dirtLevel);
        }
    }

    public boolean cellIsDirty() {
        return dirtLevel != DirtLevel.CLEAN;
    }
}
