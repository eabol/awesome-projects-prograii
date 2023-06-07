package org.tricodex.model;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.MoveObject;
import org.tricodex.utils.abstracts.MovingEntity;
import org.tricodex.utils.interfaces.RandomMoveable;

import java.awt.*;

public class Cat extends MovingEntity implements RandomMoveable {
    private MoveObject moveObject;

    public Cat(Point position, int speed, CellManager cellManager, int scale) {
        super(position, speed, cellManager, scale);
        System.out.println("Super constructor called in Cat");
        this.moveObject = new MoveObject(position.x, position.y, speed, 5, cellManager);
        System.out.println("MoveObject created in Cat");
        moveObject.generateRandomTarget(cellManager.getMapWidth(), cellManager.getMapHeight());
        System.out.println("generateRandomTarget called in Cat");
    }

    @Override
    public void moveRandomly() {
        if (moveObject.getCurrentLocation().distance(moveObject.getTargetLocation()) < speed) {
            moveObject.generateRandomTarget(cellManager.getMapWidth(), cellManager.getMapHeight());
        }
        moveObject.moveToTarget();
        position = new Point(moveObject.getCurrentLocation());
    }

    public void catFoul(){
        cellManager.getCellByPoint(position).increaseDirtLevel();
    }
}
