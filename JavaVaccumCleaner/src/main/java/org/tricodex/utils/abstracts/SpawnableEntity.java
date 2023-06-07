package org.tricodex.utils.abstracts;

import java.awt.*;

import org.tricodex.model.manager.CellManager;


public abstract class SpawnableEntity extends MovingEntity {

    public SpawnableEntity(Point position, int speed, CellManager cellManager, int scale) {
        super(position, speed, cellManager, scale);

    }

    public Point setRandomPosition() {
        this.position.x = (int) (Math.random() * (cellManager.getMapWidth() + 1));
        this.position.y = (int) (Math.random() * (cellManager.getMapHeight() + 1));

        return new Point(position.x, position.y);
    }


}

