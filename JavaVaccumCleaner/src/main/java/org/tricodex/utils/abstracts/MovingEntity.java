package org.tricodex.utils.abstracts;

import org.tricodex.model.Surface;
import org.tricodex.utils.enums.MoveDirection;

import java.awt.*;

public abstract class MovingEntity extends Entity {

    protected Surface surface;
    protected int offset = 32;

    public MovingEntity(Point position, Surface surface) {
        super(position);
        this.surface = surface;
    }

    protected void move(MoveDirection direction, int speed) {
        switch (direction) {
            case UP -> position.y = Math.max(position.y - speed, 0);
            case DOWN -> position.y = Math.min(position.y + speed, surface.getHeight() - offset);
            case LEFT -> position.x = Math.max(position.x - speed, 0);
            case RIGHT ->  position.x = Math.min(position.x + speed, surface.getWidth() - offset);
        }
    }

}
