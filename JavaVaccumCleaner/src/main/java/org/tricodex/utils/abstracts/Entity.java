package org.tricodex.utils.abstracts;

import java.awt.*;

public abstract class Entity {
    protected Point position;

    public Entity(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
