package org.tricodex.utils.abstracts;

import java.awt.*;

public abstract class Entity {
    protected Point position;
    protected int entitySize;

    public Entity(Point position, int entitySize) {
        this.position = position;
        this.entitySize = entitySize;
    }
    public Entity(int entitySize) {
        this.entitySize = entitySize;
        this.position = new Point(0, 0);
    }
    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getEntitySize() {
        return entitySize;
    }
}
