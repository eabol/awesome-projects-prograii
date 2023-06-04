package org.tricodex.utils.abstracts;

import java.awt.*;
import org.tricodex.model.Surface;
import org.tricodex.model.manager.CellManager;


public abstract class SpawnableEntity extends MovingEntity {

    public SpawnableEntity(Point position, Surface surface, int speed, CellManager cellManager) {
        super(position, surface, speed, cellManager);

    }

    public Point setRandomPosition() {
        this.position.x = (int) (Math.random() * (surface.getWidth() + 1));
        this.position.y = (int) (Math.random() * (surface.getWidth() + 1));

        return new Point(position.x, position.y);
    }


}

