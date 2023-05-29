package org.tricodex.model;

import org.tricodex.utils.abstracts.Entity;
import org.tricodex.utils.enums.DirtLevel;

import java.awt.*;

public class Cell extends Entity {
    private DirtLevel dirtLevel;
    private boolean hasFurniture;

    public Cell(Point position, DirtLevel dirtLevel, boolean hasFurniture) {
        super(position);
        this.dirtLevel = dirtLevel;
        this.hasFurniture = hasFurniture;
    }

    public void clean() {
        dirtLevel = dirtLevel.previous();
    }

    public void increaseDirtLevel() {
        dirtLevel = dirtLevel.next();
    }

    public boolean hasFurniture() {
        return hasFurniture;
    }

    public DirtLevel getDirtLevel() {
        return dirtLevel;
    }
}
