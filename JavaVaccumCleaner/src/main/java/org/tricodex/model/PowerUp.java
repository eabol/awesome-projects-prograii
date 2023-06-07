package org.tricodex.model;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.Entity;

import java.awt.*;

public class PowerUp extends Entity {
    Point position;
    CellManager cellManager;

    public PowerUp(Point position, CellManager cellManager) {
        super(position);
        this.cellManager = cellManager;
    }

    public Point randomPosition() {
        this.position.x = (int) (Math.random() * (cellManager.getMapWidth() + 1));
        this.position.y = (int) (Math.random() * (cellManager.getMapHeight() + 1));

        return new Point(position.x, position.y);
    }
    public void spawn() {
        Point spawningPoint = randomPosition();

       if(!cellManager.getCellByPoint(spawningPoint).canCollide()) {
           new PowerUp(spawningPoint, cellManager);
       }

    }

}
