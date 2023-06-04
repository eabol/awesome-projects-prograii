package org.tricodex.model;

import org.tricodex.utils.abstracts.Entity;
import org.tricodex.utils.enums.DirtLevel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cell extends Entity {
    private DirtLevel dirtLevel;
    private boolean hasFurniture;
    public BufferedImage image;

    public Cell(Point position, DirtLevel dirtLevel, boolean hasFurniture) {
        super(position);
        this.dirtLevel = dirtLevel;
        this.hasFurniture = hasFurniture;
    }

    public void clean() {
        dirtLevel = dirtLevel.previous();
    }

    public void foul() {
        dirtLevel = dirtLevel.next();
    }

    public void increaseDirtLevel() {
        dirtLevel = dirtLevel.next();
    }

    public boolean hasFurniture() {
        return hasFurniture;
    }
    public void setHasFurniture(boolean setBoolean) {
        hasFurniture = setBoolean;
    }

    public DirtLevel getDirtLevel() {
        return dirtLevel;
    }
}
