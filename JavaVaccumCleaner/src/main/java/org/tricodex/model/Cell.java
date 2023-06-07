package org.tricodex.model;

import org.tricodex.utils.abstracts.Entity;
import org.tricodex.utils.enums.DirtLevel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cell extends Entity {
    private DirtLevel dirtLevel;
    private final boolean isCollidable;
    private final BufferedImage image;

    public Cell(Point position, DirtLevel dirtLevel, boolean isCollidable, BufferedImage image) {
        super(position);
        this.dirtLevel = dirtLevel;
        this.isCollidable = isCollidable;
        this.image = new BufferedImage(image.getColorModel(), image.copyData(null), image.isAlphaPremultiplied(), null);
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

    public DirtLevel getDirtLevel() {
        return dirtLevel;
    }

    public BufferedImage getImage() {
        return new BufferedImage(image.getColorModel(), image.copyData(null), image.isAlphaPremultiplied(), null);
    }
}
